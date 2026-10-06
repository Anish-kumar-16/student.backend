package com.student.backend.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.backend.repository.StudentRepository;
import com.student.backend.entity.Student;
@Service
public class CustomUserDetailsService implements UserDetailsService{
	private final StudentRepository studentRepository;
	
	public CustomUserDetailsService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student= studentRepository.findByusername(username).orElseThrow(()->new UsernameNotFoundException("user not found with"+username));
		return User.withUsername(student.getUsername()).password(student.getPassword()).build();
	}
	
}
