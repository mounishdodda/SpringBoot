package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.bean.Address;
import com.example.springdemo.service.IAddressService;

@RestController
public class AddressController {
	
	@Autowired
	IAddressService addrServ;
	
	
	//get list of address
	@GetMapping("/address/{empId}")
	ResponseEntity<List<Address>>  getAddressById(@PathVariable("empId") int id){
		List<Address> address= addrServ.getAddressById(id);
		return new ResponseEntity<>(address,HttpStatus.OK);
		
	}
	
	//delete address by id
	@DeleteMapping("/address/{id}")
	ResponseEntity<Address> deleteAddressById(@PathVariable("id") int id){
		Address addr= addrServ.deleteAddressById(id);
		return new ResponseEntity<>(addr,HttpStatus.OK);
	}
	
	@PostMapping("/Add-address")
    ResponseEntity<Address> addAddress(@RequestBody Address address) {
		Address addr = addrServ.addAddress(address);
		return new ResponseEntity<>(addr, HttpStatus.OK);
	}
	

}
