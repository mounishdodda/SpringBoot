package com.example.springdemo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.springdemo.bean.Login;
import com.example.springdemo.repository.ILoginRepository;

@ExtendWith(SpringExtension.class)
class LoginServiceMockitoTest {

	@InjectMocks
	LoginServiceImpl loginServ;
	
	@MockBean
	ILoginRepository loginRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void login() {
		Login login=new Login("mounish@gmail.com","mounish@123");
		Mockito.when(loginRepo.getById(login.getEmail())).thenReturn(login);
		Login l=loginServ.login(login);
		assertEquals(true,l.isLogin());	
	}
	
	@Test
	void logout() {
		Login login=new Login("mounish@gmail.com","mounish@123");
		Mockito.when(loginRepo.getById(login.getEmail())).thenReturn(login);
		Mockito.when(loginRepo.save(login)).thenReturn(login);
		
		Login l=loginServ.logout(login.getEmail());
		assertEquals(false,l.isLogin());	
	}
	
	@Test
	void resertPassword() {
		String email="rohit@gmail.com";
		String newpass="abc@123";
		String oldpass="rohit@123";
		
		Login l=new Login(email,oldpass);
		
		Mockito.when(loginRepo.getById(email)).thenReturn(l);
		Login res=loginServ.resetPassword(email, oldpass, newpass);
		assertEquals("rohit@gmail.com",res.getEmail());	
		assertEquals("abc@123",res.getPassword());	
		
		
	}

}
