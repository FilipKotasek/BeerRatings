package com.Kotasek.BeerRatings;

import com.Kotasek.BeerRatings.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BeerRatingsApplication {

	@Autowired
	BeerService beerService;
	public static void main(String[] args) {
		SpringApplication.run(BeerRatingsApplication.class, args);
	}



}
