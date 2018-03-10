package com.spring.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.app.entity.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {

	List<Comment> findByMediaId(String mediaId);

}
