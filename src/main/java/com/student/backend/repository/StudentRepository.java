package com.student.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.backend.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
	Optional<Student> findByusername(String username);
}
