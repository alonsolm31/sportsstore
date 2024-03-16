package com.dev.sportsstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
	
	private final AuthenticationManager authenticationManager;
	
	public LoginController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@PostMapping()
	public String login(@RequestBody LoginRequest loginRequest) {
		
		return loginRequest.username;
	}
	
	@GetMapping
	public String getString() {
		return "get";
	}
	
	public record LoginRequest(String username, String password) {}
}
