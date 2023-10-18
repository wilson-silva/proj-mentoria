package com.estudo.mentoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MentoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentoriaApplication.class, args);
	}

}
