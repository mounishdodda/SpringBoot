package com.example.springdemo.bean;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EmployeeErrorResponse {
	
	private int status;
	private String message;
	private LocalDateTime timeStamp;

}
