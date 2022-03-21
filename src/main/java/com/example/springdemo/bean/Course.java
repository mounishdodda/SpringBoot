package com.example.springdemo.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Course {
	
	@Id
	@GeneratedValue
	private int cid;
	private String cname;


}
