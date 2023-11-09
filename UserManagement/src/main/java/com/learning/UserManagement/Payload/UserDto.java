package com.learning.UserManagement.Payload;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserDto {

	private int userId;
	private String username;
	private String email;
	//@JsonIgnore
	//private String password
	private String contactNumber;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(int userId, String username, String email, String contactNumber) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.contactNumber = contactNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
}
