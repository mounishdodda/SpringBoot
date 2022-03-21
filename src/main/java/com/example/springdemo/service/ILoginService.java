package com.example.springdemo.service;

import com.example.springdemo.bean.Login;

public interface ILoginService {
	
	Login login(Login login);
	Login logout(String email);
	Login resetPassword(String email,String oldpassword,String newPassword);
	void forgotPasswort(String email);

}
