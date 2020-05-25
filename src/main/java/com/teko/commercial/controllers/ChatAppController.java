package com.teko.commercial.controllers;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teko.commercial.Entities.ChatMessage;
import com.teko.commercial.Entities.User;
import com.teko.commercial.services.UserDetailsServiceImp;


@Controller
@RequestMapping("/")
public class ChatAppController {

	
	@Autowired
	private UserDetailsServiceImp userService;

	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
	
	@GetMapping("/chat")
	public String index(Model theModel, Authentication authentication,HttpServletRequest request) {
		if(authentication != null && authentication.isAuthenticated()) {
			User user = userService.findByUsername(request.getRemoteUser());
			theModel.addAttribute("user",user);
			return "index";
		}
		return "home";
	}

}
