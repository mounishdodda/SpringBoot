package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.bean.Address;
import com.example.springdemo.bean.Course;
import com.example.springdemo.bean.Employee;
import com.example.springdemo.service.ICourseService;

@RestController
public class CourseController {
	
	@Autowired
	ICourseService courseServ;
	
	@GetMapping("/courses/{empId}")
	ResponseEntity<List<Course>>  getCoursesById(@PathVariable("empId") int id){
		List<Course> course= courseServ.getCoursesById(id);
		return new ResponseEntity<>(course,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/course/{id}")
	ResponseEntity<Employee> deleteCouseById(@PathVariable("id") int id){
		Employee c=courseServ.deleteCouseById(id);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	@PostMapping("/course")
	ResponseEntity<Course> addCourse(@RequestBody Course course){
	Course c=courseServ.addCourse(course);
	return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	

}
