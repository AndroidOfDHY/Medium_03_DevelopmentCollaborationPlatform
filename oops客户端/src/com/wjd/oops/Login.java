package com.wjd.oops;

import com.wjd.common.Common;
import com.wjd.http.Client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

public class Login extends Activity{

	int i = 0;
	boolean live = true;
	ProgressBar login_activity_progressbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login_activity);
		init();
	}
	
	public void init(){
		login_activity_progressbar = (ProgressBar)findViewById(R.id.login_activity_progressbar);
		init_ProgressBar();
	}
	
	public void init_ProgressBar(){
		login_activity_progressbar.setVisibility(View.VISIBLE);
		login_activity_progressbar.setIndeterminate(false);
		login_activity_progressbar.setProgress(0);
		Thread mThread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(live){
					try {
						if(i==0){
							Common.client.send("dl,"+Common.name+","+Common.pass);
						}
						i++;
						login_activity_progressbar.setProgress(i);
						if(Common.login_info.equals("µÇÂ¼³É¹¦")){
							live = false;
							Intent intent = new Intent();
							intent.setClass(Login.this, Main.class);
							intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(intent);
							Login.this.finish();
						}
						if(Common.login_info.equals("µÇÂ¼Ê§°Ü")){
							live = false;
							Login.this.finish();
						}
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
				}
			}
			
		});
		mThread.start();
	}
	
}
