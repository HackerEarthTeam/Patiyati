package com.spring.app.repository;

import java.util.List;

import org.json.JSONArray;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.app.entity.Media;

public interface MediaRepository extends MongoRepository<Media, String> {

	@Query("{skillTag:{$in:?0}}")
	List<Media> findBySkillTag(JSONArray skill);

	List<Media> findByUserId(String userId);
}
