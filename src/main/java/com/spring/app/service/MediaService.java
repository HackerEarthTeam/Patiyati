package com.spring.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.entity.Media;
import com.spring.app.repository.MediaRepository;

@Service
public class MediaService {

	static Logger LOG = LoggerFactory.getLogger(MediaService.class.getName());
	
	@Autowired
	MediaRepository mediaRepository;
	
	public List<Media> findAllMedia() {
		return mediaRepository.findAll();
	}
	
	public List<Media> findByUserIdAndPassword(String userId) {
		return mediaRepository.findByUserId(userId);
	}
}
