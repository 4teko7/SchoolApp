package com.teko.commercial.services;

import java.util.List;
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
	public UserDetails loadUserByUsername(String username) {return new UserDetailsImp(userRepository.findByUsername(username));}
	
	public void save(User entity) {userRepository.save(entity);}
	
	public List<User> findAll() {return userRepository.findAll();}
	
	public User findById(int id) {return userRepository.findById(id);}
	
	public User findByUsername(String username) {return userRepository.findByUsername(username);}
	
	public void deleteUser(int id) {userRepository.deleteById(id);}
	

}
