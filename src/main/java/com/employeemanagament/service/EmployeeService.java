package com.employeemanagament.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagament.entity.Employee;
import com.employeemanagament.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository emprepo;
	
	public void saveEmployee(Employee employee) {
		emprepo.save(employee);
	}
}
