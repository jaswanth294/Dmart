package com.jaswanth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext context=new ClassPathXmlApplicationContext("spconfig.xml");
    	dmartbean dm=(dmartbean)context.getBean("id3");
    	//dm.createtable();
    	//dm.insert();
    	//dm.update();
    	//dm.delete();
    	//dm.getone();
    	dm.getall();
    }
}
