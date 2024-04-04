package com.jpa.rest.api.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jpa.rest.api.entities.Course;

@Service
public class CourseServiceImpl implements CoursesService{

	
	List<Course> list;
	
	public CourseServiceImpl() {
		
		list = new ArrayList<>();
		list.add(new Course(145, "Java Core  Course", "this  course contains basis of java"));
		list.add(new Course(146, "Spring Boot  Course", "Creating Rest api usong Spring Boot"));
		
		
	}
	
	@Override
	public List<Course> getCourse() {

		return list;
	}

	@Override
	public Course getCourse(long courseId) {

		Course c = null;
		
		for(Course course:list) {
			if(course.getId()==courseId) {
				c= course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course addCourse) {
		list.add(addCourse);
		return addCourse;
	}

	@Override
	public Course updateCourse(Course updateCourse) {
		
		Iterator<Course> it = list.iterator();
		while (it.hasNext()){
			Course c =(Course) it.next();
		if ( c!= null && c.getId()==updateCourse.getId()){
		int i = list.indexOf(c);	
		this.list.set( i, updateCourse);
		}
		}
		return updateCourse;
	}

	@Override
	public void deleteCourse(long parseLong) {
		list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}
		
	@Override
	public void delete(long courseId) {
		
	//	list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
	// Above line will work inisted of below all code.... try it later
		Course c = null;
		List<Course> l = new ArrayList();
			Iterator<Course> it = this.list.iterator();
			
			while (it.hasNext()){
				c= it.next();
				 if ((int)c.getId() == courseId){
							//System.out.println("Deleted item is not included in the updated list of courses.");
							
				 }else {
					 l.add(c);
				 }}
			list=l;
	}

	
}
