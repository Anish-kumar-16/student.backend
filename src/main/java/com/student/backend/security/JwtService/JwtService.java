package com.student.backend.security.JwtService;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	SecretKey key=Keys.hmacShaKeyFor("my-secret-key-my-secret-key-m-y-secret-key".getBytes());
	public String generateToken(String username) {
		return Jwts.builder()
				.subject(username)
				.signWith(key)
				.compact();
	}
	public String validateToken(String token) {
		return Jwts.parser()
		.verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
	}
}

