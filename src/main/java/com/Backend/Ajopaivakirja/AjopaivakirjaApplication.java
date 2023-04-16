package com.Backend.Ajopaivakirja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Backend.Ajopaivakirja.domain.Employee;
import com.Backend.Ajopaivakirja.domain.User;
import com.Backend.Ajopaivakirja.domain.UserRepository;


@SpringBootApplication
public class AjopaivakirjaApplication {
	
    @Autowired
    private UserRepository uRepository;

	public static void main(String[] args) {
		SpringApplication.run(AjopaivakirjaApplication.class, args);

	}
	
	
	//Luodaan User jos sellaista ei ole
	@Bean
	public CommandLineRunner demo(UserRepository urepository) {return (args) -> {
	 if (urepository.count() == 0) {
		 Employee adminEmp = new Employee("admin", 1);
		User adminUser = new User("Pomo", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "employer", adminEmp);
		uRepository.save(adminUser);
	 } else {
		 ;
	 }
	};
	}
	
}

