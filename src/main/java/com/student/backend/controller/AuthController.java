package com.student.backend.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.backend.dto.LoginRequestDto;
import com.student.backend.security.JwtService.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthenticationManager authManager;
	private final JwtService jwtService;
	public AuthController(AuthenticationManager authManager,JwtService jwtService) {
		this.authManager=authManager;
		this.jwtService=jwtService;
	}
	@PostMapping("/login")
	public String login(@RequestBody LoginRequestDto loginRequest) {
		System.out.println("Longin Cintroller cancel");
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword());
		authManager.authenticate(token);
		System.out.println("Authentication successed");
		String createToken=jwtService.generateToken(loginRequest.getUsername());
		return createToken;
	}
}

