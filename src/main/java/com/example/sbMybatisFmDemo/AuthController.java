package com.example.sbMybatisFmDemo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sbMybatisFmDemo.mapper.UserRoleMapper;
import com.example.sbMybatisFmDemo.model.Role;
import com.example.sbMybatisFmDemo.model.User;
import jakarta.validation.Valid;

@Controller
public class AuthController {

	UserRoleMapper userRoleMapper;	
	private PasswordEncoder passwordEncoder;
	
	Logger logger = LoggerFactory.getLogger(AuthController.class);

	public AuthController(UserRoleMapper userRoleMapper
			,PasswordEncoder passwordEncoder ) {
		this.userRoleMapper = userRoleMapper;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping("/index")
	public String home() {
		return "index";
	}

	@GetMapping("/login")
	public String login(Model model) {
		
		User user = new User();		
		model.addAttribute("user", user);
		
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		
		User user = new User();		
		model.addAttribute("user", user);
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerSave(
			@Valid @ModelAttribute("user") User user
			// @Valid User user
			, BindingResult bindingResult 
			, Model model) {
		
		User existingUser = userRoleMapper.findByEmail(user.getEmail());
		
		if (existingUser != null) {
			bindingResult.rejectValue("email", null, "There is already an account registered with the same email");
		}

		if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            
            // model.addAttribute(bindingResult.
            
            return "/register";
        }
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		int uid = userRoleMapper.addUser(user);
		logger.info("USER.id -> " + uid);

		user = userRoleMapper.findByEmail(user.getEmail());
		Role role = userRoleMapper.getRoleByName("ROLE_ADMIN");
		
		int rid = userRoleMapper.addUserRole(user, role);
		logger.info("USER_ROLE.id -> " + uid);
		
		return "redirect:/register?success";
	}
	
	@GetMapping("/users")
	public String users(Model model) {
		List<User> users = userRoleMapper.getAllUsers();
		model.addAttribute("users", users);

		return "users";
	}
	
}
