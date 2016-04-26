package com.wjd.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;

import com.wjd.http.Client;

public class Common {
	public static String ip = "192.168.1.101",name,pass,number,login_info = "11",flag;
	public static int num = 0 , select = -1;
	public static List<Map<String,Object>> project_list = new ArrayList<Map<String,Object>>();
	public static List<Map<String,Object>> people_list = new ArrayList<Map<String,Object>>();
	public static HashMap<String,Object> time_info;
	public static Client client;
	public static List<Map<String,Object>> time_list = new ArrayList<Map<String,Object>>();
	public static double[] Values = {-200,-200,-200,-200,-200,-200,-200,-200,-200,-200,-200,-200};
	public static double[] job_max_Values = {-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100};
	public static double[] conference_minValues = {-200,-200,-200,-200,-200,-200,-200};
	public static double[] conference_maxValues = {-100,-100,-100,-100,-100,-100,-100};
	public static double[] project_minValues = {-200,-200,-200,-200,-200,-200,-200};
	public static double[] project_maxValues = {-100,-100,-100,-100,-100,-100,-100};
	public static double[] business_minValues = {-200,-200,-200,-200,-200,-200,-200};
	public static double[] business_maxValues = {-100,-100,-100,-100,-100,-100,-100};
	public static void alert(Context context,String message){
		Builder builder = new Builder(context);
		builder.setTitle("提示");
		builder.setMessage(message);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		builder.create().show();
	}
	
	/*public static void alert1(final Context context,String message){
		Builder builder = new Builder(context);
		builder.setTitle("提示");
		builder.setMessage(message);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
				alert(context,"删除成功");
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
	}*/
	
}
