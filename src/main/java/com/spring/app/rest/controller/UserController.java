package com.spring.app.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.entity.User;
import com.spring.app.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	static Logger LOG = LoggerFactory.getLogger(UserController.class.getName());
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> userList() {
		List<User> user = userService.findAllUsers();
		LOG.info("user "+user);
		return user;
	}
}
