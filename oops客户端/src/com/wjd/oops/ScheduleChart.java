package com.wjd.oops;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.RangeCategorySeries;
import org.achartengine.model.SeriesSelection;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

import com.wjd.common.Common;
import com.wjd.http.Time;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ScheduleChart extends Activity implements Runnable{

	Handler mHandler;
	Message msg;
	int select;
	double rect[] = new double[2];
	final int UPDATE = 1,FALIE = 2,DELETE = 3,ADD = 4;
	int[] colors = new int[] { Color.BLUE, Color.GREEN, Color.YELLOW };
	String info,content[];
	RangeCategorySeries conference = new RangeCategorySeries("会议");
	RangeCategorySeries project = new RangeCategorySeries("项目");
	RangeCategorySeries business = new RangeCategorySeries("出差");
	XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
	XYMultipleSeriesRenderer renderer;
	GraphicalView mChartView;
	Button today,left,right;
	LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.chart);
		new Thread(this).start();
		init();
		Common.client.send("schedule," + "0");
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		renderer = buildBarRenderer(colors);
		set();
	}
	
	public void init(){
		rect[0] = 2.0;
		rect[1] = 2.0;
		today = (Button)findViewById(R.id.chart_today);
		today.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Common.num = 0;
				Common.client.send("schedule," + ""+Common.num);
			}
			
		});
		left = (Button)findViewById(R.id.chart_left);
		left.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Common.num = Common.num - 7;
				Common.client.send("schedule," + ""+Common.num);
			}
			
		});
		right = (Button)findViewById(R.id.chart_right);
		right.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Common.num = Common.num + 7;
				Common.client.send("schedule," + ""+Common.num);
			}
			
		});
		init_message();
	}
	
	public void init_message(){
		Looper looper = Looper.myLooper();
		mHandler = new MyHandler(looper);
	}
	
	public void getContnet(){
		conference.clear();
		for(int i = 1; i <= 7; i++){
			info = Common.time_info.get(Time.time1[i-1]).toString();
			content = info.split(",");
			System.out.println(content[0]);
			if(Double.parseDouble(content[2])!=0){
				if(content[0].equals("会议")){
					if(Double.parseDouble(content[1]) != Double.parseDouble(content[2])){
						Common.conference_minValues[i-1] = Double.parseDouble(content[1]);
						Common.conference_maxValues[i-1] = Double.parseDouble(content[2]);
					}
					else{
						Common.conference_minValues[i-1] = 0;
						Common.conference_maxValues[i-1] = 24;
					}
					Common.project_minValues[i-1] = -200;
					Common.project_maxValues[i-1] = -100;
					Common.business_minValues[i-1] = -200;
					Common.business_maxValues[i-1] = -100;
				}
				if(content[0].equals("出差")){
					if(Double.parseDouble(content[1]) != Double.parseDouble(content[2])){
						Common.business_minValues[i-1] = Double.parseDouble(content[1]);
						Common.business_maxValues[i-1] = Double.parseDouble(content[2]);
					}
					else{
						Common.business_minValues[i-1] = 0;
						Common.business_maxValues[i-1] = 24;
					}
					Common.conference_minValues[i-1] = -200;
					Common.conference_maxValues[i-1] = -100;
					Common.project_minValues[i-1] = -200;
					Common.project_maxValues[i-1] = -100;
				}
				if(content[0].equals("项目")){
					if(Double.parseDouble(content[1]) != Double.parseDouble(content[2])){
						Common.project_minValues[i-1] = Double.parseDouble(content[1]);
						Common.project_maxValues[i-1] = Double.parseDouble(content[2]);
					}
					else{
						Common.project_minValues[i-1] = 0;
						Common.project_maxValues[i-1] = 24;
					}
					Common.conference_minValues[i-1] = -200;
					Common.conference_maxValues[i-1] = -100;
					Common.business_minValues[i-1] = -200;
					Common.business_maxValues[i-1] = -100;
				}
			}
			else{
				Common.conference_minValues[i-1] = -200;
				Common.conference_maxValues[i-1] = -100;
				Common.project_minValues[i-1] = -200;
				Common.project_maxValues[i-1] = -100;
				Common.business_minValues[i-1] = -200;
				Common.business_maxValues[i-1] = -100;
			}
		}
		int length = Common.conference_minValues.length;
		conference.clear();
		project.clear();
		business.clear();
	    for (int k = 0; k < length; k++){
	    	conference.add(Common.conference_minValues[k], Common.conference_maxValues[k]);
	    	project.add(Common.project_minValues[k],Common.project_maxValues[k]);
	    	business.add(Common.business_minValues[k],Common.business_maxValues[k]);
	    }
	    dataset.addSeries(conference.toXYSeries());
	    dataset.addSeries(project.toXYSeries());
	    dataset.addSeries(business.toXYSeries());
	}
	
	private class MyHandler extends Handler{
		
		public MyHandler(Looper looper) {
			super(looper);
		}
		
		public void handleMessage(Message msg){
			super.handleMessage(msg);
			switch(msg.what){
				case UPDATE:
					if (mChartView == null) {
					    layout = (LinearLayout) findViewById(R.id.chart);
						mChartView = ChartFactory.getRangeBarChartView(ScheduleChart.this, dataset, renderer,  Type.DEFAULT);
					    renderer.setClickEnabled(true);
					    renderer.setSelectableBuffer(10);
					    renderer.setChartTitle(Time.start_time+"-"+Time.end_time);
					    layout.addView(mChartView, new LayoutParams(LayoutParams.WRAP_CONTENT,
						          LayoutParams.WRAP_CONTENT));
					}
					else{
						layout.removeAllViews();
						dataset = new XYMultipleSeriesDataset();
						dataset.addSeries(conference.toXYSeries());
					    dataset.addSeries(project.toXYSeries());
					    dataset.addSeries(business.toXYSeries());
					    renderer.setChartTitle(Time.start_time+"-"+Time.end_time);
						mChartView = ChartFactory.getRangeBarChartView(ScheduleChart.this, dataset, renderer,  Type.DEFAULT);
					    renderer.setClickEnabled(true);
					    renderer.setSelectableBuffer(10);
					    layout.addView(mChartView, new LayoutParams(LayoutParams.WRAP_CONTENT,
						          LayoutParams.WRAP_CONTENT));
					}
					mChartView.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							try{
								SeriesSelection seriesSelection = mChartView.getCurrentSeriesAndPoint();
								if (seriesSelection != null) {
									select = (int)seriesSelection.getXValue();
									Common.select = select;
									startActivity(new Intent(ScheduleChart.this,Dialog.class));
									/*info = Common.time_info.get(Time.time1[select-1]).toString();
									System.out.println(Time.time1[select-1]);
									System.out.println(Common.time_info.get(Time.time1[select-1]).toString());*/
								}
							}catch(Exception e){
								
							}
							
						}
						
					});
				break;
			}
		}
		
	}
	
	public void set(){
		setChartSettings(renderer, "日程管理", "周", "时间", 0.5, 7,
		        0, 24, Color.GRAY, Color.LTGRAY);
		renderer.setDisplayChartValues(true);
		renderer.setBarSpacing(1.0f);
	    renderer.setXLabels(7);
	    renderer.setChartValuesTextSize((float)2.0);
	    renderer.addXTextLabel(1, "星期一");
	    renderer.addXTextLabel(2, "星期二");
	    renderer.addXTextLabel(3, "星期三");
	    renderer.addXTextLabel(4, "星期四");
	    renderer.addXTextLabel(5, "星期五");
	    renderer.addXTextLabel(6, "星期六");
	    renderer.addXTextLabel(7, "星期日");
	    renderer.setMargins(new int[] {30, 70, 10, 0});
	    renderer.setYLabelsAlign(Align.LEFT);
	    renderer.setZoomButtonsVisible(true);
	    //renderer.setPanEnabled(false, true);
	    renderer.setPanLimits(new double[]{0,8,0,24});
	    SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
	    r.setDisplayChartValues(true);
	    r.setChartValuesTextSize(10);
	    r.setChartValuesSpacing(3);
	    if(renderer.getSeriesRendererAt(1) != null){
	    	SimpleSeriesRenderer r1 = renderer.getSeriesRendererAt(1);
		    r1.setDisplayChartValues(true);
		    r1.setChartValuesTextSize(10);
		    r1.setChartValuesSpacing(3);
	    }
	    if(renderer.getSeriesRendererAt(2) != null){
	    	SimpleSeriesRenderer r2 = renderer.getSeriesRendererAt(2);
		    r2.setDisplayChartValues(true);
		    r2.setChartValuesTextSize(10);
		    r2.setChartValuesSpacing(3);
	    }
	    //r.setColor(Color.WHITE);
	    //r.setGradientEnabled(true);
	    //r.setGradientEnabled(false);
	    //r.setGradientStart(-20, Color.BLUE);
	    //r.setGradientStop(20, Color.BLUE);
	}
	
	public XYMultipleSeriesRenderer buildBarRenderer(int[] colors){
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
	    renderer.setAxisTitleTextSize(16);
	    renderer.setChartTitleTextSize(20);
	    renderer.setLabelsTextSize(15);
	    renderer.setLegendTextSize(15);
	    int length = colors.length;
	    for (int i = 0; i < length; i++) {
	      SimpleSeriesRenderer r = new SimpleSeriesRenderer();
	      r.setColor(colors[i]);
	      renderer.addSeriesRenderer(r);
	    }
	    return renderer;
	}
	
	protected void setChartSettings(XYMultipleSeriesRenderer renderer, String title, String xTitle,
		      String yTitle, double xMin, double xMax, double yMin, double yMax, int axesColor,
		      int labelsColor) {
		    renderer.setChartTitle(title);
		    renderer.setXTitle(xTitle);
		    renderer.setYTitle(yTitle);
		    renderer.setXAxisMin(xMin);
		    renderer.setXAxisMax(xMax);
		    renderer.setYAxisMin(yMin);
		    renderer.setYAxisMax(yMax);
		    renderer.setAxesColor(axesColor);
		    renderer.setLabelsColor(labelsColor);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(100);
				if(Common.login_info.equals("日程管理加载完毕")){
					getContnet();
					msg = mHandler.obtainMessage(UPDATE);
	                mHandler.sendMessage(msg);
	                Common.login_info = "11";
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
