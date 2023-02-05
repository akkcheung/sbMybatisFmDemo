package com.example.sbMybatisFmDemo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;


public class User {
	
	private Integer id;
	
	@NotEmpty (message="{myBean.username.empty.message}")
	private String username;
	private List<Role> roles = new ArrayList<>();
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String password;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}
