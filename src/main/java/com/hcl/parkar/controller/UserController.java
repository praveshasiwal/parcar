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
import com.hcl.parkar.model.UserEntity;
import com.hcl.parkar.service.UserService;

@Controller
@RequestMapping("v1/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserEntity> save(@RequestBody UserEntity userEntity) {
		UserEntity userResult = userService.save(userEntity);
		ResponseEntity<UserEntity> responseEntity = new ResponseEntity<UserEntity>(userResult, HttpStatus.CREATED);
		return responseEntity;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserEntity> get(@PathVariable Long id) {
		UserEntity userResult = userService.getUserEntity(id);
		ResponseEntity<UserEntity> responseEntity = new ResponseEntity<UserEntity>(userResult, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/{userName}", method = RequestMethod.PATCH, consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserEntity> update(@PathVariable String userName, @RequestBody UserEntity userEntity) {
		UserEntity userResult = userService.update(userName, userEntity);
		ResponseEntity<UserEntity> responseEntity = new ResponseEntity<UserEntity>(userResult, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		Boolean isDeleted = userService.delete(id);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<UserEntity>> list() {
		List<UserEntity> userResults = userService.list();
		ResponseEntity<List<UserEntity>> responseEntity = new ResponseEntity<>(userResults, HttpStatus.OK);
		return responseEntity;
	}
}