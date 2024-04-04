package com.demo.spring.Interface.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class House implements InitializingBean , DisposableBean{
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "House Service Method - House [price=" + price + "]";
	}

	public House() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// This method will work as init methoid
		System.out.println("House Initializing init Method");
		
	}

	@Override
	public void destroy() throws Exception {
		// this will destry the instance 
		System.out.println("House destroy bean/-instance");
		
	}
	
}
