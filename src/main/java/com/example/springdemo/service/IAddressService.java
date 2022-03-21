package com.example.springdemo.service;

import java.util.List;

import com.example.springdemo.bean.Address;

public interface IAddressService {

	List<Address> getAddressById(int id);
	Address deleteAddressById(int id);
	Address updateAddress(Address address);
	Address addAddress(Address address);
}
