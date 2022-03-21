package com.example.springdemo.service;

import java.util.List;

import com.example.springdemo.bean.Course;
import com.example.springdemo.bean.Employee;

public interface ICourseService {

	
	List<Course> getCoursesById(int id);
	Course addCourse(Course course);
	Employee deleteCouseById(int id);
	Course updateCourse(Course course);
}
