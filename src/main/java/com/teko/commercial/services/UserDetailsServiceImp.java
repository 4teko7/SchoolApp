package com.teko.commercial.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.teko.commercial.Entities.Role;
import com.teko.commercial.Entities.User;
import com.teko.commercial.Entities.UserDetailsImp;
import com.teko.commercial.Entities.UserRole;
import com.teko.commercial.encryption.EncodeDecode;
import com.teko.commercial.repositories.RoleRepository;
import com.teko.commercial.repositories.UserRepository;
import com.teko.commercial.repositories.UserRoleRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	
	@Autowired
	private UserRoleService userRoleService;
	
//	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private EncodeDecode encodeDecode = new EncodeDecode();
	
	@Override
	public UserDetails loadUserByUsername(String username) {return new UserDetailsImp(userRepository.findByUsername(username));}
	
	public void save(User entity) {
		entity.setActive(1);
		entity.setPassword(encodeDecode.encode(entity.getPassword()));
		entity.setPasswordConfirm(encodeDecode.encode(entity.getPasswordConfirm()));
		if(entity.getRoles() == null || entity.getRoles().isEmpty()) {
			List<UserRole> userRoles = userRoleRepo.findByuserId(entity.getId());
			if(userRoles.isEmpty()) entity.setRoles(Arrays.asList(roleRepo.findById(2)));
			else entity.setRoles(userRoleService.getAllRolesFromList(userRoles));
		}
		userRepository.save(entity);
	}
		
	public List<User> findAll() {return userRepository.findAll();}
	
	public User findById(int id) {return userRepository.findById(id);}
	
	public User findByUsername(String username) {return userRepository.findByUsername(username);}
	
	public void deleteUser(int id) {userRepository.deleteById(id);}
	

}
