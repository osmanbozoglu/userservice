package com.userservice.userservice;

import com.userservice.userservice.models.AppUser;
import com.userservice.userservice.models.Role;
import com.userservice.userservice.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner runner(AppUserService appUserService){
		return args -> {
			appUserService.saveRole(new Role(null, "ROLE_USER"));
			appUserService.saveRole(new Role(null, "ROLE_USER_ADMIN"));
			appUserService.saveRole(new Role(null, "ROLE_USER_MANAGER"));
			appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			appUserService.saveAppUser(new AppUser(null, "Osman Bozoglu", "osmanbozoglu", "password123", new ArrayList<>()));

			appUserService.addRoleToUser("osmanbozoglu", "ROLE_SUPER_ADMIN");
		};
	}
}
