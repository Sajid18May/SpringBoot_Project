package com.employeemanagament.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagament.entity.Address;
import com.employeemanagament.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	public void saveAddress(Address address) {
		addressRepository.save(address);
	}
}
