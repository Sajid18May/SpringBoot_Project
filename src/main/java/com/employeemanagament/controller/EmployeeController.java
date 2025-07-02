package com.employeemanagament.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employeemanagament.dto.EmployeeDto;
import com.employeemanagament.entity.Address;
import com.employeemanagament.entity.Employee;
import com.employeemanagament.service.AddressService;
import com.employeemanagament.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService empservice;
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/home")
	public String homePage() {
		return "Registration";
	}
	
//	@PostMapping("/saveEmp")
//	public String registerEmployee(Employee employee,Model model) {
//		empservice.saveEmployee(employee);
//		model.addAttribute("msg","Registered Succesfully");
//		return "Registration";
//	}
	
	@PostMapping("/saveReg")
	public String registerEmployee(EmployeeDto employeeDto,Model model) {
		Employee emp=new Employee();
		BeanUtils.copyProperties(employeeDto, emp);
		empservice.saveEmployee(emp);
		Address add=new Address();
		BeanUtils.copyProperties(employeeDto, add);
		addressService.saveAddress(add);
		model.addAttribute("msg","Registered Succesfully");
		return "Registration";
	}
}
