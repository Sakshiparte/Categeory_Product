package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CategeoryProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategeoryProductApplication.class, args);
	}

}
