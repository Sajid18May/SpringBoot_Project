package com.employeemanagament.errorhandle;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.employeemanagament.dto.ErrorDetails;
import com.employeemanagament.exception.ResourceNotFound;

@RestControllerAdvice
public class GlobalExceptionHandler{
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFound(
			ResourceNotFound ex,
			WebRequest request) {
		ErrorDetails errorDetails=new ErrorDetails(ex.getMessage(),new Date(),request.getDescription(false));
		//ResponseEntity<ErrorDetails> response=new ResponseEntity<ErrorDetails>();
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
