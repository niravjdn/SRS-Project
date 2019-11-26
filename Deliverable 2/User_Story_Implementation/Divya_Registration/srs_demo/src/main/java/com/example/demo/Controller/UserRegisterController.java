package com.example.demo.Controller;
	
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.model.UsersHolder;



@Controller

public class UserRegisterController {
	

	@RequestMapping("/registerUser")
	
	public ModelAndView showRegisterUserPage() {

		return new ModelAndView("RegisterUser");

	}


	@RequestMapping(value = "/userRegistered" , method = RequestMethod.POST)
	public ModelAndView registerUser(@RequestParam String emailId, @RequestParam String password,@RequestParam String user_firstname, 
			@RequestParam String user_lastname,
			@RequestParam String address, @RequestParam String phone_number){
		
		ModelAndView modelAndView = null;
		UsersHolder us = UsersHolder.getInstance();
		List<User> registeredUsers = us.getRegisteredUsers(); 
		
		for (User user : registeredUsers) {
			if(user.getEmailId().equals(emailId)) {
				return new ModelAndView("RegisterUser","message","This Email is already registered in the system!!");
				
			}
		}
		
		us.addUsers(emailId, password, user_firstname, user_lastname, address, phone_number);
		
		return new ModelAndView("Login");
	}


}
