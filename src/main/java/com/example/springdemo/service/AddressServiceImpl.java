package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.bean.Address;
import com.example.springdemo.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressRepository addressRepo;
	
	@Override
	public List<Address> getAddressById(int id) {
		
		return addressRepo.getAllAddrById(id);
	}

	@Override
	public Address deleteAddressById(int id) {
		Address addr=addressRepo.getById(id);
		if(addr!=null){
			addressRepo.deleteById(id);
			return addr;
		}else {
		return null;
		}
	}

	@Override
	public Address updateAddress(Address address) {
		Address addr=addressRepo.getById(address.getAddrId());
		if(addr!=null) {
			addressRepo.save(address);
			return addr;
		}
		return null;
		
	}

	@Override
	public Address addAddress(Address address) {
		
		return addressRepo.save(address);
	}

}
