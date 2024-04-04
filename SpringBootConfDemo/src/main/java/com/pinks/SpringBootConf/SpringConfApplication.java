package com.pinks.SpringBootConf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringConfApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
				SpringApplication.run(SpringConfApplication.class, args);
				
		System.out.println("............................................................");
	}

}
