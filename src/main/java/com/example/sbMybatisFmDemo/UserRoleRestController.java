package com.example.sbMybatisFmDemo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbMybatisFmDemo.mapper.UserRoleMapper;
import com.example.sbMybatisFmDemo.model.Role;
import com.example.sbMybatisFmDemo.model.User;


@RestController
public class UserRoleRestController {
	UserRoleMapper userRoleMapper;

	public UserRoleRestController(UserRoleMapper userRoleMapper) {
		this.userRoleMapper = userRoleMapper;
	}

	@GetMapping("/v1/users/{id}/roles")
	public List<Role> getRolesByUser(@PathVariable("id") long id) {
		 return userRoleMapper.getRoles(id);
	}
	
	@GetMapping("/v1/roles/{id}/users")
	public List<User> getUsersByRole(@PathVariable("id") long id) {
		 return userRoleMapper.getUsers(id);
	}
}
