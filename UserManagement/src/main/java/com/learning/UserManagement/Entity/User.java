package com.learning.UserManagement.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_info")

public class User {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@NotEmpty(message="Username cant be null or empty")
	@Size(min=4,message="username must have min 4 char")
	private String username;
	
	@Email
	@NotEmpty(message="email cant be null or empty")
	private String email;
	
	@NotEmpty(message="Password cannot be empty")
	@Size(min=6,message="password length must equal or greater than 6 char")
	private String password;
	private String contactNumber;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String email, String password, String contactNumber) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
}
