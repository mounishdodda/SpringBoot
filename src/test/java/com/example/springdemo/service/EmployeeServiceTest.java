package com.example.springdemo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdemo.bean.Employee;
import com.example.springdemo.dto.EmpInputDto;
import com.example.springdemo.dto.EmpOutputDto;

@SpringBootTest
class EmployeeServiceTest {

	@Autowired
	IEmployeeService empServ;
	
	@Test
	void getAllEmployees() {
		
		List<Employee> emp=empServ.getAllEmployees();
		int no=emp.size();
		assertEquals(5,no);
	}
	
	@Test
	void getEmpByIdTest() {
		Employee emp=empServ.getEmpById(66);
		assertEquals("Mounish Reddy",emp.getEmpName());
		assertEquals("9996452465",emp.getContactNo());
		assertEquals("mounish@gmail.com",emp.getLogin().getEmail());
		assertEquals("mounish@123",emp.getLogin().getPassword());
		 
	}
	
	@Test
	void addEmployeeDtoTest() {
		
		EmpInputDto e=new EmpInputDto("Shiva","9999988888");
		EmpOutputDto emp=empServ.addEmployeeDto(e);
		assertEquals("Shiva",emp.getEmpName());
		assertEquals("9999988888",emp.getContactNo());
		
	}
	
//	@Test
//	void deleteEmpByIdTest() {
//		
//		Employee emp=empServ.deleteEmpById(77);
//		assertEquals("9999988888",emp.getContactNo());
//		assertEquals("Shiva",emp.getEmpName());
//			
//	}
	
	@Test
	void updateNameByIdTest() {
		Employee emp= empServ.updateEmpByName(76,"Rohit");
		assertEquals("9999988888",emp.getContactNo());
	}
	
	@Test
	void updateSalaryByIdTest() {
		EmpOutputDto emp=empServ.addSalaryById(78,50000.00);
		assertEquals("9999988888",emp.getContactNo());
		assertEquals("Shiva",emp.getEmpName());
			
	}
	

}
