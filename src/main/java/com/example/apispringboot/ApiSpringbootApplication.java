package com.example.apispringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSpringbootApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("1234"));
	}
}
