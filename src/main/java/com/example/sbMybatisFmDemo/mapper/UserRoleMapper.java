package com.example.sbMybatisFmDemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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
}
