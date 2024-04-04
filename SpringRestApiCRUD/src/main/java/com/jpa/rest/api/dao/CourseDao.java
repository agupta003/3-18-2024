package com.jpa.rest.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.rest.api.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{

}
