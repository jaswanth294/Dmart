package com.jaswanth;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

public class dmartbean {

	
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	    public void createtable() {
	    	
	    	jt.execute("create table dmart(area varchar2(20),pincode number(7),biscuits varchar2(20),stationary varchar2(20),fruits varchar2(20),soaps varchar2(20),clothes varchar2(30),groceries varchar2(30))");
	        System.out.println("table created successfully");
	    }
	    
	    public void insert() {
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("enter name of area");
	    	String area=sc.next();
	    	
	    	System.out.println("enter pincode");
	    	int pincode=sc.nextInt();
	    	
	    	System.out.println("enter biscuit name");
	    	String biscuits=sc.next();
	    	
	        System.out.println("enter stationary item");
	        String stationary=sc.next();
	        
	        System.out.println("enter fruit name");
	        String fruits=sc.next();
	        
	        System.out.println("enter soap name");
	        String soaps=sc.next();
	        
	        System.out.println("enter cloth brand");
	        String clothes=sc.next();
	        
	        System.out.println("enter grocery");
	         String groceries=sc.next();
	         
	         String insertquery=String.format("insert into dmart values('%s','%d','%s','%s','%s','%s','%s','%s')",area,pincode,biscuits,stationary,fruits,soaps,clothes,groceries);
	                    jt.update(insertquery);
	                    System.out.println("inserted successfully");
	    }
	    
	    public void update() {
	    	
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("enter name of area");
	    	String area=sc.next();
	    	
	    	System.out.println("enter grocery");
	    	String groceries =sc.next();
	    	
	    System.out.println("enter pincode");
	    int pincode=sc.nextInt();
	    	
	    	String updatequery=String.format("update dmart SET area='%s',groceries='%s' where pincode='%d'",area,groceries,pincode);
	    	jt.update(updatequery);
	    	System.out.println("updated successfully");
	    }
	    
	    public void delete() {
	    	
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("enter the pincode to delete record");
	    	int pincode=sc.nextInt();
	    	
	    	String deletequery=String.format("delete from dmart where pincode='%d'",pincode);
	    	jt.update(deletequery);
	    	System.out.println("deleted successfuly");
	    	}
	    
	    public void getone() {
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("enter the soap to get record");
	    	String soaps=sc.next();
	    	
	    	String onerecord=String.format("select * from dmart where soaps='%s'",soaps);
	    	List l=jt.queryForList(onerecord);
	    	Iterator it=l.iterator();
	    	
	    	while (it.hasNext()) {
				Object o =  it.next();
				System.out.println(o.toString());
				
			}
	    }

         public void getall() {
        	 
        	 List l=jt.queryForList("select * from dmart");
        	 Iterator it=l.iterator();
        	 
        	 while (it.hasNext()) {
				Object ob = (Object) it.next();
				System.out.println(ob.toString());
				
			}
         }
}
