package com.zx.simpleweb.object;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * �ÿ�
 * ������ʱ��
 *
 */
public class Guest {
	private String name;
	private String time;
	
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
	//����ʱ��ΪĬ�ϵ�ǰʱ��
	public void setTime(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.time=dateFormat.format( new Date());
	
	}
	
}
