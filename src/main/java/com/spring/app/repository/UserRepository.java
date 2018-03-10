package com.spring.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.app.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
	@Query("{emailId:?0,password:?1}")
	public User findByEmailIdAndPassword(String emailid, String password);
}
