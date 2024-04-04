package com.demo.spring.basePackage.javaConfig;

import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {
	
	public void Study() {
	System.out.println("Student is reading book"); 
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Student [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
