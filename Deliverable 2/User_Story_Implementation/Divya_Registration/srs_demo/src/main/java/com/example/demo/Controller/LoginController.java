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

	@RequestMapping(value = "/loginAsUser", method = RequestMethod.POST)
	public ModelAndView showWelcomePage(@RequestParam String emailId, @RequestParam String password) {
		
		boolean flag = false;
		User u = new User(emailId, password);
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
