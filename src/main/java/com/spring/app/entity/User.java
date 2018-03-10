package com.spring.app.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	public String id;
	public String firstName;
	public String lastName;
	public String emailId;
	public String contactNo;
	public String password;
	public String type; // {normal,entrepreneur}
	public String state; //{activated,deactivated}
	public String lastloggedin;
	public String updatedBy;
	public Date   createdOn;
	public Date   modifiedOn;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLastloggedin() {
		return lastloggedin;
	}

	public void setLastloggedin(String lastloggedin) {
		this.lastloggedin = lastloggedin;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", contactNo=" + contactNo + ", password=" + password + ", type=" + type + ", state=" + state
				+ ", lastloggedin=" + lastloggedin + ", updatedBy=" + updatedBy + ", createdOn=" + createdOn
				+ ", modifiedOn=" + modifiedOn + "]";
	}
}
