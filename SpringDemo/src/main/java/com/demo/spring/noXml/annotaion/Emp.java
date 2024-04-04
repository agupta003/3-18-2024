package com.demo.spring.noXml.annotaion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class Emp {
	//@Autowired
	public Address1 pata;

	
	// If the Getter/ Setter are on class-referance name  and bean (class) is same as class type 
	// then if bean 'name' is same as Address1 referance 'variable-name' then 
	//autowire should happen by 'byName' else it will happen by 'byType'
	  public Address1 getPata() { return pata; }
	 // @Autowired
	  public void setPata(Address1 address) 
	  { 
		  this.pata = address; 
	  }
	  
	  // Created a Default Constructor 
	  
	  public Emp() { 
		  super();
	  }
	  
	   // Created a Parameterized Constructor
	//  @Autowired
	  public Emp(Address1 address) {
			super();
			this.pata = address;
		}
	 
	  @Override public String toString() {
		  return "Emp address=" + pata; 
		  }


	 
	

}
