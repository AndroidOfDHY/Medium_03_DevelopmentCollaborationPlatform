import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import com.mysql.jdbc.Statement;


public class Database {
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/tavatar";
	public static final String DBUSER = "root";
	public static final String DBPASS = "j647279w";
	Connection conn = null;
	Statement stmt = null;
	Time time;
	String start_time,end_time;
	public void connect(){
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void login(String name,String pass,Client client){
		ResultSet resu;
		try {
			Statement sta = (Statement)conn.createStatement();
			resu = sta.executeQuery("select Count(*),flag from user where number = '"+ name +"' and password = '"+ pass +"'");
			System.out.println(pass);
			if(resu.next()){
				if(resu.getInt(1) > 0){
					//System.out.println("µÇÂ¼³É¹¦" + "," + resu.getInt(2));
					client.sendUTF("µÇÂ¼³É¹¦" + "," + resu.getInt(2));
				}
				else{
					System.out.println("µÇÂ¼Ê§°Ü");
					client.sendUTF("µÇÂ¼Ê§°Ü");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getProjectInfo(Client client){
		ResultSet resu;
		try {
			String info = "project,";
			Statement sta = (Statement)conn.createStatement();
			resu = sta.executeQuery("select c_group.`name`,`user`.`name`,`user`.number,`user`.phone,`user`.qq,`user`.address from `user`,c_group where c_group.id = (select group_user.groupid from group_user where group_user.userid = `user`.id)");
			while(resu.next()){
				String c_group_name = resu.getString(1);
				String user_name = resu.getString(2);
				String user_number = resu.getString(3);
				String user_phone = resu.getString(4);
				String user_qq = resu.getString(5);
				String user_address = resu.getString(6);
				info = info + c_group_name+","+user_name+","+user_number+","+user_phone+","+user_qq+","+user_address+",";
			}
			System.out.println(info);
			client.sendUTF(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getPeopleInfo(Client client){
		ResultSet resu;
		String info = "people,";
		try {
			Statement sta = (Statement)conn.createStatement();
			resu = sta.executeQuery("select `user`.`name`,`user`.number,`user`.phone,`user`.qq,`user`.address from `user`");
			while(resu.next()){
				String user_name = resu.getString(1);
				String user_number = resu.getString(2);
				String user_phone = resu.getString(3);
				String user_qq = resu.getString(4);
				String user_address = resu.getString(5);
				info = info + user_name+","+user_number+","+user_phone+","+user_qq+","+user_address+",";
			}
			client.sendUTF(info);
			System.out.println(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getSchedule(Client client,String num){
		
		ResultSet resu;
		String info = "schedule,";
		time = new Time(num);
		start_time = time.start_time;
		end_time = time.end_time;
		try {
			Statement sta = (Statement)conn.createStatement();
			resu = sta.executeQuery("select simplecalendarevent.type,simplecalendarevent.beginDate,simplecalendarevent.endDate,simplecalendarevent.content,simplecalendarevent.title from simplecalendarevent where simplecalendarevent.beginDate >= '"+start_time+"' and simplecalendarevent.endDate <= '"+ end_time +"'");
			while(resu.next()){
				System.out.println(info);
				String type = resu.getString(1);
				String begin_time = "" + time.ashx(resu.getString(2));
				String end_time = "" + time.ashx(resu.getString(3));
				String content = resu.getString(4);
				String title = resu.getString(5);
				info = info + type + "," + begin_time + "," + end_time + "," + resu.getString(2).split(" ")[0]+ "," + content + "," + title +",";
				/*System.out.println(type);
				System.out.println(begin_time);
				System.out.println(end_time);*/
			}
			client.sendUTF(info);
			System.out.println(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getGroup(Client client,String name,String time1,String time2){
		ResultSet resu;
		String info = "group,";
		try {
			Statement sta = (Statement)conn.createStatement();
			resu = sta.executeQuery("select simplecalendarevent.beginDate,simplecalendarevent.endDate from simplecalendarevent where simplecalendarevent.id in (select user_task.taskid from user_task where user_task.c_userid in (select group_user.userid from group_user where group_user.groupid = (select c_group.id from c_group where c_group.`name` = '"+name+"'))) and (simplecalendarevent.beginDate > '"+ time1 +"' and simplecalendarevent.endDate < '"+ time2 +"')");
			while(resu.next()){
				String bengin_time = resu.getString(1);
				String end_time = resu.getString(2);
				info = info + bengin_time +"," + end_time +",";
			}
			client.sendUTF(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletePeople(Client client,String name1,String name2){
		ResultSet resu;
		String info = "delete,";
		String group1 = null,group2 = null;
		int flag1 = 0,flag2 = 0;
		try {
			Statement sta = (Statement)conn.createStatement();
			resu = sta.executeQuery("select group_user.groupid,`user`.flag FROM `user`,group_user where group_user.userid = (select `user`.id from `user` where `user`.number = '"+ name1 +"') and (`user`.number = '"+ name1 +"')");
			while(resu.next()){
				//System.out.println(resu.getInt(1));
				group1 = resu.getString(1);
				System.out.println(group1);
				flag1 = resu.getInt(2);
			}
			resu = sta.executeQuery("select group_user.groupid,`user`.flag FROM `user`,group_user where group_user.userid = (select `user`.id from `user` where `user`.`name` = '"+ name2 +"') and (`user`.`name` = '"+ name2 +"')");
			while(resu.next()){
				group2 = resu.getString(1);
				System.out.println(group2);
				flag2 = resu.getInt(2);
			}
			/*System.out.println(group1);
			System.out.println(group2);*/
			if(group1!=null&&group2!=null&&group1.equals(group2)){
				if(flag1 > flag2){
					info = info + "É¾³ý³É¹¦";
					sta.execute("delete from group_user where group_user.userid = (select `user`.id from `user` where `user`.`name` = '"+ name2 +"')");
				}
				else{
					info = info + "É¾³ýÊ§°Ü";
				}
			}
			else{
				info = info + "É¾³ýÊ§°Ü";
			}
			client.sendUTF(info);
			System.out.println(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletePeople(Client client,String name){
		ResultSet resu;
		String info = "deletepeople,";
		try {
			Statement sta = (Statement)conn.createStatement();
			sta.execute("delete from user_task where user_task.userid = (select `user`.id from `user` where `user`.`name` = '"+ name +"')");
			sta.execute("delete from group_user where group_user.userid = (select `user`.id from `user` where `user`.`name` = '"+ name +"')");
			sta.execute("DELETE from `user` where `user`.`name` = '"+ name +"'");
			info = info + "É¾³ýÈËÔ±³É¹¦";
			System.out.println(info);
			client.sendUTF(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modidy_info(Client client, String account, String name, String phone , String qq, String address){
		ResultSet resu;
		String info = "modify,";
		if(phone.equals("null")){
			phone = "";
		}
		if(qq.equals("null")){
			qq = "";
		}
		if(address.equals("null")){
			address = "";
		}
		String sql = "update `user` set `user`.name = '"+ name +"',`user`.phone = '"+ phone +"',`user`.qq = '"+ qq +"',`user`.address = '"+ address +"' where `user`.number = '"+ account +"'";
		try {
			Statement sta = (Statement)conn.createStatement();
			System.out.println(sql);
			sta.execute(sql);
			info = info + "ÐÞ¸Ä³É¹¦";
			client.sendUTF(info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
