package com.spring.app.rest.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.app.entity.User;
import com.spring.app.service.UserService;


@RestController
@RequestMapping("/rest/user")
public class UserRestController {

	static Logger LOG = LoggerFactory.getLogger(UserRestController.class.getName());
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> userList() {
		List<User> user = userService.findAllUsers();
		return user;
	}
	
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public User findById(@RequestParam(value = "id", required = true) String id) {
		return userService.findById(id);
	}
	
	@RequestMapping(value = "/findByEmailId", method = RequestMethod.GET)
	public User findByEmailId(@RequestParam(value = "emailId", required = true) String emailId) {
		emailId = emailId.trim().toLowerCase();
		return userService.findByEmailId(emailId);
	}
	
	@RequestMapping(value = "/emailIdExisting", method = RequestMethod.GET)
	public String emailExisting(@RequestParam(value = "emailId", required = true) String emailId) {
		String result = "new";
		
		emailId   = emailId.trim().toLowerCase();
		User user = userService.findByEmailId(emailId);
		
		if (user != null && user.getEmailId().equalsIgnoreCase(emailId)) {
			result = "duplicate";
		}
		
		return result;
	}	
}
