package com.bits.bitscure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class BitscureApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitscureApplication.class, args);
		System.out.println("Hello BITS....");
	}

}
