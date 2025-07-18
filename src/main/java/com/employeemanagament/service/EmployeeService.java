package com.employeemanagament.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.employeemanagament.dto.EmployeeDto;
import com.employeemanagament.entity.Address;
import com.employeemanagament.entity.Employee;
import com.employeemanagament.exception.ResourceNotFound;
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
	
	public Employee getEmployeeById(long id){
		 Employee employee=new Employee();
		 employee=emprepo.findById(id).orElseThrow(
				 ()-> new ResourceNotFound("Employee not found")
				 );
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

	public List<Employee> getAllEmployees(int pageNo, int pageSize, String sortBy,
			String sortDir) {
		 sortDir=sortDir.toUpperCase();
		 Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Direction.valueOf(sortDir), sortBy));
		 
		 Page<Employee> employeePage = emprepo.findAll(pageable);
		 List<Employee> employees=employeePage.getContent();
		 
		return employees;
	}
}
