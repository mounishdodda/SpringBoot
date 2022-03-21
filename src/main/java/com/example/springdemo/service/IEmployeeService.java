package com.example.springdemo.service;

import java.util.List;

import com.example.springdemo.bean.Address;
import com.example.springdemo.bean.Course;
import com.example.springdemo.bean.Employee;
import com.example.springdemo.bean.Login;
import com.example.springdemo.dto.EmpInputDto;
import com.example.springdemo.dto.EmpOutputDto;

public interface IEmployeeService {
	
	List<Employee> getAllEmployees();
	//get emp based on id
	Employee getEmpById(int id);
	// get emp based on name
	Employee getEmpByName(String name);
	// add emp
	EmpOutputDto addEmployeeDto(EmpInputDto employee);
	
	Employee addEmployee(Employee employee);
	// update employee
	Employee updateEmployee(Employee employee);
	// delete employee
	Employee deleteEmpById(int id);
	// update emp name
	Employee updateEmpByName(int empId, String name);
	// update emp salary
	Employee updateEmpSalary(int id, double salary);
	
	EmpOutputDto addSalaryById(int id,double salary);
	
	EmpOutputDto addLoginDetailsById(int id,Login login);
	
	EmpOutputDto addAddressDetailsById(int id,List<Address> address);
	
	EmpOutputDto addCoursesDetailsById(int id,List<Course> address);
	
	Employee mapAddress(int empid,int addressid);
	
	Employee mapCourse(int empId,int courseId);

}
