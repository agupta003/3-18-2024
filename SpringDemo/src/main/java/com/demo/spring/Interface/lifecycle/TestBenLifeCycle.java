package com.demo.spring.Interface.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBenLifeCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/demo/spring/Interface/lifecycle/config.xml");
		Object CarBean = ctx.getBean("c");
		System.out.println(CarBean);
		// Registering Destroy method to get shutdown- so that 
		// IoC container will destroy that bean instance immediately
		ctx.registerShutdownHook();
		System.out.println("*****************************");
		Object houseObject = ctx.getBean("h");
		System.out.println(houseObject);
	}

}
