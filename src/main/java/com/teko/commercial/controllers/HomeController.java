package com.teko.commercial.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teko.commercial.Entities.User;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("/home")
	public String home(@RequestParam(required = false) boolean loginsuccess,Model theModel) {
		if(loginsuccess) {
			theModel.addAttribute("message","You Logged In Successfully.");
		}
			
		
		return "home";
		}
	
	
	@GetMapping("/")
	public String root(@RequestParam(required = false) boolean loginsuccess,Model theModel) {

		return "home";
		}

	
	
	
	
}
