package com.hcl.parkar.controller;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {
	@ExceptionHandler(value = org.springframework.web.HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> mentodNotfound(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("There is an Exception",
				HttpStatus.METHOD_NOT_ALLOWED);
		return responseEntity;
	}

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<String> runtimeException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	@ExceptionHandler(value = IOException.class)
	public ResponseEntity<String> IoException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("There is a Custom-Exception",
				HttpStatus.METHOD_NOT_ALLOWED);
		return responseEntity;
	}
}