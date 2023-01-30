package com.example.sbMybatisFmDemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.sbMybatisFmDemo.model.Role;
import com.example.sbMybatisFmDemo.model.User;

@Mapper
public interface UserRoleMapper {
	 
	@Delete("DELETE FROM user_role WHERE 1=1 AND userId=#{userId} AND roleId=#{roleId}")
	int deleteRole(long userId, long roleId);
    
	@Insert("INSERT INTO user_role (userId, roleId) VALUES (#{userId}, #{roleId}")
	int addRole(long userId, long roleId);
    
	@Select("SELECT r.id AS id, r.name AS name FROM users AS u LEFT JOIN user_role AS ur ON u.id = ur.user_id LEFT JOIN roles AS r ON r.id = ur.role_id WHERE 1=1 AND u.id = #{id} AND r.isActive = 1 AND u.isActive = 1")
	List<Role> getRoles(long userId);
    
	@Select("SELECT u.id AS id, u.username AS username FROM roles AS r LEFT JOIN user_role AS ur ON r.id = ur.role_id LEFT JOIN users AS u ON u.id = ur.user_id WHERE 1=1 AND r.id = #{id} AND r.isActive = 1 AND u.isActive = 1")
	List<User> getUsers(long roleId);
	
	@Select("SELECT u.id , u.username, u.email FROM users AS u WHERE 1=1 and u.isActive = 1")
	List<User> getAllUsers();
	
	@Select("SELECT u.id AS u_id, u.email, u.password FROM users u where u.email = #{email} and u.isActive = 1")
	@Results(value = { 
			@Result(property = "id", column = "u_id"), 
			@Result(property = "email", column = "email"),
			@Result(property = "password", column = "password"),
			@Result(property = "roles", javaType = List.class, column = "u_id", many = @Many(select = "getRoles")) })	
	User findByEmail(String email);
	
	@Insert("INSERT INTO users (username, email, password) VALUES (#{username}, #{email}, #{password})")
	int addUser(User user);
	
	@Select("SELECT r.id, r.name from roles AS r  WHERE 1=1 AND r.isActive = 1 and name = #{name}" )
	Role getRoleByName(String name);
	
	@Insert("INSERT INTO USER_ROLE (user_id, role_id) values (#{user.id}, #{role.id})")
	int addUserRole(User user, Role role);
}
