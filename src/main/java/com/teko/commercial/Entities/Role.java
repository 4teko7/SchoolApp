package com.teko.commercial.Entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "role")
@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "role")
	private String role;

	@ManyToMany(mappedBy = "roles")
    private Collection<User> users;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Collection<User> getUsers() {
		return users;
	}



	public void setUsers(Collection<User> users) {
		this.users = users;
	}



	public Role() {
		super();
	}



	public Role(String role) {
		super();
		this.role = role;
	}



	public int getid() {
		return id;
	}



	public void setid(int id) {
		this.id = id;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
}
