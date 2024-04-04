package com.jpa.rest.api.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.rest.api.entities.Course;
import com.jpa.rest.api.service.CoursesService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
public class CoursesControler {
	
	@Autowired
	private CoursesService cs;
	
	@GetMapping("/home")
	public String home() {
	return "Welcome to home Page of Courses Application.";
	}
	
	// Get courses 
	
	 @GetMapping("/courses") public List <Course> getCourses(){
	 return this.cs.getCourse();
	 }
	 
	
	// If for the above method I need to use @RequestMapping 
	/*
	 * @RequestMapping(path = "/courses", method = RequestMethod.GET) public List
	 * <Course> getCourses(){
	 * 
	 * return this.cs.getCourse();
	 * 
	 * }
	 */
	//Get the course by Course Id 
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.cs.getCourse(Long.parseLong(courseId));
	}
	
	//Get the course added
	@PostMapping("/courses")
	public Course addCourses(@RequestBody Course course) {
		return this.cs.addCourse(course);
	}
	
	//Get the course updated
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		
		return this.cs.updateCourse(course);
	}
	
	//Get the course deleted
	@DeleteMapping("/courses/{courseId}")
	public void delete(@PathVariable String courseId) {
		
		this.cs.delete(Long.parseLong(courseId));
	}
	
	//delete the course
	@DeleteMapping("/durgesh_courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.cs.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
}
