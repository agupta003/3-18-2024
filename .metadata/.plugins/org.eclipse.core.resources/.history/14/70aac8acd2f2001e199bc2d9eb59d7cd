package com.demo.spring.lifecycle;

public class Car {

	private double price;

	@Override
	public String toString() {
		return "Car [price=" + price + "]";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		System.out.println("Setting Price");
		this.price = price;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() {System.out.println("Inside init Method");}
	public void destroy() {System.out.println("Inside Destroy Methods");}
}
