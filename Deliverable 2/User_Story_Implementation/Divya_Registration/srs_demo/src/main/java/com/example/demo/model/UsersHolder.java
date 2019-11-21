package com.example.demo.model;

import java.util.ArrayList;

public class UsersHolder {

	private static UsersHolder us;
	private static ArrayList<User> userList ;

	private UsersHolder() {
		userList= new ArrayList<User>();
	}
	
	 public static UsersHolder getInstance() {
		if(us == null) {
			us = new UsersHolder();
		}
		return us;
	}
	 
	 
	public void addUsers(String emailId, String password) {
		
		User u = new User(emailId, password);
		
		userList.add(u);
	}

	public ArrayList<User> getRegisteredUsers(){

		return userList;
	}


}
