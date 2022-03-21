package com.example.springdemo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Address {
	
	@Id
	@GeneratedValue
	private int addrId;
	private String city;
	private String state;

	
}
