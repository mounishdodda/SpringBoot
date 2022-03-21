package com.example.springdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.bean.Address;
import com.example.springdemo.bean.Course;
import com.example.springdemo.bean.Employee;
import com.example.springdemo.bean.Login;
import com.example.springdemo.dto.EmpInputDto;
import com.example.springdemo.dto.EmpOutputDto;
import com.example.springdemo.exception.EmployeeNotFoundException;
import com.example.springdemo.repository.IAddressRepository;
import com.example.springdemo.repository.ICourseRepository;
import com.example.springdemo.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
	IEmployeeRepository empRepo;
    
    @Autowired
    IAddressRepository addressRepo;
    
    @Autowired
    ICourseRepository courseRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee getEmpById(int id){
		
		Optional<Employee> opt = empRepo.findById(id);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with the given id: "+id);
		}
		else{
		return opt.get();
	}
	}

	@Override
	public Employee getEmpByName(String name) {
		
		return empRepo.findByEmpName(name);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		
		return empRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// Check given emp is there in db or not
		Employee emp = empRepo.getById(employee.getEmpId());
		
		if(emp!=null) {
			// update emp
			empRepo.save(employee);
			return emp;
		} else {
			return null;
		}
	}

	@Override
	public Employee deleteEmpById(int id) {
		// Check given emp is there in db or not
		Optional<Employee> emp = empRepo.findById(id);
		// delete emp
		if(emp.isPresent()){
			empRepo.deleteById(id);
			return emp.get();
		} else {
			return null;
		}
		
	}

	@Override
	public Employee updateEmpByName(int empId, String name) {
		// Check given emp is there in db or not
				Employee emp = empRepo.getById(empId);
				// delete emp
				if(emp!=null) {
					emp.setEmpName(name);
					empRepo.save(emp);
					return emp;
				}
				else {
					return null;
				}		
		
	}

	@Override
	public Employee updateEmpSalary(int id, double salary) {
		
		       Employee emp=empRepo.getById(id);
		       if(emp!=null) {
		    	   emp.setSalary(salary);
		    	   empRepo.save(emp);
		    	   return emp;
		       }
		       else {
		    	   return null;
		       }
	}

	@Override
	public EmpOutputDto addEmployeeDto(EmpInputDto employee) {
		Employee e1=new Employee();
		e1.setEmpName(employee.getEmpName());
		e1.setContactNo(employee.getContactNo());
		
		
		Employee emp=empRepo.save(e1);
		
		EmpOutputDto res=new EmpOutputDto();
		res.setEmpName(emp.getEmpName());
		res.setContactNo(emp.getContactNo());
		return res;
		
	}

	@Override
	public EmpOutputDto addSalaryById(int id, double salary) {
		Employee e1=empRepo.getById(id);
		e1.setSalary(salary);
		Employee e2=empRepo.save(e1);
		
		EmpOutputDto res=new EmpOutputDto();
		res.setEmpid(e2.getEmpId());
		res.setEmpName(e2.getEmpName());
		res.setContactNo(e2.getContactNo());
		
		return res;
		
	}

	@Override
	public EmpOutputDto addLoginDetailsById(int id,Login login) {
		
		Employee e1=empRepo.getById(id);
		Login l=new Login();
		l.setEmail(login.getEmail());
		l.setPassword(login.getPassword());
		
		e1.setLogin(l);
		
		Employee e2=empRepo.save(e1);
		
		EmpOutputDto res=new EmpOutputDto();
		res.setEmpid(e2.getEmpId());
		res.setEmpName(e2.getEmpName());
		res.setContactNo(e2.getContactNo());
		
		return res;
		
	}

	@Override
	public EmpOutputDto addAddressDetailsById(int id, List<Address> address) {
		Employee e1=empRepo.getById(id);
		e1.setAddress(address);
		
        Employee e2=empRepo.save(e1);
		
		EmpOutputDto res=new EmpOutputDto();
		res.setEmpid(e2.getEmpId());
		res.setEmpName(e2.getEmpName());
		res.setContactNo(e2.getContactNo());
		
		return res;
	}

	@Override
	public EmpOutputDto addCoursesDetailsById(int id, List<Course> courses) {
		
		Employee e1=empRepo.getById(id);
		e1.setCourses(courses);
		
        Employee e2=empRepo.save(e1);
		
		EmpOutputDto res=new EmpOutputDto();
		res.setEmpid(e2.getEmpId());
		res.setEmpName(e2.getEmpName());
		res.setContactNo(e2.getContactNo());
		
		return res;
	}

	@Override
	public Employee mapAddress(int empId, int addressId) {
		
		Employee emp=empRepo.getById(empId);
		//emp.setAddress(a.getAllAddrById(addressid));
		List<Address> addressList=new ArrayList<>();
		Address address=addressRepo.getById(addressId);
		addressList.add(address);
		emp.setAddress(addressList);
		return empRepo.save(emp);
	}

	@Override
	public Employee mapCourse(int empId, int courseId) {
	
		Employee emp=empRepo.getById(empId);
		//emp.setAddress(a.getAllAddrById(addressid));
		List<Course> courseList=new ArrayList<>();
		Course course=courseRepo.getById(courseId);
		courseList.add(course);
		emp.setCourses(courseList);
		return empRepo.save(emp);
	}
}
