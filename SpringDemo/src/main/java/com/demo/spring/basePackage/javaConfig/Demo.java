package com.demo.spring.basePackage.javaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {

		/*
		 * 1. Annotation was not working untill I made changes in the 
		 * POM file to version 5.1.6.RELEASE for Spring core and Spring Context
		 * 
		 * 2. config.xml is not needed for this program 'basePackage' declaration is in javaConfig file 
		 *  */
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		Student student = ctx.getBean("myStudent", Student.class);
		student.Study();
	}

}
