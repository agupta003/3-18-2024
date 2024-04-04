package com.spring.jdbc;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class App {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		System.out.println("My Program Started");
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/Config.xml");
		JdbcTemplate tmp = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		//Insert Query
		String query ="insert into student(id,name,city) values(?,?,?)";
		//Fire the query 
		int result = tmp.update(query, 225,"John", "FortMill");
		System.out.println("Number of record inserted :" + result);
		
}
}