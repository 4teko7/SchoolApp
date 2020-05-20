package com.teko.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping("/all")
	public String hello() {
		return "Hello From All";
	}
	
	@GetMapping("/secured/all")
	public String securedHello() {
		return "Secured Hello";
	}
	
}
