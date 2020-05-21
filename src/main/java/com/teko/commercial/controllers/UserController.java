package com.teko.commercial.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.teko.commercial.Entities.User;
import com.teko.commercial.services.UserDetailsServiceImp;
import com.teko.commercial.validator.UserValidator;


//import com.teko7.entities.TodoEntity;
//import com.teko7.entities.User;
//import com.teko7.userService.DatabaseuserService;
//import com.teko7.validator.validator;

@RequestMapping("/")
@Controller
public class UserController {

	@Autowired
	private UserDetailsServiceImp userService;

	@Autowired
	private UserValidator validator;
	
	
	
	@GetMapping("/registration")
	public String registerUser(Model theModel) {
		theModel.addAttribute("user",new User());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registerUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
		validator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
            return "registration";
        }
		userService.save(user);
		
		return "redirect:/home";
	}
	
	@GetMapping("/login")
	public String loginUser(Model theModel, String error, String logout,Authentication authentication) {
		if (error != null)
            theModel.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            theModel.addAttribute("message", "You have been logged out successfully.");
        
        if(authentication != null && authentication.isAuthenticated()) {
//        	theModel.addAttribute("message","You Logged In Successfully.");
        	return "home";
        }
//		theModel.addAttribute("user",new User());
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute("user") User user,Authentication authentication) {
//		if(authentication.isAuthenticated()) return "home";
		System.out.println("asdasd");
		
		return "login";
	}
	
	
	
	
	
	
}
