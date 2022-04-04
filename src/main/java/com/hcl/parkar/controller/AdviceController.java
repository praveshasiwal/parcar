package com.hcl.parkar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hcl.parkar.exception.NoDataFoundException;

@ControllerAdvice
public class AdviceController {

	@ExceptionHandler(value= org.springframework.web.HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> methodNotfound(Exception e){
	   ResponseEntity<String> responseEntity = new ResponseEntity<String>("Patch method is disabled ",HttpStatus.METHOD_NOT_ALLOWED);
		return responseEntity;
	}
	 
	@ExceptionHandler(value=RuntimeException.class)
	public ResponseEntity<String> runtimeException(Exception e){
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@ExceptionHandler(value = NoDataFoundException.class)
	public ResponseEntity<String> NoDataFoundException(Exception e){
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("No Data Found",HttpStatus.NO_CONTENT);
		return responseEntity;
	}
}
