package com.spring.app.web.controller;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.app.entity.User;
import com.spring.app.service.UserService;
import com.spring.app.utils.EmailController;
import com.spring.app.utils.Encryptor;
import com.spring.app.utils.UsersUtils;

@Controller
public class UserWebController {

static Logger LOG = LoggerFactory.getLogger(UserWebController.class.getName());
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailController  emailController;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam @Valid Map<String,Object> param,Map<String, Object> model,
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
		
		return "redirect:"+page;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@RequestParam @Valid Map<String,Object> param,Map<String, Object> model,
							   HttpServletRequest req,HttpServletResponse res) {
		
		String page 		= "login";
		try {

		String firstName 	= (String)param.get("fname");
		String lastName		= (String)param.get("lname");
		String email 		= (String)param.get("email");
		String password 	= (String)param.get("password1");
		email 				= email.toLowerCase();
		password 		    = password.trim();
		
		LOG.info("param " +param);
		User user = userService.findByEmailId(email);
		if (user == null) {
			user = new User();
			String encryptedPassword = Encryptor.encrypt(password);
			user.setPassword(encryptedPassword);
			user.setState("active");
			user.setCreatedOn(new Date());
		}
		
		user.setEmailId(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setContactNo(null);
		user.setType(null);
		user.setModifiedOn(new Date());
		user = userService.saveUser(user);
		
		 page = "login";

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:"+page;
	
	}
	
	@RequestMapping(value = "/forgetpwd", method = RequestMethod.POST)
	public String forgetpwd(@RequestParam @Valid Map<String,
			  			    Object> param,Map<String, Object> model,
						    HttpServletRequest req,	HttpServletResponse res) {
		
		String page 	= "login";
		String emailId  = (String)param.get("username");
		emailId 		= emailId.trim();
		
		User user = userService.findByEmailId(emailId);
		if (user != null) {
			
			String email 		= user.getEmailId();
			String Name  		= user.getFirstName();
 			String password     = UsersUtils.getOneTimePassword();
			String encryptpwd   = Encryptor.encrypt(password);
			
			user.setPassword(encryptpwd);
			user.setModifiedOn(new Date());
			userService.saveUser(user);
			
			String message = "Hi " + Name + ", \n your Password is :  " + password + "\n \n";
			emailController.sendEmail(email, message);
		}
		
		return "redirect:"+page;
	}
	
	@RequestMapping(value = "/changepwd", method = RequestMethod.POST)
	public String changepwd(@RequestParam @Valid Map<String,
			  			    Object> param,Map<String, Object> model,
						    HttpServletRequest req,	HttpServletResponse res) {
		
		String page 	= "login";
		String cur_pwd  = (String)param.get("cur_pwd");
		String new_pwd  = (String)param.get("new_pwd");
		String conf_pwd = (String)param.get("conf_pwd");
		String id       =  (String)param.get("id");
		
		User user = userService.findById(id);
		if (user != null) {
			String email 		= user.getEmailId();
			String Name  		= user.getFirstName();
 			String password     = UsersUtils.getOneTimePassword();
			String encryptpwd   = Encryptor.encrypt(password);
			
			user.setPassword(encryptpwd);
			user.setModifiedOn(new Date());
			userService.saveUser(user);
			
			String message = "Hi " + Name + ", \n your Password is :  " + password + "\n \n";
			emailController.sendEmail(email, message);
		}
		
		return "redirect:"+page;
	}
}
