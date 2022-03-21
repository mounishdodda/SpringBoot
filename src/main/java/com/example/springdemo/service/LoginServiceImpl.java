package com.example.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.bean.Login;
import com.example.springdemo.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService{
	
	@Autowired
    ILoginRepository loginRepo;

	@Override
	public Login login(Login login) {
		
		Login dblogin= loginRepo.getById(login.getEmail());
		if(login.getEmail().equals(dblogin.getEmail())&& login.getPassword().equals(dblogin.getPassword())) {
			dblogin.setLogin(true);
			loginRepo.save(dblogin);
			
			return dblogin;
		}
		return null;
		
	}

	@Override
	public Login logout(String email) {
		Login login=loginRepo.getById(email);
		login.setLogin(false);
		Login res=loginRepo.save(login);
		return res;
	}

	

	@Override
	public void forgotPasswort(String email) {
		
		
	}

	@Override
	public Login resetPassword(String email, String oldpassword, String newPassword) {
		Login l=loginRepo.getById(email);
		if(l.getEmail().equals(email) && l.getPassword().equals(oldpassword)) {
			l.setPassword(newPassword);
			loginRepo.save(l);
			return l;
		}
		else {
			return null;
		}
	}
	
	
	

}
