package com.teko.commercial.Entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity

@Table(name = "user", uniqueConstraints = @UniqueConstraint (columnNames = "username"))
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "active")
	private int active;
	
	@Column(name = "username")
	private String username;
	

	@Column(name = "password")
	private String password;
	
	@Column(name = "passwordConfirm")
	private String passwordConfirm;
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "userRole", joinColumns = @JoinColumn(name = "userId",referencedColumnName = "id"), inverseJoinColumns =  @JoinColumn(name = "roleId",referencedColumnName = "id"))
//	@JoinColumn(name = "userRole")
	private List<Role> roles;

	public User(int id, String email, String name,String username, String password, int active, List<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.username = username;
		this.active = active;
		this.roles = roles;
		this.password = password;
	}

	public User() {
		super();
	}

	public User(User user) {
		if(user == null) return;
		this.active = user.getActive();
		this.email = user.getEmail();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.roles = user.getRoles();
		this.name = user.getName();
		this.id = user.getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	
	
}
