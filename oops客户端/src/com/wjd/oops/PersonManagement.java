package com.wjd.oops;

import com.wjd.common.Common;
import com.wjd.oops.ProjectManagement.MyAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class PersonManagement extends Activity implements Runnable{

	ListView person_ListView;
	Handler mHandler;
	Message msg;
	Bundle bundle;
	int delete_position;
	MyAdapter adapter;
	final int UPDATE = 1,FALIE = 2,DELETE = 3,ADD = 4;
	boolean live = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personmanagement);
		init();
	}
	
	public void init(){
		person_ListView = (ListView)findViewById(R.id.person_ListView);
		init_message();
		new Thread(this).start();
	}
	
	public void init_message(){
		Looper looper = Looper.myLooper();
		mHandler = new MyHandler(looper);
		Common.client.send("people");
	}
	
	private class MyHandler extends Handler{
		
		public MyHandler(Looper looper) {  
			super(looper);
		}
		
		public void handleMessage(Message msg){
			super.handleMessage(msg);
			switch(msg.what){
			case UPDATE:
				adapter = new MyAdapter(PersonManagement.this);
				person_ListView.setAdapter(adapter);
				break;
			case DELETE:
				Common.people_list.remove(delete_position);
				adapter.notifyDataSetChanged();
				Common.alert(PersonManagement.this, "删除成功");
				break;
			case FALIE:
				
				break;
			}
		}
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		live = true;
		new Thread(this).start();
		Common.client.send("people");
		super.onResume();
	}

	public class MyAdapter extends BaseAdapter {

		private LayoutInflater mInflater;
		public MyAdapter(Context context) {
			this.mInflater = LayoutInflater.from(context);
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return Common.people_list.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			convertView = mInflater.inflate(R.layout.personmanagement_item, null);
			TextView name = (TextView)convertView.findViewById(R.id.personmanagement_item_name);
			TextView account = (TextView)convertView.findViewById(R.id.personmanagement_item_account);
			account.setText(Common.people_list.get(position).get("number").toString());
			name.setText(Common.people_list.get(position).get("name").toString());
			Button personmanagement_item_modify = (Button)convertView.findViewById(R.id.personmanagement_item_modify);
			personmanagement_item_modify.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(Common.name.equals(Common.people_list.get(position).get("name").toString())){
						Common.alert(PersonManagement.this, "管理员无法删除自己");
					}
					else{
						if(Common.name.equals(Common.people_list.get(position).get("number").toString())){
							bundle = new Bundle();
							if(Common.people_list.get(position).get("name") != null){
								bundle.putString("name", Common.people_list.get(position).get("name").toString());
								System.out.println(Common.people_list.get(position).get("name").toString());
							}
							if(Common.people_list.get(position).get("number") != null){
								bundle.putString("number", Common.people_list.get(position).get("number").toString());
								System.out.println(Common.people_list.get(position).get("number").toString());
							}
							if(Common.people_list.get(position).get("phone") != null){
								bundle.putString("phone", Common.people_list.get(position).get("phone").toString());
								System.out.println(Common.people_list.get(position).get("phone").toString());
							}
							if(Common.people_list.get(position).get("qq") != null){
								bundle.putString("qq", Common.people_list.get(position).get("qq").toString());
								System.out.println(Common.people_list.get(position).get("qq").toString());
							}
							if(Common.people_list.get(position).get("address") != null){
								bundle.putString("address", Common.people_list.get(position).get("address").toString());
								System.out.println(Common.people_list.get(position).get("address").toString());
							}
							startActivity(new Intent(PersonManagement.this,Modify.class).putExtras(bundle));
						}
						else{
							Common.alert(PersonManagement.this, "您不是本人无法修改");
							System.out.println(Common.name);
							System.out.println(Common.people_list.get(position).get("number").toString());
						}
					}
				}
				
			});
			Button personmanagement_item_delete = (Button)convertView.findViewById(R.id.personmanagement_item_delete);
			personmanagement_item_delete.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(Common.flag.equals("9")){
						live = true;
						new Thread(PersonManagement.this).start();
						delete_position = position;
						Common.client.send("deletepeople," + Common.people_list.get(position).get("name").toString());
					}
					else{
						Common.alert(PersonManagement.this, "您不是管理员，无法删除");
					}
				}
				
			});
			return convertView;
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(live){
			try {
				Thread.sleep(100);
				if(Common.login_info.equals("人员加载完成")){
					msg = mHandler.obtainMessage(UPDATE);
	                mHandler.sendMessage(msg);
	                live = false;
	                Common.login_info = "11";
	                System.out.println("加载");
				}
				if(Common.login_info.equals("删除人员成功")){
					msg = mHandler.obtainMessage(DELETE);
	                mHandler.sendMessage(msg);
	                live = false;
	                Common.login_info = "11";
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
