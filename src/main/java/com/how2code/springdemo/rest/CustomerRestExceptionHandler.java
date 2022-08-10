package com.how2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handelException(CustomerNotFoundException exc) {

		// create a student error response
		CustomerErrorResponse errorResponse = new CustomerErrorResponse();

		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessageString(exc.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handelException(Exception exc) {

		// create a student error response
		CustomerErrorResponse errorResponse = new CustomerErrorResponse();

		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessageString(exc.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
