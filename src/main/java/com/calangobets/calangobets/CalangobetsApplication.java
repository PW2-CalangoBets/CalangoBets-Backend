package com.calangobets.calangobets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class CalangobetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalangobetsApplication.class, args);
	}

}
