package com.demo.spring.stereoTypecollection.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Client {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/com/demo/spring/stereoTypecollection/annotation/config.xml");
		
		Address1 add = ctx.getBean("address1",Address1.class);
		//add.setUnit(8000);
		//add.setStreet("Fallondale Rd");
		//add.setCity("Waxhow");
		
		Emp emp1 = ctx.getBean("emp", Emp.class);
		System.out.println(add.getCity());
		System.out.println(emp1);	
		System.out.println(add.getClass().getClass().getName());	
		
		}

}
