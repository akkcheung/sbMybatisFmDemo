package com.example.sbMybatisFmDemo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sbMybatisFmDemo.mapper.UserRoleMapper;
import com.example.sbMybatisFmDemo.model.Role;
import com.example.sbMybatisFmDemo.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	UserRoleMapper userRoleMapper;

	public CustomUserDetailsService(UserRoleMapper userRoleMapper) {
		this.userRoleMapper = userRoleMapper;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// return null;
		
		 User user = userRoleMapper.findByEmail(email);
		 
		 System.out.println(user.getEmail());
		 System.out.println(user.getPassword());

		 // System.out.println(user.getRoles().toString());
		 
		 Iterator<Role> it = user.getRoles().iterator();
		 
		 while (it.hasNext()) {
			 Role role = it.next();			 
			 // System.out.println(role.getName());
			 logger.info(role.getName());
		 }

			Collection collection = mapRolesToAuthorities(user.getRoles());

			if (user == null)
				throw new UsernameNotFoundException("Invalid username or password.");

			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
					mapRolesToAuthorities(user.getRoles()));
			
	}
	
	private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
		
//		Collection < ? extends GrantedAuthority> mapRoles = 
//        		roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
        
		// return mapRoles;
		   
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for (Role role : roles) {
			
			System.out.println(role.getName());
			
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			// role.getPrivileges().stream()
			// .map(p -> new SimpleGrantedAuthority(p.getName()))
			// .forEach(authorities::add);
		}

		return authorities;
    }
	
	

}
