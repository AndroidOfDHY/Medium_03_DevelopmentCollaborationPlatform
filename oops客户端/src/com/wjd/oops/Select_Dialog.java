package com.wjd.oops;

import java.util.ArrayList;
import java.util.List;

import com.wjd.common.Common;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Select_Dialog extends Activity{

	List<String> select1,select2;
	String str1,str2;
	ArrayAdapter<String> allselect1,allselect2;
	Spinner select_dialog_name,select_dialog_time;
	Button elect_dialog_sure,select_dialog_cancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_dialog);
		init();
	}
	
	public void init(){
		select_dialog_name = (Spinner)findViewById(R.id.select_dialog_name);
		select_dialog_time = (Spinner)findViewById(R.id.select_dialog_time);
		select1 = new ArrayList<String>();
		select1.add("其他");
		select1.add("软件测试");
		select1.add("服务外包");
		allselect1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,select1);
		select_dialog_name.setAdapter(allselect1);
		select_dialog_name.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub
				str1 = select1.get(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		select2 = new ArrayList<String>();
		select2.add("2012");
		allselect2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,select2);
		select_dialog_time.setAdapter(allselect2);
		select_dialog_time.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub
				str2 = select2.get(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		elect_dialog_sure = (Button)findViewById(R.id.select_dialog_sure);
		elect_dialog_sure.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String time1 = str2 + "-01-01 00:00:00";
				String time2 = "" + (Integer.parseInt(str2) + 1) + "-01-01 00:00:00";
				Common.client.send("group,"+str1+","+time1+","+time2);
				Select_Dialog.this.finish();
				System.out.println(str1);
				System.out.println(str2);
			}
			
		});
		select_dialog_cancel = (Button)findViewById(R.id.select_dialog_cancel);
		select_dialog_cancel.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Select_Dialog.this.finish();
			}
			
		});
	}
	
}
