package com.wjd.oops;

import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.RangeCategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

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
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class Statistics extends Activity implements Runnable{

	boolean live = true;
	Message msg;
	Time time;
	Handler mHandler;
	XYMultipleSeriesDataset dataset;
	XYMultipleSeriesRenderer mrenderer;
	final int UPDATE = 1,FALIE = 2,DELETE = 3,ADD = 4;
	Button statistics_all,statistics_group,statistics_person;
	GraphicalView mChartView;
	CategorySeries mSeries = new CategorySeries("");
	DefaultRenderer mRenderer;
	SimpleSeriesRenderer renderer;
	int num1 = 0, num2 = 0, num3 = 0, select = 0;
	int[] COLORS = new int[] { Color.GREEN, Color.BLUE, Color.CYAN };
	RangeCategorySeries job = new RangeCategorySeries("工作量");
	CategorySeries other = new CategorySeries("其他");
	CategorySeries text = new CategorySeries("测试");
	CategorySeries service = new CategorySeries("服务");
	PointStyle[] styles = new PointStyle[] { PointStyle.POINT, PointStyle.DIAMOND,
	        PointStyle.TRIANGLE, PointStyle.SQUARE };
	LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.statistics);
		init();
		set();
		setData();
		setView();
	}
	
	public void init(){
		new Thread(this).start();
		init_message();
		layout = (LinearLayout) findViewById(R.id.statistics_chart);
		statistics_all = (Button)findViewById(R.id.statistics_all);
		statistics_group = (Button)findViewById(R.id.statistics_group);
		statistics_all.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				select = 0;
				msg = mHandler.obtainMessage(UPDATE);
                mHandler.sendMessage(msg);
			}
			
		});
		statistics_group.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Statistics.this,Select_Dialog.class));
			}
			
		});
	}
	
	public void init_message(){
		Looper looper = Looper.myLooper();
		mHandler = new MyHandler(looper);
	}
	
	public void set(){
		if(select == 0){
			mRenderer = new DefaultRenderer();
			mRenderer.setApplyBackgroundColor(true);
			mRenderer.setBackgroundColor(Color.argb(100, 50, 50, 50));
			mRenderer.setChartTitleTextSize(20);
			mRenderer.setLabelsTextSize(15);
			mRenderer.setLegendTextSize(15);
			mRenderer.setMargins(new int[] { 20, 30, 15, 0 });
			mRenderer.setStartAngle(90);
		}
		if(select == 1){
			dataset = new XYMultipleSeriesDataset();
			mrenderer = buildBarRenderer(COLORS[0]);
			setChartSettings(mrenderer, "日程管理", "周", "工作量", 1, 12,
			        0, 24, Color.GRAY, Color.LTGRAY);
			mrenderer.setDisplayChartValues(true);
			mrenderer.setBarSpacing(1.0f);
		    mrenderer.setXLabels(12);
		    mrenderer.addXTextLabel(1, "1月");
		    mrenderer.addXTextLabel(2, "2月");
		    mrenderer.addXTextLabel(3, "3月");
		    mrenderer.addXTextLabel(4, "4月");
		    mrenderer.addXTextLabel(5, "5月");
		    mrenderer.addXTextLabel(6, "6月");
		    mrenderer.addXTextLabel(7, "7月");
		    mrenderer.addXTextLabel(8, "8月");
		    mrenderer.addXTextLabel(9, "9月");
		    mrenderer.addXTextLabel(10, "10月");
		    mrenderer.addXTextLabel(11, "11月");
		    mrenderer.addXTextLabel(12, "12月");
		    mrenderer.setMargins(new int[] {30, 70, 10, 0});
		    mrenderer.setYLabelsAlign(Align.LEFT);
		    mrenderer.setZoomButtonsVisible(true);
		}
	}
	
	public void setData(){
		if(select == 0){
			num1 = 0;
			num2 = 0;
			num3 = 0;
			for(int i = 0; i < Common.project_list.size(); i++){
				if(Common.project_list.get(i).get("project").toString().equals("其他")){
					num1++;
				}
				if(Common.project_list.get(i).get("project").toString().equals("软件测试")){
					num2++;
				}
				if(Common.project_list.get(i).get("project").toString().equals("服务外包")){
					num3++;
				}
			}
			mSeries.clear();
			mSeries.add("其他", num1);
			renderer = new SimpleSeriesRenderer();
			renderer.setColor(COLORS[0]);
			mRenderer.addSeriesRenderer(renderer);
			mSeries.add("软件测试", num2);
			renderer = new SimpleSeriesRenderer();
			renderer.setColor(COLORS[1]);
			mRenderer.addSeriesRenderer(renderer);
			mSeries.add("服务外包", num3);
			renderer = new SimpleSeriesRenderer();
			renderer.setColor(COLORS[2]);
			mRenderer.addSeriesRenderer(renderer);
		}
		if(select == 1){
			job.clear();
			for(int i = 0; i < 12; i++){
				//job.add(Common.Values[i], Common.job_max_Values[i]);
				job.add(0, Common.job_max_Values[i]);
			}
			dataset.addSeries(job.toXYSeries());
		}
	}
	
	public void setView(){
		if(select == 0){
			layout.removeAllViews();
			mChartView = ChartFactory.getPieChartView(this, mSeries, mRenderer);
			mRenderer.setClickEnabled(true);
		    mRenderer.setSelectableBuffer(10);
		    layout.addView(mChartView, new LayoutParams(LayoutParams.FILL_PARENT,
		            LayoutParams.FILL_PARENT));
		}
		if(select == 1){
			layout.removeAllViews();
			/*dataset = new XYMultipleSeriesDataset();
			setData();*/
		    mrenderer.setChartTitle("工作量统计");
			mChartView = ChartFactory.getRangeBarChartView(Statistics.this, dataset, mrenderer,  Type.DEFAULT);
			mrenderer.setClickEnabled(true);
			mrenderer.setSelectableBuffer(10);
		    layout.addView(mChartView, new LayoutParams(LayoutParams.WRAP_CONTENT,
			          LayoutParams.WRAP_CONTENT));
		}
	}
	
	public XYMultipleSeriesRenderer buildBarRenderer(int colors){
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
	    renderer.setAxisTitleTextSize(16);
	    renderer.setChartTitleTextSize(20);
	    renderer.setLabelsTextSize(15);
	    renderer.setLegendTextSize(15);
	    SimpleSeriesRenderer r = new SimpleSeriesRenderer();
	    r.setColor(colors);
	    renderer.addSeriesRenderer(r);
	    return renderer;
	}
	
	protected void setChartSettings(XYMultipleSeriesRenderer rendere, String title, String xTitle,
		      String yTitle, double xMin, double xMax, double yMin, double yMax, int axesColor,
		      int labelsColor) {
		    rendere.setChartTitle(title);
		    rendere.setXTitle(xTitle);
		    rendere.setYTitle(yTitle);
		    rendere.setXAxisMin(xMin);
		    rendere.setXAxisMax(xMax);
		    rendere.setYAxisMin(yMin);
		    rendere.setYAxisMax(yMax);
		    rendere.setAxesColor(axesColor);
		    rendere.setLabelsColor(labelsColor);
	}
	
	private class MyHandler extends Handler{
		
		public MyHandler(Looper looper) {
			super(looper);
		}
		
		public void handleMessage(Message msg){
			switch(msg.what){
			case UPDATE:
				time = new Time();
				time.init();
				time.ashx();
				set();
				setData();
				setView();
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
				if(Common.login_info.equals("组员工作加载完毕")){
					select = 1;
					System.out.println("22");
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
