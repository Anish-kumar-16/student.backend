package com.student.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDto {
	@NotBlank
	String name;
	@NotBlank
	String course;
	@NotBlank
	String department;
	@Min(18)
	int age;
	
	@NotBlank
	String username;
	@NotBlank
	String password;
}

