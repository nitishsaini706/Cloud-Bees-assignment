package com.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.train.model.Ticket;

@SpringBootApplication
public class TrainApiTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainApiTaskApplication.class, args);
	}


}
