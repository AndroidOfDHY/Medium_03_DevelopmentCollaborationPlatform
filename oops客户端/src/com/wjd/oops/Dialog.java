package com.wjd.oops;

import com.wjd.common.Common;
import com.wjd.http.Time;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Dialog extends Activity{

	String time,info[];
	Button dialog_back;
	EditText dialog_time,dialog_endtime,dialog_title,dialog_content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);
		init();
	}
	
	public void init(){
		dialog_time = (EditText)findViewById(R.id.dialog_time);
		dialog_title = (EditText)findViewById(R.id.dialog_title);
		dialog_content = (EditText)findViewById(R.id.dialog_content);
		dialog_back = (Button)findViewById(R.id.dialog_back);
		dialog_back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		init_Data();
	}
	
	public void init_Data(){
		time = Time.time1[Common.select-1];
		dialog_time.setText(time);
		info = Common.time_info.get(Time.time1[Common.select-1]).toString().split(",");
		if(info.length > 3){
			dialog_title.setText(info[3]);
		}
		if(info.length > 4){
			dialog_content.setText(info[4]);
		}
		//dialog_content.setText(info[4]);
		//dialog_starttime.setText(time + );
	}
	
}
