package com.wjd.oops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wjd.common.Common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
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

public class ProjectManagement extends Activity implements Runnable{

	Handler mHandler;
	Message msg;
	int delete_position;
	MyAdapter adapter;
	final int UPDATE = 1,FALIE = 2,DELETE = 3,ADD = 4;
	HashMap<String,Object> map;
	ListView projecct_ListView;
	boolean live = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.projectmanagement);
		init();
	}
	
	public void init(){
		projecct_ListView = (ListView)findViewById(R.id.projecct_ListView);
		init_data();
	}
	
	public void init_message(){
		Looper looper = Looper.myLooper();
		mHandler = new MyHandler(looper);
	}
	
	public void init_data(){
		init_message();
		Common.project_list.clear();
		Common.client.send("project,");
		new Thread(this).start();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		live = true;
		Common.project_list.clear();
		Common.client.send("project,");
		new Thread(this).start();
		super.onResume();
	}

	public void alert(String message,final String text){
		Builder builder = new Builder(this);
		builder.setTitle("提示");
		builder.setMessage(message);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
				new Thread(ProjectManagement.this).start();
				Common.client.send("delete,"+ Common.name + "," + text);
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
			
		});
		builder.create().show();
	}
	
	private class MyHandler extends Handler{
		
		public MyHandler(Looper looper) {  
			super(looper);
		}
		
		public void handleMessage(Message msg){
			super.handleMessage(msg);
			switch(msg.what){
			case UPDATE:
				adapter = new MyAdapter(ProjectManagement.this);
				projecct_ListView.setAdapter(adapter);
				System.out.println("项目小组加载完成");
				break;
			case DELETE:
				System.out.println(Common.project_list.size());
				Common.project_list.remove(delete_position);
				adapter.notifyDataSetChanged();
				Common.alert(ProjectManagement.this, "删除成功");
				break;
			case FALIE:
				Common.alert(ProjectManagement.this, "您不是组长无权限删除");
				break;
			}
		}
	}
	
	public class MyAdapter extends BaseAdapter {

		private LayoutInflater mInflater;
		public MyAdapter(Context context){
			this.mInflater = LayoutInflater.from(context);
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return Common.project_list.size();
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
			convertView = mInflater.inflate(R.layout.projectmanagement_item, null);
			TextView group = (TextView)convertView.findViewById(R.id.projectmanagement_item_group);
			group.setText(Common.project_list.get(position).get("project").toString());
			final TextView name = (TextView)convertView.findViewById(R.id.projectmanagement_item_name);
			name.setText(Common.project_list.get(position).get("name").toString());
			Button projectmanagement_item_btn = (Button)convertView.findViewById(R.id.projectmanagement_item_btn);
			projectmanagement_item_btn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					live = true;
					alert("是否要删除",name.getText().toString());
					delete_position = position;
					//projecct_ListView.removeViewAt(position);
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
				if(Common.login_info.equals("项目小组加载完成")){
					msg = mHandler.obtainMessage(UPDATE);
	                mHandler.sendMessage(msg);
	                live = false;
	                Common.login_info = "11";
				}
				if(Common.login_info.equals("删除失败")){
					msg = mHandler.obtainMessage(FALIE);
	                mHandler.sendMessage(msg);
	                live = false;
				}
				if(Common.login_info.equals("删除成功")){
					msg = mHandler.obtainMessage(DELETE);
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
