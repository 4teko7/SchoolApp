package com.teko.commercial.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.teko.commercial.Entities.User;
import com.teko.commercial.encryption.EncodeDecode;
import com.teko.commercial.repositories.RoleRepository;
import com.teko.commercial.services.UserDetailsServiceImp;
import com.teko.commercial.utils.CheckRoles;

@RequestMapping("/secured")
@Controller
public class SecuredController {

	@Autowired
	private UserDetailsServiceImp userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	private EncodeDecode encodeDecode = new EncodeDecode();
//	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	CheckRoles checkRoles = new CheckRoles();
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@IsAdmin
//	@PreAuthorize("hasRole('ADMIN')")
//	@PreAuthorize("hasAnyRole('ADMIN', 'ROLE_USER')")
	@GetMapping("/users")
//	@PreAuthorize("hasAnyRole('ROLE ADMIN')")
	public String getAllUsers(Model theModel,Principal principle,Authentication authentication,HttpSession session, HttpServletRequest request,  ModelMap   modelMap) {
		List<User> users = userService.findAll();
		theModel.addAttribute("users",users);
		if(!checkRoles.hasRole("ROLE ADMIN")) {
			theModel.addAttribute("message","Sadece Adminler Bu Sayfayi Gorebilir !!!");
			return "home";
		} 
		
		return "users";

	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="adduser", method = RequestMethod.GET)
	public String showFormForAddUser(Model theModel) {
		if(!checkRoles.hasRole("ROLE ADMIN")) return "home";
		User user = new User();
		theModel.addAttribute("user",user);
		return "addUserForm";
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="adduser", method = RequestMethod.POST)
	public String addTodo(@ModelAttribute("user") User user) {
		if(!checkRoles.hasRole("ROLE ADMIN")) return "home";
		userService.save(user);
		return "redirect:/secured/users";
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="deleteuser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int theId) {
		if(!checkRoles.hasRole("ROLE ADMIN")) return "home";
		userService.deleteUser(theId);
		return "redirect:/secured/users";
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="updateuser", method = RequestMethod.GET)
	public String updateUser(@RequestParam("id") int theId,Model theModel) {
		if(!checkRoles.hasRole("ROLE ADMIN")) return "home";
		User user = userService.findById(theId);
//		user.setRoles(roles);
		user.setPassword(encodeDecode.decode(user.getPassword()));
		user.setPasswordConfirm(encodeDecode.decode(user.getPasswordConfirm()));
		theModel.addAttribute("user",user);
		return "addUserForm";
	}
	
	
}




/*
 * 
 * 
 * //		System.out.println(checkRoles.hasRole("ADMIN"));
//		System.out.println(checkRoles.hasRole("USER"));
//		System.out.println(checkRoles.hasRole("ROLE_ADMIN"));
		System.out.println(checkRoles.hasRole("ROLE ADMIN"));
//		System.out.println(request.isUserInRole("ROLE USER"));
//		System.out.println(request.isUserInRole("ROLE_USER"));
//		System.out.println(authentication.getAuthorities().contains(new SimpleGrantedAuthority("USER")));
//		System.out.println(request.getUserPrincipal());
//		System.out.println(session);
//		System.out.println(modelMap.values());
//		if(principle.)
//		System.out.println("NAME OF USER : " + principle.toString());
//		System.out.println("AUTHENTICATION : " + authentication);
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		System.out.println("AUTH : " + auth.getPrincipal().toString());
//		System.out.println("AUTH : " + auth.getDetails());
//		System.out.println("AUTH : " + auth.getCredentials());
 * 
 * 
 * 
 * 
 * */


