package com.employeemanagament.service;

import java.util.List;

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
	
	public List<Employee> getAllEmployees(){
		 List<Employee> employees =emprepo.findAll();
		 return employees;
	}
	
	public Employee getEmployeeById(Long id){
		 Employee employee=new Employee();
		 employee=emprepo.findById(id).get();
		 return employee;
	}
	
	public void removeEmployee(Long id) {
		emprepo.deleteById(id);
	}
	
	public void updateEmployee(Employee employee) {
		emprepo.save(employee);
	}
}
