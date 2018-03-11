package com.spring.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.app.entity.User;
import com.spring.app.repository.UserRepository;
import com.spring.app.utils.EmailController;

@Service
public class UserService {
	static Logger LOG = LoggerFactory.getLogger(UserService.class.getName());

	@Autowired
	UserRepository userRepository;
	@Autowired
	EmailController emailController;
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User findByUserIdAndPassword(String emailId, String password) {
		return userRepository.findByEmailIdAndPassword(emailId, password);
	}
	
	public User saveUser(User user){

		String flag = "updated";
		if (user.getId() == null) {
			flag = "created";
		}

		String userName = user.getFirstName();
		String emailId  = user.getEmailId();

		String message = "Hi" + userName + ", \n your Account has been" + flag + "sucessfully.";
		emailController.sendEmail(emailId, message);

		user = userRepository.save(user);
		
		return user;
	}
	
	public List<User> saveUserList(List<User> users){
		return userRepository.save(users);
	}

	public User findByEmailId(String email) {
		return userRepository.findByEmailId(email);
	}

	public User findByEmailIdAndPassword(String emailId, String password) {
		return userRepository.findByEmailIdAndPassword(emailId,password);
	}

	public User findById(String id) {
		return userRepository.findById(id);
	}
}
