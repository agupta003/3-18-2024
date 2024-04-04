package com.demo.spring.Interface.lifecycle;

public class Car {

	private double price;

	@Override
	public String toString() {
		return "Car Service Method Car [price=" + price + "]";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() {System.out.println("Car initialization init Method");}
	public void destroy() {System.out.println("Car Destroy Methods");}
}
