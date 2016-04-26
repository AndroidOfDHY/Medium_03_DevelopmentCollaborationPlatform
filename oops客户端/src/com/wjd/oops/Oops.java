package com.wjd.oops;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.wjd.common.Common;
import com.wjd.http.Client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Oops extends Activity {
    
	Button login_btn_login;
	EditText login_edit_account,login_edit_pwd;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.loginpage);
        init();
    }
    
    public void init(){
    	login_btn_login = (Button)findViewById(R.id.login_btn_login);
    	login_edit_account = (EditText)findViewById(R.id.login_edit_account);
    	login_edit_pwd = (EditText)findViewById(R.id.login_edit_pwd);
    	//Common.client = new Client();
    	init_Button();
    }
    
    public void init_Button(){
    	login_btn_login.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Common.name = login_edit_account.getText().toString();
				Common.pass = login_edit_pwd.getText().toString();
				Intent intent = new Intent();
				intent.setClass(Oops.this, Login.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
    		
    	});
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       	MenuInflater inflater = getMenuInflater();
       	inflater.inflate(R.menu.menu, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	int id = item.getItemId();
    	switch(id){
    	case R.id.setting:
    		startActivity(new Intent(Oops.this,Setting.class));
    		break;
    	}
    	return super.onOptionsItemSelected(item);
    }

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode == KeyEvent.KEYCODE_BACK) {
			Common.client = null;Common.login_info = "11";
			Common.num = 0;Common.select = -1;
		}
		return super.onKeyDown(keyCode, event);
	}
    
    
    
}