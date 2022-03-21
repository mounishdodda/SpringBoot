package com.example.springdemo.repository;

import javax.validation.constraints.Email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.bean.Login;


@Repository
public interface ILoginRepository extends JpaRepository<Login,String> {

}
