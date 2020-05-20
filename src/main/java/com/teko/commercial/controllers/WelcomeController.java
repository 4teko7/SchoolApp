package com.teko.commercial.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/all")
	public String securedHello() {
		return "Secured Hello";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/secured/allpeople")
	public String securedHelloForPeople() {
		return "Secured Hello FOR PEOPLE";
	}
	
	@GetMapping("/hello")
	public String giveHello() {
		return "Hello";
	}
	
	
	
	
}
