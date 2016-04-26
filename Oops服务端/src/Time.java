import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Time {
	int year=0;
    int month=0;
    int day=0;
    int flag=0;
    int s = 0;
    int n;
    float hour;
    String start_time,end_time,time[];
    public Time(String num){
    	n = Integer.parseInt(num);
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
		System.out.println(s);
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
			//System.out.println(s);
			c.add(Calendar.DATE, -1);
			//System.out.println("33");
			s--;
		}
		time = sdf.format(c.getTime()).split(" ");
		start_time = time[0] + " 00:00:00";
		for(int i = 1; i <= 6; i++){
			c.add(Calendar.DATE, 1);
		}
		time = sdf.format(c.getTime()).split(" ");
		end_time = time[0] + " 00:00:00";
	}
    
    public float ashx(String sys_time){
		String info[] = sys_time.split(" ");
		hour = Integer.parseInt(info[1].substring(0, 2));
		hour = hour + (Float.parseFloat(info[1].substring(3, 5)) / 60);
		return hour;
	}
    
}
