package com.student.backend.controller;


import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.backend.dto.StudentRequestDto;
import com.student.backend.dto.StudentResponseDto;
import com.student.backend.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService=studentService;
	}
	@PostMapping("/create")
	public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody StudentRequestDto studentRequest) {
		StudentResponseDto response= studentService.createStudent(studentRequest);
		return ResponseEntity.created(URI.create("/api/students/"+response.getId())).body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<StudentResponseDto>>getAllStudent(){
	List<StudentResponseDto> getStudends= studentService.getAllStudents();
		return ResponseEntity.ok(getStudends);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Long id) {
		StudentResponseDto response= studentService.getStudentById(id);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable Long id,@Valid @RequestBody StudentRequestDto studentRequest) {
		StudentResponseDto response= studentService.updateStudent(id,studentRequest);
		return ResponseEntity.ok(response);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}
	
}
