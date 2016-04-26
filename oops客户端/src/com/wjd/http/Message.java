package com.wjd.http;

import java.util.HashMap;

import com.wjd.common.Common;

public class Message {
	HashMap<String,Object> map;
	public void decomposition(String talk){
		String info[] = talk.split(","); 
		if(info[0].equals("登录成功")){
			Common.login_info = "登录成功";
			Common.flag = info[1];
			//System.out.println(info[1]);
			//Common.flag = info[0];
		}
		if(info[0].equals("登录失败")){
			Common.login_info = "登录失败";
		}
		if(info[0].equals("project")){
			Common.project_list.clear();
			int row = (info.length - 1)/6;
			for(int i = 0; i <= row; i++){
				map = new HashMap<String,Object>();
				if(i*6+1 > info.length - 1){
					map.put("project", null);
				}
				else{
					map.put("project", info[i*6+1]);
				}
				if(i*6+2 > info.length - 1){
					map.put("name", null);
				}
				else{
					map.put("name", info[i*6+2]);
				}
				if(i*6+3 > info.length - 1){
					map.put("number", null);
				}
				else{
					map.put("number", info[i*6+3]);
				}
				if(i*6+4 > info.length - 1){
					map.put("phone", null);
				}
				else{
					map.put("phone", info[i*6+4]);
				}
				if(i*6+5 > info.length - 1){
					map.put("qq", null);
				}
				else{
					map.put("qq", info[i*6+5]);
				}
				if(i*6+6 > info.length - 1){
					map.put("address", null);
				}
				else{
					map.put("address", info[i*6+6]);
				}
				Common.project_list.add(map);
			}
			Common.login_info = "项目小组加载完成";
		}
		if(info[0].equals("people")){
			Common.people_list.clear();
			int row = (info.length - 1)/5;
			for(int i = 0; i <= row; i++){
				map = new HashMap<String,Object>();
				if(i*5+1 > info.length - 1){
					map.put("name", null);
				}
				else{
					map.put("name", info[i*5+1]);
				}
				if(i*5+2 > info.length - 1){
					map.put("number", null);
				}
				else{
					map.put("number", info[i*5+2]);
				}
				if(i*5+3 > info.length - 1){
					map.put("phone", null);
				}
				else{
					map.put("phone", info[i*5+3]);
				}
				if(i*5+4 > info.length - 1){
					map.put("qq", null);
				}
				else{
					map.put("qq", info[i*5+4]);
				}
				if(i*5+5 > info.length - 1){
					map.put("address", null);
				}
				else{
					map.put("address", info[i*5+5]);
				}
				Common.people_list.add(map);
			}
			Common.login_info = "人员加载完成";
		}
		if(info[0].equals("schedule")){
			new Time().week_time();
			int row = (info.length - 1)/6;
			System.out.println(row);
			for(int i = 0; i < row; i++){
				Common.time_info.put(info[i*6+4], info[i*6+1]+","+info[i*6+2]+","+info[i*6+3]+","+info[i*6+5]+","+info[i*6+6]);
				System.out.println(info[i*6+1]+","+info[i*6+2]+","+info[i*6+3]+","+info[i*6+5]+","+info[i*6+6]);
			}
			Common.login_info = "日程管理加载完毕";
		}
		if(info[0].equals("group")){
			Common.time_list.clear();
			int row = (info.length - 1)/2;
			for(int i = 0; i < row; i++){
				map = new HashMap<String,Object>();
				map.put("begintime", info[i*2+1]);
				map.put("endtime", info[i*2+2]);
				Common.time_list.add(map);
			}
			Common.login_info = "组员工作加载完毕";
		}
		if(info[0].equals("delete")){
			Common.login_info = info[1];
		}
		if(info[0].equals("modify")){
			Common.login_info = info[1];
		}
		if(info[0].equals("deletepeople")){
			Common.login_info = info[1];
		}
	}
}
