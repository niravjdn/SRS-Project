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
			user.setPassword("user123");
			user.setName("Nirav");
			user.setName("Nirav");
			user.setLastName("Patel");

			userService.saveUser(user);
		}
		long[] numbers = { 1212121212125L, 1632763288405L, 1212121212126L, 7132819765986L, 12121212121267L };
		for (int i = 0; i < numbers.length; i++) {
			OpusCard card = null;
			card = new OpusCard(i, (long) 0.0, numbers[i], null);
			System.err.println("Adding " + card.getNumber());
			cardRepository.save(card);
		}
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(iGOApp.class);
	}

}
