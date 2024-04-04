package com.spring.jdbc;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDoa;
import com.spring.jdbc.dao.StudentDoaImpl;
import com.spring.jdbc.entites.Student;

public class App {

	/**
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {

		System.out.println("My Program Started");
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/Config.xml");
		StudentDoa stuDaoObj =  ctx.getBean("studentDaoimpl",StudentDoa.class);
		Student stu = new Student();
		stu.setId(211);
		stu.setName("Kush Gupta");
		stu.setCity("Charlotte");
		int result = stuDaoObj.updateQuery(stu);
		System.out.println("Student Records are updated " + result + " Record_Count :");
		System.out.println("**********End of Execution**********");
		
}
}