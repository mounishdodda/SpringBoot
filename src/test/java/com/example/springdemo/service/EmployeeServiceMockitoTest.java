package com.example.springdemo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.springdemo.bean.Employee;
import com.example.springdemo.dto.EmpInputDto;
import com.example.springdemo.dto.EmpOutputDto;
import com.example.springdemo.repository.IEmployeeRepository;


@ExtendWith(SpringExtension.class)
class EmployeeServiceMockitoTest {

	@InjectMocks
	EmployeeServiceImpl empService;
	
	@MockBean
	IEmployeeRepository empRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void addEmployeeDtoTest() {
		EmpInputDto empInputDto = new EmpInputDto("Ramesh", "9999911111");
		
		Employee emp=new Employee();
		emp.setEmpName(empInputDto.getEmpName());
		emp.setContactNo(empInputDto.getContactNo());
		
		Mockito.when(empRepo.save(emp)).thenReturn(emp);
		
		EmpOutputDto empOutDto= empService.addEmployeeDto(empInputDto);
		assertEquals("Ramesh",empOutDto.getEmpName());
		assertEquals("9999911111",empOutDto.getContactNo());
	}
	
	@Test
	void getEmpByIdTest() {
		// Employee emp = empService.getEmpById(37);
		Employee employee = new Employee(66,"Mounish Reddy","9996452465");
		Mockito.when(empRepo.findById(66)).thenReturn(Optional.of(employee));
		Employee emp = empService.getEmpById(66);
		assertEquals(66, emp.getEmpId());
		assertEquals("Mounish Reddy", emp.getEmpName());
		assertEquals("9996452465", emp.getContactNo());
		
	}
	
	@Test
	void deleteEmpByIdTest() {
		Employee e=new Employee(78,"Shiva","9999988888");
		Mockito.when(empRepo.findById(78)).thenReturn(Optional.of(e));
		
		Employee res=empService.deleteEmpById(78);
		assertEquals(78,res.getEmpId());
		assertEquals("Shiva",res.getEmpName());
		assertEquals("9999988888",res.getContactNo());
		
	}
	

}
