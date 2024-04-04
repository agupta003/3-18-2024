package com.demo.spring.noXml.annotaion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Client {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigForIoc.class);
		Emp emp1 = ctx.getBean("getEmp",Emp.class);
		Address1 add = ctx.getBean("getAddress1",Address1.class);
		add.setUnit(1212);
		add.setStreet("Fallondale Rd");
		add.setCity("FortMill");
		emp1.setPata(add);
		System.out.println(emp1.pata);

		}

}
