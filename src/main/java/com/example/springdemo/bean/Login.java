package com.example.springdemo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Login {
	
	@Id
	private String email;
	private String password;
	@JsonIgnore
	private boolean isLogin;
	
    public Login(){}
	
	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public Login(String email, String password, boolean isLogin) {
		super();
		this.email = email;
		this.password = password;
		this.isLogin = isLogin;
	}

}
