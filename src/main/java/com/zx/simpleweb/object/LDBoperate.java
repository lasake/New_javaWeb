package com.zx.simpleweb.object;

import org.iq80.leveldb.*;
import static org.iq80.leveldb.impl.Iq80DBFactory.*;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

/*
 * �û���¼�����ݴ���������ݿ���
 * ���������������ݿ⣬�ػ�ʱ�ر�
 * 
 * 
 * */
public class LDBoperate {
	private  DB db;
	private  String path = "../data/leveldb";
	
	//���캯��
	public LDBoperate(){
		
	}
	
	
	//�������ݿ�
	public void create() throws IOException{
			
		try{
			Options options = new Options();
			options.createIfMissing(true);
			db = factory.open(new File(path), options);
				
		}catch(IOException ex){
				System.out.println("���ݿⴴ��ʧ��");
		}
			
	}	
	//�ر����ݿ�
	public void destroy()throws IOException{
		try{
			db.close();
		}
		catch(IOException ex){
							
		}
	}	
	//��������
	public void put(String key,String value){
		
		db.put(bytes(key), bytes(value));
		
	}
	//�ݹ��ѯ��Ŀǰûɶ��
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
	
	

	
	public class Operate{
		private  int num=1;//�������������Լ�
		private  TreeSet<Guest> beforeVisit;
		//��ѯ֮ǰ�ж����ˣ�����֮ǰ�����Լ��˵�ʱ�䣬��������˵�������ʱ����� ���ݿ�	
		
		public Operate(){
			beforeVisit = new TreeSet<Guest>(new GuestCompaterator());
		}
		
		public TreeSet<Guest> displayPeople(Guest guest) throws IOException{
				
			//beforeVisit = new LinkedHashMap<String,String>();
					//���������
			DBIterator iterator = db.iterator();
			try {
					num=1;
					for(iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
					beforeVisit.add(new Guest(asString(iterator.peekNext().getKey()),asString(iterator.peekNext().getValue())));
					num++;
			}
					  
				//��������������������д�����ݿ�
					db.put(bytes(guest.getName()), bytes(guest.getTime()));
					return beforeVisit;
				
			} finally {
				// Make sure you close the iterator to avoid resource leaks.
					iterator.close();
			}
					
			
		}
		
		//��ȡnumֵ
		public int getNum() {
				return num;
		}
	}//�ڲ�class
	

}
