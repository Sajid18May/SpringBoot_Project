package com.employeemanagament.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagament.dto.EmployeeDto;
import com.employeemanagament.entity.Employee;
import com.employeemanagament.response.APIResponce;
import com.employeemanagament.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/emp")
public class EmployeeControllerAPI {
	
	@Autowired
	EmployeeService empseService;
	
	@PostMapping("/add")
	public ResponseEntity<APIResponce<EmployeeDto>> createEmployeeRegistration(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto dto=empseService.savaEmployeeDto(employeeDto);
		
		APIResponce<EmployeeDto> response=new APIResponce<>();
		response.setMessage("Registered Successfully");
		response.setStatus(201);
		response.setData(dto);
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<APIResponce<String>> deletetEmployee(@RequestParam Long id){
		empseService.deleteEmployeeById(id);
		
		APIResponce<String> response=new APIResponce<>();
		response.setMessage("Deletion Done");
		response.setStatus(200);
		response.setData("Employee Deletion Successful");
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<APIResponce<List<Employee>>> getEmployees(){
		List<Employee> employees = empseService.getAllEmployees();
		
		APIResponce<List<Employee>> response=new APIResponce<>();
		response.setMessage("Retrival Done");
		response.setStatus(200);
		response.setData(employees);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
