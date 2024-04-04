package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entites.Student;

public class StudentDoaImpl implements StudentDoa{
	
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Student student) {
		
	/* This call will have following Things Implemented
		- Insert / update / Delete dynamic quesries
		- Spring Jdbc Tamplet 
		- you need to add this claaa as bean iin the Config xml file which will have referance of this Jdbc Tamplate referance */ 
		// Insert Query
	String query ="insert into student(id,name,city) values(?,?,?)";
		int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return result;	
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbacTemplate) {
		this.jdbcTemplate = jdbacTemplate;
	}

	
}
