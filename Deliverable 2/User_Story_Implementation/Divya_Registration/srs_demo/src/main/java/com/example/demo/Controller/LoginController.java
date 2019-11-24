package com.example.demo.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.model.UsersHolder;



@Controller

public class LoginController {

	@RequestMapping("/LoginUser")
	public ModelAndView showLoginPage() {
		return new ModelAndView("Login");
	}
	
	@RequestMapping("/successfulLogin")
	public ModelAndView showAfterLoginPage() {
		return new ModelAndView("successfulLogin");
	}

	@RequestMapping(value = "/loginAsUser", method = RequestMethod.POST)
	public ModelAndView showWelcomePage(@RequestParam String emailId, @RequestParam String password,@RequestParam String user_firstname, 
			@RequestParam String user_lastname,
			@RequestParam String address, @RequestParam String phone_number) {
		
		boolean flag = false;
		User u = new User(emailId, password, user_firstname, user_lastname, address, phone_number);
		UsersHolder us = UsersHolder.getInstance();
		ArrayList<User> users = us.getRegisteredUsers();

		for (User user : users) {
			if (u.getEmailId().equals(user.getEmailId()) && u.getPassword().equals(user.getPassword())) {
				flag = true;
				break;
			}
		}

		
		ModelAndView modelAndView = new ModelAndView("Login");
		modelAndView.addObject("errorMessage", "INVALID LOGIN!.. Please try again");
		return modelAndView;

	}

}
