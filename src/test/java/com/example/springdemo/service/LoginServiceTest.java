package com.example.springdemo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdemo.bean.Login;

@SpringBootTest
class LoginServiceTest {

	@Autowired
	ILoginService loginServ;
	
	@Test
	void LoginUser() {
		Login log=new Login();
		log.setEmail("mounish@gmail.com");
		log.setPassword("mounish@123");
		Login l=loginServ.login(log);
		assertEquals(true,l.isLogin());
	}

	
	@Test
	void LogoutUser() {
		Login log=new Login();
		log.setEmail("mounish@gmail.com");
		
		Login l=loginServ.logout(log.getEmail());
		assertEquals(false,l.isLogin());
	}
	
//	@Test
//	void resetPassword() {
//		String email="rohit@gmail.com";
//		String oldpass="abc@123";
//		String newpass="rohit@123";
//		Login l=loginServ.resetPassword(email,oldpass,newpass);
//		assertEquals("rohit@123",l.getPassword());
//		
//	}
	
	
}
