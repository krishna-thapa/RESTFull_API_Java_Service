package com.worldpay.offer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OfferApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfferApplication.class, args);
	}

}

