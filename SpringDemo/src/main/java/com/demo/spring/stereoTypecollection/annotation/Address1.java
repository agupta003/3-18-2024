package com.demo.spring.stereoTypecollection.annotation;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Address1 {
	
	private int unit;
	private String street;
	@Value("#{temp}")
	private List<String> city;
	public int getUnit() {
		return unit;
	}
	@Value("1463")
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public String getStreet() {
		return street;
	}
	@Value("Bramblewood Rd")
	public void setStreet(String street) {
		this.street = street;
	}

	public List<String> getCity() {
		return city;
	}
	public void setCity(List<String> city) {
		this.city = city;
	}
	/*
	 * public void setCity(String city) { this.city = city; }
	 */
	@Override
	public String toString() {
		return "Address: unit=" +unit+ " street=" + street + ", city=" + city ;
	}

	
	
}