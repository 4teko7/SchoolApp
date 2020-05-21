package com.teko.commercial.repositories;

import java.util.Collection;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teko.commercial.Entities.Role;
import com.teko.commercial.Entities.User;

@Repository
public interface RoleRepository  extends JpaRepository <Role , Integer> {

	Role findById(int id);

}