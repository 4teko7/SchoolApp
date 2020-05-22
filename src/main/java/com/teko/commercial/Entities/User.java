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
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="phone")
	private String phone;
	
	

	@Column(name="classNumber")
	private int classNumber;
	
	@Column(name="school")
	private String school;
	
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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "userRole", joinColumns = @JoinColumn(name = "userId",referencedColumnName = "id"), inverseJoinColumns =  @JoinColumn(name = "roleId",referencedColumnName = "id"))
//	@JoinColumn(name = "userRole")
	private List<Role> roles;



	public User(int id, String email, String firstname, String lastname, String phone, int classNumber, String school,
		int active, String username, String password, String passwordConfirm, List<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.classNumber = classNumber;
		this.school = school;
		this.active = active;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.roles = roles;
	}

	public User(String email, String firstname, String lastname, String phone, int classNumber, String school,
			int active, String username, String password, String passwordConfirm, List<Role> roles) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.classNumber = classNumber;
		this.school = school;
		this.active = active;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.roles = roles;
	}

	public User() {
		super();
	}

	public User(User user) {
		if(user == null) return;
		this.email = user.getEmail();
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.phone = user.getPhone();
		this.classNumber = user.getClassNumber();
		this.school = user.getSchool();
		this.active = user.getActive();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.passwordConfirm = user.getPasswordConfirm();
		this.roles = user.getRoles();
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
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
}
