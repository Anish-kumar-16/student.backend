package com.student.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDto {
	Long id;
	String name;
	String course;
	String department;
	int age;
	
}
