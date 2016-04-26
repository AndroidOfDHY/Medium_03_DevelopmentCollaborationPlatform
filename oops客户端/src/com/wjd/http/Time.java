package com.wjd.http;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.wjd.common.Common;

public class Time {
	
	int year=0;
    int month=0;
    int day=0;
    int flag=0;
    int s = 0,n = 0;
    float hour;
    public static String start_time,end_time,time[];
    public static String time1[] = new String[7];
    String time2[] = new String[7];
    String info[];
    
    public void week_time(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		year=c.get(Calendar.YEAR);
		month=c.get(Calendar.MONTH)+1;
		day=c.get(Calendar.DAY_OF_MONTH);
		Date date = new Date();
		date.setYear(year); 
		date.setMonth(month+1);
		date.setDate(day);
		flag = date.getDay();
		s = flag;
		if(s == 0){
			s = 7;
		}
		Common.time_info = new HashMap<String,Object>();
		n = Common.num;
		if(n < 0){
			while(n!=0){
				c.add(Calendar.DATE, -1);
				n++;
			}
		}
		else{
			while(n!=0){
				c.add(Calendar.DATE, 1);
				n--;
			}
		}
		while(s!=1){
			c.add(Calendar.DATE, -1);
			s--;
		}
		info = sdf.format(c.getTime()).split(" ");
		start_time = info[0];
		time1[0] = info[0];
		time2[0] = "ÐÇÆÚ1";
		Common.time_info.put(time1[0], time2[0]);
		Common.time_info.put(time1[0], "0,0,0");
		for(int i = 1; i <= 6; i++){
			c.add(Calendar.DATE, 1);
			info = sdf.format(c.getTime()).split(" ");
			time1[i] = info[0];
			time2[i] = "ÐÇÆÚ"+(i+1);
			Common.time_info.put(time1[i], time2[i]);
			Common.time_info.put(time1[i], "0,0,0");
		}
		time = sdf.format(c.getTime()).split(" ");
		end_time = time[0];
	}
    
    public void ashx(){
    	String bengin_time,end_time;
    	for(int i = 0; i < Common.time_list.size(); i++){
    		bengin_time = Common.time_list.get(i).get("begintime").toString();
    		end_time = Common.time_list.get(i).get("endtime").toString();
    		int result = Integer.parseInt(bengin_time.substring(5, 7));
    		Common.Values[result] = 0;
    		Common.job_max_Values[result]++;
    	}
    }
    
    public void init(){
    	for(int i = 0; i < 12; i++){
    		Common.Values[i] = -200;
    		Common.job_max_Values[i] = 0;
    	}
    }
    
}
