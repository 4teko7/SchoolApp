package com.teko.commercial.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teko.commercial.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> {

	User findByUsername(String username); 
	User findById(int id);
	

}
