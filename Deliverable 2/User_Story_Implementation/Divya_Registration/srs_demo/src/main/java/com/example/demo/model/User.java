package com.example.demo.model;

public class User {

	
	private  String emailId;
	private  String password;
	
	
	public User(String emailId, String password) {
		super();
		this.setEmailId(emailId);
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
}
