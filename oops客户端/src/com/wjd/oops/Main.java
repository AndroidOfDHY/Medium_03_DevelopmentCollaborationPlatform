package com.wjd.oops;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Main extends TabActivity implements OnCheckedChangeListener{

	private RadioGroup mainTab;
	private TabHost tabhost;
	private Intent iHome;
	private Intent iNews;
	private Intent iInfo;
	private Intent iSearch;
	private Intent iMore;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		init();
	}
	
	public void init(){
		initUI();
	}
	
	public void initUI(){
		mainTab=(RadioGroup)findViewById(R.id.main_tab);
        mainTab.setOnCheckedChangeListener(this);
        tabhost = getTabHost();
        iHome = new Intent(this, ProjectManagement.class);
        tabhost.addTab(tabhost.newTabSpec("iHome")
        		.setIndicator(getResources().getString(R.string.main_home), getResources().getDrawable(R.drawable.icon_1_n))
        		.setContent(iHome));
        
		iNews = new Intent(this, PersonManagement.class);
		tabhost.addTab(tabhost.newTabSpec("iNews")
	        	.setIndicator(getResources().getString(R.string.main_news), getResources().getDrawable(R.drawable.icon_2_n))
	        	.setContent(iNews));
		
		iInfo = new Intent(this, ScheduleChart.class);
		tabhost.addTab(tabhost.newTabSpec("iInfo")
	        	.setIndicator(getResources().getString(R.string.main_my_info), getResources().getDrawable(R.drawable.icon_3_n))
	        	.setContent(iInfo));
		iSearch = new Intent(this, Statistics.class);
		tabhost.addTab(tabhost.newTabSpec("iSearch")
	        	.setIndicator(getResources().getString(R.string.menu_search), getResources().getDrawable(R.drawable.icon_3_n))
	        	.setContent(iSearch));
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId){
		case R.id.radio_button0:
			this.tabhost.setCurrentTabByTag("iHome");
			break;
		case R.id.radio_button1:
			this.tabhost.setCurrentTabByTag("iNews");
			break;
		case R.id.radio_button2:
			this.tabhost.setCurrentTabByTag("iInfo");
			break;
		case R.id.radio_button3:
			this.tabhost.setCurrentTabByTag("iSearch");
			break;
		}
	}
	
}
