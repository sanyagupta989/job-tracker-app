package com.jobtracker.demo;



import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import jakarta.annotation.PostConstruct;



@SpringBootApplication
public class JopTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JopTrackerAppApplication.class, args);
   }

}
