package com.srsproject.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.srsproject.helper.EmailSenderService;
import com.srsproject.model.ConfirmationToken;
import com.srsproject.model.OpusCard;
import com.srsproject.model.User;
import com.srsproject.repository.ConfirmationTokenRepository;
import com.srsproject.repository.OpusCardRepository;
import com.srsproject.repository.UserRepository;
import com.srsproject.service.UserService;

import antlr.collections.List;

@Controller
public class OpusCardController {

	@Autowired
	private UserService userService;

	
	@Autowired
	private OpusCardRepository cardRepository;
	
	@Autowired
	private UserRepository userRepository;

	@ModelAttribute("username")
	public String getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		} else {
			return principal.toString();
		}
	}

	@RequestMapping(value = { "/link" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("linkOpus");
		return modelAndView;
	}
	
	
	@RequestMapping(value = { "/unlink/{id}" }, method = RequestMethod.GET)
	public ModelAndView unlink(@PathVariable(value = "id") final long id, RedirectAttributes atts) {
		Optional<OpusCard> card = cardRepository.findById(id);
		OpusCard opusCard = card.get();
		opusCard.setEmail(null);
		cardRepository.save(opusCard);
		atts.addFlashAttribute("successMessage", "Card has been unlinked Successfully.");
		return new ModelAndView("redirect:/link");
	}
	
	@RequestMapping(value = { "/manage" }, method = RequestMethod.GET)
	public ModelAndView viewLinkedOpusCards() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("manageLinkedOpusCard");
		modelAndView.addObject("records", cardRepository.findByEmail(getCurrentUser()));
		return modelAndView;
	}

	@RequestMapping(value = { "/loadOpusCard/{id}" }, method = RequestMethod.GET)
	public ModelAndView loadOpusCard(@PathVariable(value = "id") final long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("record", cardRepository.findById(id).get());
		modelAndView.setViewName("loadOpusCard");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/loadOpusCard" }, method = RequestMethod.POST)
	public ModelAndView loadOpusCardPost(long id, long amount, RedirectAttributes atts) {
		OpusCard card =  cardRepository.findById(id).get();
		card.setBalance(amount);
		cardRepository.save(card);
		atts.addFlashAttribute("successMessage", "Card has been loaded successfully.");
		return new ModelAndView("redirect:/manage");
	}


	@RequestMapping(value = "/addopus", method = RequestMethod.POST)
	public ModelAndView addOpus(String opusNumber) {
		System.err.println(opusNumber);
		OpusCard card = cardRepository.findByNumber(Long.parseLong(opusNumber));
		ModelAndView modelAndView = new ModelAndView();
		
		String userName = getCurrentUser();
		System.err.println(userName);
		System.err.println(cardRepository.findAll());
		if(card != null) {
			if(card.getEmail() != null) {
				modelAndView.addObject("errorMessage", "The card has already been linked to other account.");
			}else {
				// proceed
				card.setEmail(userName);
				cardRepository.save(card);
				modelAndView.addObject("successMessage", "The card has been linked successfully.");
			}
		}else {
			modelAndView.addObject("errorMessage", "The card number is invalid.");
		}
		
		modelAndView.setViewName("linkOpus");
		return modelAndView;
	}

}
