package com.alam.springbootwithcicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/springbootcicd")
	public String sayHello() {
		return "Hello World";
	}

}
