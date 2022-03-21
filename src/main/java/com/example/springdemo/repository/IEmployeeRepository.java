package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.bean.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmpName(String name);
	Employee findBySalary(double salary);

}
