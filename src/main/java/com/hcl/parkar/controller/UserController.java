package com.hcl.parkar.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcl.parkar.service.UserService;


@Controller
@RequestMapping("/v1/api/User")
public class UserController {
	@Autowired
	private UserService userService;

//	C - Create
//	R - READ
//	U - Update
//	D - DELETE
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/user", produces = "application/user")
	public ResponseEntity<User> save(@RequestBody User user) {
		User userResult = userService.save(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(userResult, HttpStatus.CREATED);
		return responseEntity;

	}

	@RequestMapping(value = "/{Username}", method = RequestMethod.GET, consumes = "application/user", produces = "application/user")
	public ResponseEntity<User> get(@PathVariable String Username, @RequestBody User user) {
		User userResult = userService.get(Username);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(userResult, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/{Password}", method = RequestMethod.POST, consumes = "application/user", produces = "application/user")
	public ResponseEntity<User> update(@PathVariable String Password, @RequestBody User user) {
		User userResult = userService.save(user);
		ResponseEntity<User> responseEntity = new ResponseEntity<User>(userResult, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/{Username}", method = RequestMethod.DELETE, consumes = "application/user", produces = "application/user")
	public ResponseEntity<Boolean> delete(@PathVariable String Username) {
		Boolean userResult = userService.delete(Username);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(userResult, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "", method = RequestMethod.GET, consumes = "application/user", produces = "application/user")
	public ResponseEntity<List<User>> list() {
		List<User> userResult = userService.list();
		ResponseEntity<List<User>> responseEntity = new ResponseEntity<>(userResult, HttpStatus.OK);
		return responseEntity;
	}
}