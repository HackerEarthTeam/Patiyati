package com.spring.app.entity;

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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", contactNo="
				+ contactNo + ", password=" + password + ", type=" + type
				+ ", state=" + state + "]";
	}

}
