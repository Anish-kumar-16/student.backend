package com.student.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.backend.dto.StudentRequestDto;
import com.student.backend.dto.StudentResponseDto;
import com.student.backend.entity.Student;
import com.student.backend.exception.StudentNotFoundException;
import com.student.backend.repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	private final PasswordEncoder passwordEncoder;
	
	public StudentService(StudentRepository studentRepository,PasswordEncoder passwordEncoder){
		this.studentRepository=studentRepository;
		this.passwordEncoder=passwordEncoder;
	}
	
	public StudentResponseDto createStudent(StudentRequestDto studentRequest) {
		Student student=new Student();
		student.setName(studentRequest.getName());
		student.setCourse(studentRequest.getCourse());
		student.setDepartment(studentRequest.getDepartment());
		student.setAge(studentRequest.getAge());
		student.setUsername(studentRequest.getUsername());
		student.setPassword(passwordEncoder.encode(studentRequest.getPassword()));
	    Student savedStudent=studentRepository.save(student);
	    
	    StudentResponseDto response=new StudentResponseDto();
	    response.setId(savedStudent.getId());
	    response.setName(savedStudent.getName());
	    response.setCourse(savedStudent.getCourse());
	    response.setDepartment(savedStudent.getDepartment());
	    response.setAge(savedStudent.getAge());
	    return response;
	}
	public List <StudentResponseDto> getAllStudents() {
	   List <Student> students=studentRepository.findAll();
	   List<StudentResponseDto> responseList=new ArrayList<>();
	   for(Student student:students) {
		   StudentResponseDto response=new StudentResponseDto();
		   response.setId(student.getId());
		   response.setName(student.getName());
		    response.setCourse(student.getCourse());
		    response.setDepartment(student.getDepartment());
		    response.setAge(student.getAge());
		    responseList.add(response);
	   }
	      return responseList;
	}
	public StudentResponseDto getStudentById(Long id) {
		Student student= studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student Not Found with id:"+id));
		StudentResponseDto response=new StudentResponseDto();
		response.setId(student.getId());
		response.setName(student.getName());
		response.setCourse(student.getCourse());
		response.setDepartment(student.getDepartment());
		response.setAge(student.getAge());
		return response;
	}
	public StudentResponseDto updateStudent(Long id,StudentRequestDto studentRequest) {
		Student student=studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student Not Found with id:"+id));
		student.setName(studentRequest.getName());
		student.setCourse(studentRequest.getCourse());
		student.setDepartment(studentRequest.getDepartment());
		student.setAge(studentRequest.getAge());
		Student saveStudent=studentRepository.save(student);
		
		StudentResponseDto response=new StudentResponseDto();
		response.setId(saveStudent.getId());
		response.setName(saveStudent.getName());
		response.setCourse(saveStudent.getCourse());
		response.setDepartment(saveStudent.getDepartment());
		response.setAge(saveStudent.getAge());
		return response;
	}
	public ResponseEntity<Void> deleteStudent(Long id){
		Student student=studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student Not Found with id:"+id));
		studentRepository.deleteById(id);
		return ResponseEntity.noContent().build();
		}
	
}
