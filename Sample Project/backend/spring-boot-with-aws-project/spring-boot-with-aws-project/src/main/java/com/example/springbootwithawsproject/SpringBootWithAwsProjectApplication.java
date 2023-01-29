package com.example.springbootwithawsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class SpringBootWithAwsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithAwsProjectApplication.class, args);
		System.out.println("Server up ");
	}

}
