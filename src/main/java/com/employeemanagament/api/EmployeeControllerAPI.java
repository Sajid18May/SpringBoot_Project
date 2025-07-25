package com.employeemanagament.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagament.dto.EmployeeDto;
import com.employeemanagament.entity.Employee;
import com.employeemanagament.response.APIResponce;
import com.employeemanagament.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/emp")
public class EmployeeControllerAPI {
	
	@Autowired
	EmployeeService empseService;
	
	@PostMapping("/add")
	public ResponseEntity<APIResponce<EmployeeDto>> createEmployeeRegistration(@Valid @RequestBody EmployeeDto employeeDto,BindingResult result) {
		if(result.hasErrors()) {
			APIResponce<EmployeeDto> response=new APIResponce<>();
			response.setMessage(result.getFieldError().toString());
			response.setStatus(500);
			response.setData(null);
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		EmployeeDto dto=empseService.savaEmployeeDto(employeeDto);
		APIResponce<EmployeeDto> response=new APIResponce<>();
		response.setMessage("Registered Successfully");
		response.setStatus(201);
		response.setData(dto);
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<APIResponce<Employee>> UpdateEmployee(@RequestBody Employee employee) {
		empseService.saveEmployee(employee);
		
		APIResponce<Employee> response=new APIResponce<>();
		response.setMessage("Updated Successfully");
		response.setStatus(200);
		response.setData(employee);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
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
	
	@GetMapping("/get/{id}")
	public ResponseEntity<APIResponce<Employee>> getEmployeesById(@PathVariable long id){
		Employee employee = empseService.getEmployeeById(id);
		
		APIResponce<Employee> response=new APIResponce<>();
		response.setMessage("Retrival Done");
		response.setStatus(200);
		response.setData(employee);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeePage")
	public ResponseEntity<APIResponce<List<Employee>>> getEmployeePage(
			@RequestParam(defaultValue ="0") int pageNo,
			@RequestParam(defaultValue ="3")int pageSize,
			@RequestParam(defaultValue ="email")String sortBy,
			@RequestParam(defaultValue ="ASC")String sortDir
			){
		List<Employee> employees= empseService.getAllEmployees(pageNo,pageSize,sortBy,sortDir);
		
		APIResponce<List<Employee>> responce=new APIResponce<>();
		responce.setMessage("Retrived Employee Page");
		responce.setStatus(200);
		responce.setData(employees);
		
		return new ResponseEntity<>(responce,HttpStatus.OK);
	}
}
