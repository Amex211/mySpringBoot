package com.testproject.AllinOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication()
public class AllinOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllinOneApplication.class, args);
	}

}
