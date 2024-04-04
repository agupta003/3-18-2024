package com.spring.jdbc.dao;

import com.spring.jdbc.entites.Student;

public interface StudentDoa {
	public int insertQuery(Student student);
	public int updateQuery(Student student);

}
