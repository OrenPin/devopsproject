package com.example.devopsproject;

import com.example.devopsproject.model.Log;
import com.example.devopsproject.repos.LogRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DevOpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevOpsApplication.class, args);
	}

	@Bean
	public CommandLineRunner seed(LogRepo logRepo) {
		return args -> {
			// Save a new log entry at application startup
			logRepo.save(new Log("/seed", new Date()));
		};
	}
}
