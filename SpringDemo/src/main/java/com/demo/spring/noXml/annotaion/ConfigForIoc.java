package com.demo.spring.noXml.annotaion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigForIoc {

	@Bean
	  public Emp getEmp() {
		  Emp emp = new Emp();
		  return emp;
				  
	  }
	
	@Bean
	public Address1 getAddress1() {
		Address1 address1 = new Address1();
		return address1;
	}
}
