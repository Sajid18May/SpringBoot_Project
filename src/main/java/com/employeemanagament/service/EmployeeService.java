package com.employeemanagament.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagament.dto.EmployeeDto;
import com.employeemanagament.entity.Address;
import com.employeemanagament.entity.Employee;
import com.employeemanagament.repository.AddressRepository;
import com.employeemanagament.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository emprepo;
	
	@Autowired
	private AddressRepository addressrepo;
	
	public void saveEmployee(Employee employee) {
		emprepo.save(employee);
	}
	
	public EmployeeDto savaEmployeeDto(EmployeeDto employeeDto) {
		Employee emp=new Employee();
		BeanUtils.copyProperties(employeeDto, emp);
		Address adds=new Address();
		BeanUtils.copyProperties(employeeDto, adds);
		
		Employee employeeSaved = emprepo.save(emp);
		Address addredSaved=addressrepo.save(adds);
		
		EmployeeDto dto = new EmployeeDto();
		BeanUtils.copyProperties(employeeSaved, dto);
		BeanUtils.copyProperties(addredSaved, dto);
		
		return dto;
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

	public void deleteEmployeeById(Long id) {
		emprepo.deleteById(id);
		
	}
}
