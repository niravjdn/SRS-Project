package com.srsproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.srsproject.helper.OpusNumberGenerator;
import com.srsproject.model.OpusCard;
import com.srsproject.model.User;
import com.srsproject.repository.OpusCardRepository;
import com.srsproject.service.UserService;

@SpringBootApplication
public class iGOApp extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private OpusCardRepository cardRepository;

	public static void main(String[] args) {
		SpringApplication.run(iGOApp.class, args);
	}

	@Override
	public void run(String... args) {

		// if admin does not exist then insert admin in DB
		User userExists = userService.findUserByEmail("niravjdn@gmail.com");
		if (userExists == null) {
			User user = new User();
			user.setEmail("niravjdn@gmail.com");
			user.setPassword("user");
			user.setName("Nirav");
			user.setLastName("Patel");

			userService.saveUser(user);
		}
		long number = 1212121212121L;
		for (int i = 1; i < 10; i++) {
			OpusCard card = null;
			if(i%2 != 0) {
				card = new OpusCard(i, (long) 0.0, ++number, null);
			}else {
				card = new OpusCard(i, (long) 0.0, OpusNumberGenerator.numbGen(), null);
			}
			System.err.println("Adding "+card.getNumber());
			cardRepository.save(card);
		}
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(iGOApp.class);
	}

}
