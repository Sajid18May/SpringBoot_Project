package com.employeemanagament.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagament.dto.EmployeeDto;
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
		
		APIResponce<EmployeeDto> responce=new APIResponce<>();
		responce.setMessage("Registered Successfully");
		responce.setStatus(201);
		responce.setData(dto);
		
		return new ResponseEntity<>(responce,HttpStatus.CREATED);
	}
}
