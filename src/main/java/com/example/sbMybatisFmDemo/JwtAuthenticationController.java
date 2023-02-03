package com.example.sbMybatisFmDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.sbMybatisFmDemo.model.AuthenticationRequest;
import com.example.sbMybatisFmDemo.model.AuthenticationResponse;
import com.example.sbMybatisFmDemo.security.CustomUserDetailsService;
import com.example.sbMybatisFmDemo.service.JwtTokenService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@RestController
public class JwtAuthenticationController {

	@Autowired
	JwtTokenService jwtTokenService;

	@Autowired
	CustomUserDetailsService jwtUserDetailsService;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/authenticate")
	public AuthenticationResponse authenticate(@RequestBody @Valid final AuthenticationRequest authenticationRequest) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(),
					authenticationRequest.getPassword()));
			
			System.out.println(authenticationRequest.getLogin());
			
		} catch (final BadCredentialsException ex) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}

		final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getLogin());
		final AuthenticationResponse authenticationResponse = new AuthenticationResponse();
		authenticationResponse.setAccessToken(jwtTokenService.generateToken(userDetails));
		return authenticationResponse;
	}


}
