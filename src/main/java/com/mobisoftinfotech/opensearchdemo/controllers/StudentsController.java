package com.mobisoftinfotech.opensearchdemo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobisoftinfotech.opensearchdemo.models.Student;
import com.mobisoftinfotech.opensearchdemo.services.StudentService;
import com.mobisoftinfotech.opensearchdemo.dto.StudentSearchRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentsController.class);

	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		try {
			Student createdStudent = studentService.createStudent(student);
			return ResponseEntity.ok(createdStudent);
		} catch (IOException e) {
			LOGGER.error("Error creating student", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		Student existingStudent = studentService.getStudent(id);
		if (existingStudent == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}	
		try {
			Student updatedStudent = studentService.updateStudent(id, student);
			return ResponseEntity.ok(updatedStudent);
		} catch (IOException e) {
			LOGGER.error("Error updating student", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/search")
	public ResponseEntity<List<Student>> searchStudents(@RequestBody StudentSearchRequest searchRequest) {
		try {
			List<Student> students = studentService.searchStudents(searchRequest);
			return ResponseEntity.ok(students);
		} catch (IOException e) {
			LOGGER.error("Error searching students", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
