package com.spring.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.entity.Comment;
import com.spring.app.repository.CommentRepository;

@Service
public class CommentService {
	static Logger LOG = LoggerFactory.getLogger(CommentService.class.getName());
	
	@Autowired
	CommentRepository commentRepository;
	
	List<Comment> findByMediaId(String mediaId){
		return commentRepository.findByMediaId(mediaId);
	}
	
}
