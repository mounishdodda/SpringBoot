package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.bean.Course;
import com.example.springdemo.bean.Employee;
import com.example.springdemo.repository.ICourseRepository;
import com.example.springdemo.repository.IEmployeeRepository;

@Service
public class CourseServiceImpl implements ICourseService {

	
	@Autowired
	ICourseRepository courseRepo;

	@Autowired
	IEmployeeRepository empRepo;
	
	@Override
	public List<Course> getCoursesById(int id) {
		
		return courseRepo.getAllCoursesById(id);
	}

	@Override
	public Course addCourse(Course course) {
		
		return courseRepo.save(course);
	}

	@Override
	public Employee deleteCouseById(int id) {
		
		Employee emplist=empRepo.getById(id);
		
		if(emplist!=null) {
			empRepo.delete(emplist);
			return emplist;
		}
		else {
			return null;
		}
	}

	@Override
	public Course updateCourse(Course course) {
		
		return null;
	}

}
