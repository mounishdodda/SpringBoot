package com.example.springdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springdemo.bean.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {
    
	@Query(value= "select * from address join employee on address.emp_id=employee.emp_id where employee.emp_id=:eId", nativeQuery = true)
	List<Address> getAllAddrById(@Param("eId") int id);
	
}
