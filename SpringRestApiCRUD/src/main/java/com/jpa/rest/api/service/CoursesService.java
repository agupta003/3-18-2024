package com.jpa.rest.api.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jpa.rest.api.entities.Course;

public interface CoursesService {

	public List<Course> getCourse();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void delete(long courseId);
	void deleteCourse(long parseLong);
}
