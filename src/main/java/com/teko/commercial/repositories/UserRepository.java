package com.teko.commercial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teko.commercial.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> { 

}
