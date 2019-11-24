package com.example.demo.Controller;
	
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

		UsersHolder us = UsersHolder.getInstance();
		us.addUsers(emailId, password, user_firstname, user_lastname, address, phone_number);
		return new ModelAndView("Login");
	}


}
