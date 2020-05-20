package com.teko.commercial.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.teko.commercial.Entities.User;
import com.teko.commercial.Entities.UserDetailsImp;
import com.teko.commercial.repositories.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByUsername(username);
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username Not Found !"));
		UserDetailsImp userDetails = optionalUser.map(user -> new UserDetailsImp(user)).get();
		
		return new UserDetailsImp(userDetails);
	}

}
