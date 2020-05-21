package com.teko.commercial.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teko.commercial.Entities.Role;
import com.teko.commercial.Entities.User;
import com.teko.commercial.Entities.UserRole;
import com.teko.commercial.repositories.RoleRepository;
import com.teko.commercial.repositories.UserRepository;

@Service
public class UserRoleService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	public List<User> getAllUsersFromList(List<UserRole> list) {
		List<User> users = new ArrayList<User>();
		
		for (UserRole userRole : list) {
			
			users.add(userRepo.findById(userRole.getUserId()));
		}
		
		return users;
				
	}
	
	
	public List<Role> getAllRolesFromList(List<UserRole> list) {
		List<Role> roles = new ArrayList<Role>();
		
		for (UserRole userRole : list) {
			if(userRole != null)
			roles.add(roleRepo.findById(userRole.getRoleId()));
		}
		
		return roles;
				
	}
	
	
	
}
