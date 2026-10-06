package com.student.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.student.backend.security.JwtAuthenticationFilter;

@Configuration
public class StudentConfig {
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	public StudentConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
		this.jwtAuthenticationFilter=jwtAuthenticationFilter;
	}
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http){
		http
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth->{
			auth.requestMatchers("/api/students/create").permitAll()
			.requestMatchers("/api/auth/login").permitAll()
			.anyRequest().authenticated();
			
		}).addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class)
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		return http.build();
	}
	
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authconfig) {
		return authconfig.getAuthenticationManager();
	}
	
	
}

