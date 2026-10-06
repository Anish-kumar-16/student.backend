package com.student.backend.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> VaildationException(MethodArgumentNotValidException ex) {
		Map <String,String> errors=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(), error.getDefaultMessage()));
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String,String>>NotFoundException(StudentNotFoundException ex){
		Map<String,String>errors=new HashMap<>();
		errors.put("message",ex.getMessage());
		
		return new ResponseEntity<>(errors,HttpStatus.NOT_FOUND);
	}
	
}
