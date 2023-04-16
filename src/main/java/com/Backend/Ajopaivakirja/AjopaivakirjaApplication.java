package com.Backend.Ajopaivakirja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Backend.Ajopaivakirja.domain.User;
import com.Backend.Ajopaivakirja.domain.UserRepository;


@SpringBootApplication
public class AjopaivakirjaApplication {
	
    @Autowired
    private UserRepository uRepository;

	public static void main(String[] args) {
		SpringApplication.run(AjopaivakirjaApplication.class, args);

	}
	
	@Bean
	public CommandLineRunner demo(UserRepository urepository) {return (args) -> {
	 if (urepository.count() == 0) {
		User adminUser = new User();
		adminUser.setUsername("Pomo");
		adminUser.setPassword("Pomo");
		adminUser.setRole("employer");
		uRepository.save(adminUser);
	 } else {
		 ;
	 }
	};
	}
	
}

