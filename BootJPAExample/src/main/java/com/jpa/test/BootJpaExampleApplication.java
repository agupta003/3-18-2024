package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.DAO.UserRepositery;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {
	 ApplicationContext ctx = SpringApplication.run(BootJpaExampleApplication.class, args);
	 UserRepositery ur =(UserRepositery) ctx.getBean(UserRepositery.class);
	 
	 User user = new User();
	 user.setName("Abhishek");
	 user.setCity("Charlotte");
	 user.setStutas("Synechron Inc.");
	 
	 User user1 = ur.save(user);
	 System.out.println(user1.toString());
	}

}
