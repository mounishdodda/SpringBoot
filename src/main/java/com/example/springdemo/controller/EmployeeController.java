package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.bean.Address;
import com.example.springdemo.bean.Course;
import com.example.springdemo.bean.Employee;
import com.example.springdemo.bean.Login;
import com.example.springdemo.dto.EmpInputDto;
import com.example.springdemo.dto.EmpOutputDto;
import com.example.springdemo.service.IEmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	IEmployeeService empServ;
	
	// get all employees
	@GetMapping("/employees")
	List<Employee> getAllEmployees() {
		return empServ.getAllEmployees();
	}
	
	//get emp by id
	@GetMapping("/employees/{id}")
	Employee getEmployeeById(@PathVariable("id") int empId) {
		return empServ.getEmpById(empId);
		
	}
	
	//add employee
	@PostMapping("/employees")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee newEmp =  empServ.addEmployee(emp);
		return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
	}
	
	@PostMapping("/employees/dto")
	ResponseEntity<EmpOutputDto> addEmployeeDto(@RequestBody EmpInputDto emp) {
		EmpOutputDto newEmp =  empServ.addEmployeeDto(emp);
		return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
	}
	
	// delete employee
		@DeleteMapping("/employees/{id}")
		ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int id) {
			Employee deletedEmp = empServ.deleteEmpById(id);
			return new ResponseEntity<>(deletedEmp, HttpStatus.OK); // 200 Ok
		}

		
		// update employee
		@PutMapping("/employees")
		ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
			Employee updatedEmp = empServ.updateEmployee(emp);
			return new ResponseEntity<>(updatedEmp, HttpStatus.OK); // 200 Ok
		}
		
		// update emp name
		@PatchMapping("/employees/{id}")
		ResponseEntity<Employee> updateEmpName(@PathVariable("id") int empId, @RequestBody String name) {
			Employee emp = empServ.updateEmpByName(empId, name);
			return new ResponseEntity<>(emp, HttpStatus.OK); // 200 Ok
			
		}
		
		// get emp based on name
		@GetMapping("/employees/byName/{name}")
		ResponseEntity<Employee> getEmpByName(@PathVariable("name") String empName) {
			Employee emp = empServ.getEmpByName(empName);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}
		
		@PatchMapping("/employees/addSalary/{id}")
		ResponseEntity<EmpOutputDto> addSalaryById(@PathVariable("id") int id,@RequestBody double salary) {
			EmpOutputDto newEmp =  empServ.addSalaryById(id,salary);
			return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
		}
		
		@PatchMapping("/employees/addLoginDetails/{id}")
		ResponseEntity<EmpOutputDto> addLoginDetailsById(@PathVariable("id") int id,@RequestBody Login login) {
			EmpOutputDto newEmp =  empServ.addLoginDetailsById(id,login);
			return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
		}
		
		@PatchMapping("/employees/addAddressDetails/{id}")
		ResponseEntity<EmpOutputDto>  addAddressDetailsById(@PathVariable("id") int id,@RequestBody List<Address> address) {
			EmpOutputDto newEmp =  empServ. addAddressDetailsById(id,address);
			return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
		}
		
		@PatchMapping("/employees/addCoursesDetails/{id}")
		ResponseEntity<EmpOutputDto>  addCoursesDetailsById(@PathVariable int id,@RequestBody List<Course> courses) {
			EmpOutputDto newEmp =  empServ. addCoursesDetailsById(id,courses);
			return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
		}
		
		@PatchMapping("/employees/mapAddress/{id}")
		ResponseEntity<Employee>  mapAddress(@PathVariable int id,int addressId) {
			Employee newEmp =  empServ.mapAddress(id,addressId);
			return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
		}
		
		@PatchMapping("/employees/mapCourse/{id}")
		ResponseEntity<Employee>  mapCourse(@PathVariable int id,int courseId) {
			Employee newEmp =  empServ.mapCourse(id,courseId);
			return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
		}
}
