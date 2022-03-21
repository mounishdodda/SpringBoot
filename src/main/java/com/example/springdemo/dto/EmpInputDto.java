package com.example.springdemo.dto;

import java.util.List;

import com.example.springdemo.bean.Course;

import lombok.Data;

@Data
public class EmpInputDto {
	
	private String empName;
	private String contactNo;
	public EmpInputDto(String empName, String contactNo) {
		super();
		this.empName = empName;
		this.contactNo = contactNo;
	}
     
	EmpInputDto(){}
}
