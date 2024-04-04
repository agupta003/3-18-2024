package com.demo.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Client {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/config.xml");
		Emp emp1 = ctx.getBean("emp", Emp.class);
	//	Address1 add = ctx.getBean("pata",Address1.class);
		System.out.println(emp1);	
	//	System.out.println(add);	
		
		}

}
