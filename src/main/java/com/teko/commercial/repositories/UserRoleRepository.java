package com.teko.commercial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teko.commercial.Entities.Role;
import com.teko.commercial.Entities.User;
import com.teko.commercial.Entities.UserRole;

@Repository
public interface UserRoleRepository  extends JpaRepository <UserRole , Integer> {

	UserRole findById(int id);
	List<UserRole> findByUserId(int id);
	List<UserRole> findByRoleId(int id);

}