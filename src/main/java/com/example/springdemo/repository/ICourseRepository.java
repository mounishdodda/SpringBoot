package com.example.springdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springdemo.bean.Address;
import com.example.springdemo.bean.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer> {
	
	@Query(value= "select course.cid,course.cname from course join employee_course on course.cid=employee_course.course_id employee_course.emp_id=:eId", nativeQuery = true)
	List<Course> getAllCoursesById(@Param("eId") int id);

}
