package com.teko.commercial.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
import com.teko.commercial.Entities.UserRole;
import com.teko.commercial.Entities.Video;
import com.teko.commercial.encryption.EncodeDecode;
import com.teko.commercial.repositories.UserRepository;
import com.teko.commercial.services.UserDetailsServiceImp;
import com.teko.commercial.services.UserRoleService;
import com.teko.commercial.services.VideoService;
import com.teko.commercial.util.FileUtils;
import com.teko.commercial.util.ImageUtil;
import com.teko.commercial.validator.UserValidator;


//import com.teko7.entities.TodoEntity;
//import com.teko7.entities.User;
//import com.teko7.userService.DatabaseuserService;
//import com.teko7.validator.validator;

@RequestMapping("/")
@Controller
public class UserController {

	final String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static";
	
	@Autowired
	private UserDetailsServiceImp userService;

	@Autowired
	private VideoService videoService;
	
	@Autowired
	private UserValidator validator;

	@Autowired
	private UserRoleService userRoleService;
	
	private EncodeDecode encodeDecode = new EncodeDecode();
	
	private ImageUtil imageUtil = new ImageUtil();
	
	private FileUtils fileUtils = new FileUtils();
	
	@GetMapping("/registration")
	public String registerUser(Model theModel) {
		theModel.addAttribute("user",new User());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registerUser(@ModelAttribute("user") User user, BindingResult bindingResult,HttpServletRequest request) {
		validator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
            return "registration";
        }
		
		
		userService.save(user);
		
		try {
			request.login(user.getUsername(), encodeDecode.decode(user.getPassword()));
		} catch (ServletException e) {
			System.out.println(e.getStackTrace());
		}
		
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
		
		return "login";
	}
	
	@GetMapping("/profile")
	public String userProfile(Model theModel, Authentication authentication,HttpServletRequest request) {
		if(authentication != null && authentication.isAuthenticated()) {
//        	theModel.addAttribute("message","You Logged In Successfully.");
			User user = userService.findByUsername(request.getRemoteUser());
			if(user == null) return "redirect:/logout";
			theModel.addAttribute("user",user);
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
	public String updateUserProfilePost(@ModelAttribute("user") User user, @RequestParam("file") MultipartFile[] files,@RequestParam("id") int theId,  Model theModel,Authentication authentication,HttpServletRequest request) {

		if(authentication != null && authentication.isAuthenticated()) {
			User thisUser = userService.findById(user.getId());
			String errors = validator.validateForProfileUpdate(user);
			System.out.println(files.length);
			if(request.getParameter("removePhoto") != null) {
				
				fileUtils.removeFileFromStorage(uploadDir+"/"+thisUser.getPhotoPath());
				
				thisUser.setPhotoPath(null); user.setPhotoPath(null);
				}
			else {
				
				if(request.getParameter("imgDersProgramiRadio") != null && request.getParameter("nameOfProfileImg") != null) {
					userService.uploadUserImage(thisUser, files[0]);
					
					userService.uploadUserLectureImage(thisUser, files[1]);
				}else if(request.getParameter("nameOfProfileImg") != null) {
					userService.uploadUserImage(thisUser, files[0]);
				}else if(request.getParameter("imgDersProgramiRadio") != null) {
					userService.uploadUserLectureImage(thisUser, files[1]);
				}
			}
			
			
			userService.updateUser(thisUser, user);
			if (!errors.equals("")) {
				theModel.addAttribute("user",thisUser);
				theModel.addAttribute("error",errors);
	            return "updateprofile";
	        }
	        
			userService.save(thisUser);
	   
			return "redirect:/profile";
        }
		
    	return "redirect:/login";

	}
	
	@GetMapping("/teachers")
	public String getAllTeachers(Model theModel,HttpServletRequest request) {
//		List<User> users = userService.findAll();
		List<UserRole> userRoles = userRoleService.findByRoleId(1);
		List<User> users = userRoleService.getAllUsersFromList(userRoles);
		
		theModel.addAttribute("users",users);
		
		return "allteachers";

	}
	
	@RequestMapping(value="teachervideo", method = RequestMethod.GET)
	public String teacherVideos(@RequestParam("id") int theId, Model theModel,HttpServletRequest request) {
		
		User thisUser = userService.findById(theId);
		List<Video> videos = videoService.findByUser(thisUser);
		theModel.addAttribute("videos",videos);
		
		return "teachervideos";
	}
	
	
	
	
	
}
