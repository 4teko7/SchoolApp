package com.teko.commercial.controllers;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.teko.commercial.Entities.User;
import com.teko.commercial.encryption.EncodeDecode;
import com.teko.commercial.repositories.UserRepository;
import com.teko.commercial.services.UserDetailsServiceImp;
import com.teko.commercial.util.ImageUtil;
import com.teko.commercial.validator.UserValidator;


//import com.teko7.entities.TodoEntity;
//import com.teko7.entities.User;
//import com.teko7.userService.DatabaseuserService;
//import com.teko7.validator.validator;

@RequestMapping("/")
@Controller
public class UserController {
//  /commercial/src/main/java/com/teko/commercial/controllers/UserController.java
	final String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/uploads";
//	final String path = System.getProperty("user.dir") + "/uploads";
//	/commercial/src/main/resources/static
//	Path path = FileSystems.getDefault().getPath("/commercial/src/main/resources/static/uploads").toAbsolutePath();
	
//	uploadDir = path;
	
	@Autowired
	private UserDetailsServiceImp userService;

	@Autowired
	private UserValidator validator;

	private EncodeDecode encodeDecode = new EncodeDecode();
	
	private ImageUtil imageUtil = new ImageUtil();
	
	
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
		System.out.println(uploadDir);
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
	
	@GetMapping("/profile")
	public String userProfile(Model theModel, Authentication authentication,HttpServletRequest request) {
		if(authentication != null && authentication.isAuthenticated()) {
//        	theModel.addAttribute("message","You Logged In Successfully.");
			if(userService.findByUsername(request.getRemoteUser()) == null) return "redirect:/logout";
			theModel.addAttribute("user",userService.findByUsername(request.getRemoteUser()));
        	return "profile";
        }
		return "login";
	
	}
	
	@GetMapping("/updateprofile")
	public String updateUserProfile(Model theModel, Authentication authentication,HttpServletRequest request) {
		if(authentication != null && authentication.isAuthenticated()) {
			User user = userService.findByUsername(request.getRemoteUser());
			user.setPassword(encodeDecode.decode(user.getPassword()));
			user.setPasswordConfirm(encodeDecode.decode(user.getPasswordConfirm()));
			
			theModel.addAttribute("user",user);
        	return "updateprofile";
        }
		return "login";
	
	}
	
	@PostMapping("/updateprofile")
	public String updateUserProfilePost(@ModelAttribute("user") User user, @RequestParam("file") MultipartFile file,@RequestParam("id") int theId,  Model theModel,Authentication authentication,HttpServletRequest request) {
		if(authentication != null && authentication.isAuthenticated()) {
			User thisUser = userService.findById(user.getId());
			String errors = validator.validateForProfileUpdate(user);
			if (!errors.equals("")) {
				thisUser.setPassword(encodeDecode.decode(thisUser.getPassword()));
				thisUser.setPasswordConfirm(encodeDecode.decode(thisUser.getPasswordConfirm()));
				
				theModel.addAttribute("user",thisUser);
				theModel.addAttribute("error",errors);
	            return "updateprofile";
	        }
			
			
			
			try {
				if(!file.isEmpty()) {
//					System.out.println(path.toAbsolutePath().toString());
					String time = new Date().getTime() + "";
					Path fileNameAndPath = Paths.get(uploadDir,file.getOriginalFilename().substring(0,file.getOriginalFilename().length()-4) +"-"+ request.getRemoteUser() + "-"+time+".png");
//					String fileNameAndPath = path.toString() + "/" + file.getOriginalFilename();
					Files.write(fileNameAndPath, file.getBytes());
					String path = imageUtil.resize(request,fileNameAndPath.toString(),300,300);
					user.setPhotoPath(path);
				}else {
					user.setPhotoPath(thisUser.getPhotoPath());
					user.setRoles(thisUser.getRoles());
				}
				
				userService.save(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			return "redirect:/profile";
        }
    	return "redirect:/login";

	}
	

	
	
}
