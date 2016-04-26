package com.wjd.oops;

import com.wjd.common.Common;
import com.wjd.oops.PersonManagement.MyAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Modify extends Activity implements Runnable{

	EditText modify_account,modify_name,modify_phone,modify_qq,modify_address;
	Button modify_sure,modify_cancel;
	Bundle bundle;
	boolean live = true;
	Handler mHandler;
	Message msg;
	int select_position;
	final int UPDATE = 1,FALIE = 2,DELETE = 3,ADD = 4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modify);
		init();
	}
	
	public void init(){
		bundle = getIntent().getExtras();
		modify_account = (EditText)findViewById(R.id.modify_account);
		modify_name = (EditText)findViewById(R.id.modify_name);
		modify_phone = (EditText)findViewById(R.id.modify_phone);
		modify_qq = (EditText)findViewById(R.id.modify_qq);
		modify_address = (EditText)findViewById(R.id.modify_address);
		modify_sure = (Button)findViewById(R.id.modify_sure);
		modify_sure.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String account = modify_account.getText().toString();
				String name = modify_name.getText().toString();
				String phone = modify_phone.getText().toString();
				String qq = modify_qq.getText().toString();
				String address = modify_address.getText().toString();
				if(phone == null || phone.length() < 1){
					phone = "null";
				}
				System.out.println(phone);
				System.out.println(phone.length());
				if(qq == null || qq.length() < 1){
					qq = "null";
				}
				if(address == null || address.length() < 1){
					address = "null";
				}
				Common.client.send("modify," + account + "," + name + "," + phone + "," + qq + "," + address);
				//select_position = position;
			}
			
		});
		modify_cancel = (Button)findViewById(R.id.modify_cancel);
		modify_cancel.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Modify.this.finish();
			}
			
		});
		init_data();
		init_message();
	}
	
	public void init_message(){
		Looper looper = Looper.myLooper();
		mHandler = new MyHandler(looper);
	}
	
	public void init_data(){
		if(bundle.get("number") != null){
			modify_account.setText(bundle.get("number").toString());
		}
		if(bundle.get("name") != null){
			modify_name.setText(bundle.get("name").toString());
		}
		if(bundle.get("phone") != null){
			modify_phone.setText(bundle.get("phone").toString());
		}
		if(bundle.get("qq") != null){
			modify_qq.setText(bundle.get("qq").toString());
		}
		if(bundle.get("address") != null){
			modify_address.setText(bundle.get("address").toString());
		}
		new Thread(this).start();
	}
	
	private class MyHandler extends Handler{
		
		public MyHandler(Looper looper) {  
			super(looper);
		}
		
		public void handleMessage(Message msg){
			super.handleMessage(msg);
			switch(msg.what){
			case UPDATE:
				Modify.this.finish();
				break;
			case DELETE:
				
				break;
			case FALIE:
				
				break;
			}
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(live){
			try {
				Thread.sleep(100);
				if(Common.login_info.equals("ÐÞ¸Ä³É¹¦")){
					msg = mHandler.obtainMessage(UPDATE);
	                mHandler.sendMessage(msg);
	                live = false;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
