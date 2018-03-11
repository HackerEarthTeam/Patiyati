package com.spring.app.web.controller;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.app.entity.User;
import com.spring.app.service.UserService;
import com.spring.app.utils.Encryptor;

@Controller
public class UserWebController {

static Logger LOG = LoggerFactory.getLogger(UserWebController.class.getName());
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String,Object> param,Map<String, Object> model,
						HttpServletRequest req,	HttpServletResponse res) {
		
		String page 	= "login";
		String emailId  = (String)param.get("username");
		String password	= (String)param.get("password");
		emailId 		= emailId.toLowerCase().trim();
		password 		= password.trim();
		
		String decryptedPassword = Encryptor.encrypt(password);
		
		User user = userService.findByEmailIdAndPassword(emailId,decryptedPassword);
		if (user != null) {
			page = "my-account";
		}
		
		return page;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@RequestParam Map<String,Object> param,Map<String, Object> model,
							   HttpServletRequest req,HttpServletResponse res) {
		
		String page 		= "login";
		try {

		String userName 	= (String)param.get("username");
		String email 		= (String)param.get("email");
		String password 	= (String)param.get("password1");
		email 				= email.toLowerCase();
		password 		    = password.trim();
		
		User user = userService.findByEmailId(email);
		if (user == null) {
			user = new User();
			String encryptedPassword = Encryptor.encrypt(password);
			user.setPassword(encryptedPassword);
			user.setState("active");
			user.setCreatedOn(new Date());
		}
		
		user.setEmailId(email);
		user.setFirstName(userName);
		user.setLastName(null);
		user.setContactNo(null);
		user.setType(null);
		user.setModifiedOn(new Date());
		user = userService.saveUser(user);
		
		page = "my-account";
		res.sendRedirect(page);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return page;
	
	}
	
}
