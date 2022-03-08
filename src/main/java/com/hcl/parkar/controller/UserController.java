package com.hcl.parkar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcl.parkar.service.UserService;

@Controller

public class UserController {
   @Autowired
   public UserService userService;
	 @RequestMapping(value= "/login", method = RequestMethod.GET)
	 
}
