package com.spring.app.entity;

import org.springframework.data.annotation.Id;

public class Comment {
	@Id
	public String id;
	public String fromUid;
	public String toUid;
	public String mediaId;
	public String Comment;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFromUid() {
		return fromUid;
	}
	public void setFromUid(String fromUid) {
		this.fromUid = fromUid;
	}
	public String getToUid() {
		return toUid;
	}
	public void setToUid(String toUid) {
		this.toUid = toUid;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", fromUid=" + fromUid + ", toUid=" + toUid + ", mediaId=" + mediaId + ", Comment="
				+ Comment + "]";
	}
	
}
