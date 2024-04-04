package com.demo.spring.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBenLifeCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/spring/lifecycle/config.xml");
		Object carObject = ctx.getBean("c");
		System.out.println(carObject);
		// Registering Destroy method to get shutdown- so that 
		// IoC container will destroy that bean instance immediately
		ctx.registerShutdownHook();
		
	}

}
