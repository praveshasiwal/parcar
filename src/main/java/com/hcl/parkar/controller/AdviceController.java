package com.hcl.parkar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

	@ExceptionHandler(value = org.springframework.web.HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> methodNotfound(HttpRequestMethodNotSupportedException e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("This is my Custom Exption message",
				HttpStatus.METHOD_NOT_ALLOWED);
		return responseEntity;
	}

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<String> runtimeException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}


}
