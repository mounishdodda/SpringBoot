package com.example.springdemo.dto;

import com.example.springdemo.bean.Login;

import lombok.Data;

@Data
public class EmployeeDto {
	
	private String empName;
	private String contactNo;
	private Login login;

}
