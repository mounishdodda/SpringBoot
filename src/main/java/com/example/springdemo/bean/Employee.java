package com.example.springdemo.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue
	private int empId;
	private String empName;
	private String contactNo;
	private  double salary;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emailId")
	private Login login;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="empId")
	private List<Address> address;
	
	public Employee(int empId, String empName, String contactNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.contactNo = contactNo;
	}

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
		name = "employee_course", 
		joinColumns = { @JoinColumn(name = "emp_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "course_id") }
	)
	private List<Course> courses;
	
}
