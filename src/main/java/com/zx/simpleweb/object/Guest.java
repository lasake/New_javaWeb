package com.zx.simpleweb.object;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * 
 * 访客
 * 姓名，时间
 *
 */
public class Guest {
	private String name;
	private String time;
	
	public Guest(){
	
	}
	public Guest(String name,String time)
	{
		this.name=name;
		this.time=time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	//设置时间为默认当前时间
	public void setTime(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.time=dateFormat.format( new Date());
	
	}
	
	@Override
	public String toString() {
	       return this.name+" "+this.time+" ";
	}
	
}
     //@SuppressWarnings("rawtypes")
class GuestCompaterator implements Comparator<Guest>{
    	 @Override
 		public int compare(Guest o1, Guest o2) {
 			// TODO Auto-generated method stub
    		 SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    		 try {
				Date str1date = fmt.parse(o1.getTime());
				Date str2date = fmt.parse(o2.getTime());
				if(str1date.before(str2date)){
					return 1;
				}else{
					return -1;
				}
				
			 } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
    		 return 0;
    		 
 			
 		}
}

		
