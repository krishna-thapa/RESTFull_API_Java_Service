package com.worldpay.offer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.worldpay.offer.dao")
public class OfferApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfferApplication.class, args);
	}

}

