package com.wjd.oops;

import com.wjd.common.Common;
import com.wjd.http.Client;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Setting extends Activity{

	Button sure,canncel;
	EditText edit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		init();
	}
	
	public void init(){
		edit = (EditText)findViewById(R.id.setting_edit);
		sure = (Button)findViewById(R.id.setting_sure);
		canncel = (Button)findViewById(R.id.setting_canncel);
		sure.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Common.ip = edit.getText().toString();
				Common.client = new Client();
				Setting.this.finish();
			}
			
		});
		canncel.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Setting.this.finish();
			}
			
		});
	}
	
}
