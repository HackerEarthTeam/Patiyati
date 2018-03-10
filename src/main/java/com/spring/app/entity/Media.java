package com.spring.app.entity;

import org.json.JSONArray;
import org.springframework.data.annotation.Id;

public class Media {
	@Id
	public String id;
	public String name;
	public JSONArray skillTag;
	public String type; // {video,image,text}
	public String mediaLink;
	public String userId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JSONArray getSkillTag() {
		return skillTag;
	}

	public void setSkillTag(JSONArray skillTag) {
		this.skillTag = skillTag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMediaLink() {
		return mediaLink;
	}

	public void setMediaLink(String mediaLink) {
		this.mediaLink = mediaLink;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", name=" + name + ", skillTag=" + skillTag + ", type=" + type + ", mediaLink="
				+ mediaLink + ", userId=" + userId + "]";
	}
}
