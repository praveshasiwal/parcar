package com.hcl.parkar.controller;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcl.parkar.service.UserService;

@Controller
@RequestMapping("/v1/api/User")
public class UserController {

   @Autowired
   private UserService userService;
   
  
	}
	//custom operation  findByUserName
}
