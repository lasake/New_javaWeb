package com.zx.simpleweb.object;

import java.util.Iterator;
import java.util.TreeSet;

import com.zx.simpleweb.object.Guest;
import com.zx.simpleweb.object.GuestCompaterator;

public class GuestTest {

	public static void main(String[] args) {
		Guest p=new Guest();
		p.setTime();
		p.setName("�ʹ�");
		
		Guest p1=new Guest();
		p1.setTime();
		p1.setName("������");
		
		Guest p2=new Guest();
		p2.setTime();
		p2.setName("�ٺٺٺ�");
		TreeSet<Guest> tree=new TreeSet<Guest>(new GuestCompaterator());
		tree.add(p);
		tree.add(p1);
		tree.add(p2);
		
		for(Iterator<Guest> i=tree.iterator();i.hasNext();){
            System.out.println(i.next());
    		}
			
	}
	

}
