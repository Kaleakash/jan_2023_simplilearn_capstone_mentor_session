package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	
	@GetMapping(value="/")
	public String greeting() {
		return "Welcome to spring boot with aws created by Akash";
	}
	
	@GetMapping(value="/sayHello/{name}")
	public String sayHello(@PathVariable("name") String name) {
		return "Welcome to spring boot with aws created by Akash Welcome user "+name;
	}
}
