package com.demo.spring.autowiring;

public class Address1 {

	private int unit;
	private String street;
	private String city;
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address: unit=" +unit+ " street=" + street + ", city=" + city ;
	}

	
	
}