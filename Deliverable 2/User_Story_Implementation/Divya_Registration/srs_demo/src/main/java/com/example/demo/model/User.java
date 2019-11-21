package com.example.demo.model;

public class User {

	
	private  String emailId;
	private  String password;
	private  String user_firstname;
	private  String user_lastname;
	private  String address;
	private  String phone_number;
	
	public User(String emailId, String password, String user_firstname, String user_lastname, String address,
			String phone_number) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.user_firstname = user_firstname;
		this.user_lastname = user_lastname;
		this.address = address;
		this.phone_number = phone_number;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_firstname() {
		return user_firstname;
	}

	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}

	public String getUser_lastname() {
		return user_lastname;
	}

	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	
	
	
	
	
	
	
	
	
}
