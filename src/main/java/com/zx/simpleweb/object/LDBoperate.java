package com.zx.simpleweb.object;

import org.iq80.leveldb.*;
import static org.iq80.leveldb.impl.Iq80DBFactory.*;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * 用户登录后数据存在这个数据库中
 * 服务器开机打开数据库，关机时关闭
 * 
 * 
 * */
public class LDBoperate {
	private  DB db;
	private  String path = "../data/leveldb";
	private  int num=1;//访问人数包括自己
	private  LinkedHashMap<String,String> beforeVisit;
	//构造函数
	public LDBoperate(){
		beforeVisit = new LinkedHashMap<String,String>();
	}
	//获取num值
	public int getNum() {
			return num;
	}
	
	//创建数据库
	public void create() throws IOException{
			
		try{
			Options options = new Options();
			options.createIfMissing(true);
			db = factory.open(new File(path), options);
				
		}catch(IOException ex){
				System.out.println("数据库创建失败");
		}
			
	}	
	//关闭数据库
	public void destroy()throws IOException{
		try{
			db.close();
		}
		catch(IOException ex){
							
		}
	}	
	//插入数据
	public void put(String key,String value){
		
		db.put(bytes(key), bytes(value));
		
	}
	//递归查询，目前没啥用
	public void dbIterator ()throws IOException{
		
		DBIterator iterator = db.iterator();
		try {
			    for(iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
			    String key = asString(iterator.peekNext().getKey());
			    String value = asString(iterator.peekNext().getValue());
			    System.out.println(key+" = "+value);
			  }
		} finally {
			  // Make sure you close the iterator to avoid resource leaks.
			iterator.close();
	    }
	}
	
	
	//查询之前有多少人，返回之前的人以及人的时间，并将这个人的姓名和时间存入 数据库	
	public LinkedHashMap<String,String> displayPeople(Guest guest) throws IOException{
			
		//beforeVisit = new LinkedHashMap<String,String>();
				//遍历结果集
		DBIterator iterator = db.iterator();
		try {
				num=1;
				for(iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
				String key = asString(iterator.peekNext().getKey());
				String value = asString(iterator.peekNext().getValue());
				beforeVisit.put(key,value);
				num++;
		}
				  
			//将访问者姓名，和日期写入数据库
				db.put(bytes(guest.getName()), bytes(guest.getTime()));
				return beforeVisit;
			
		} finally {
			// Make sure you close the iterator to avoid resource leaks.
				iterator.close();
		}
				
		
	}	
	

}
