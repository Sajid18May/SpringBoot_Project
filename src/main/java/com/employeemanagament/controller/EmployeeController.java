package com.employeemanagament.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/reg")
	public String empPage() {
		return "Employee";
	}
	
	@PostMapping("/saveEmp")
	public String registerEmployee(
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam String email,
			@RequestParam String mobile,
			Model model) {
		Employee employee=new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setMobile(mobile);
		empservice.saveEmployee(employee);
		model.addAttribute("mes","Registered Succesfully");
		return "Employee";
	}
	
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
