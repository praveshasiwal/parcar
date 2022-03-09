package com.hcl.parkar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcl.parkar.model.Employee;
import com.hcl.parkar.service.EmployeeService;

@Controller
@RequestMapping("/v1/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
//	C - Create
//	R - READ
//	U - Update
//	D - DELETE
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		Employee employeeResult = employeeService.save(employee);
		ResponseEntity<Employee> responseEntity = new ResponseEntity<Employee>(employeeResult, HttpStatus.CREATED);
		return responseEntity;
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> get(@PathVariable Integer id) {
		Employee employeeResult = employeeService.get(id);
		ResponseEntity<Employee> responseEntity = new ResponseEntity<Employee>(employeeResult, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.PATCH, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Employee> update(@PathVariable String name ,@RequestBody Employee employee) {
		Employee employeeResult = employeeService.update(name, employee);
		ResponseEntity<Employee> responseEntity = new ResponseEntity<Employee>(employeeResult, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
		Boolean employeeResult = employeeService.delete(id);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(employeeResult, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Employee>> list() {
		List<Employee> employeeResults = employeeService.list();
		ResponseEntity<List<Employee>> responseEntity = new ResponseEntity<>(employeeResults, HttpStatus.OK);
		return responseEntity;
	}
	

}
