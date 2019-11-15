package com.srsproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.srsproject.helper.EmailSenderService;
import com.srsproject.model.ConfirmationToken;
import com.srsproject.model.User;
import com.srsproject.repository.ConfirmationTokenRepository;
import com.srsproject.repository.OpusCardRepository;
import com.srsproject.repository.UserRepository;
import com.srsproject.service.UserService;

@Controller
public class OpusCardController {

	@Autowired
	private UserService userService;

	
	@Autowired
	private OpusCardRepository cardRepository;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = { "/link" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("linkOpus");
		return modelAndView;
	}


	@RequestMapping(value = "/addopus", method = RequestMethod.POST)
	public ModelAndView addOpus(String opusNumber) {
		System.err.println(opusNumber);
		System.err.println(cardRepository.findAll());
		System.err.println(cardRepository.findByUserHavingIsNull());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("linkOpus");
		return modelAndView;
	}

}
