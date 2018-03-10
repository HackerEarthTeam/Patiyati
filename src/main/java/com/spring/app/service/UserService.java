package com.spring.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.entity.User;
import com.spring.app.repository.UserRepository;

@Service
public class UserService {
	static Logger LOG = LoggerFactory.getLogger(UserService.class.getName());

	@Autowired
	UserRepository userRepository;

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User findByUserIdAndPassword(String emailId, String password) {
		return userRepository.findByEmailIdAndPassword(emailId, password);
	}
	
	public User saveUser(User user){
		return userRepository.save(user);
	}
	
	public List<User> saveUserList(List<User> users){
		return userRepository.save(users);
	}
}
