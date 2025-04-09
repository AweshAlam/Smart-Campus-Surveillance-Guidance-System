package com.smart.surveillance.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.surveillance.model.Student;
import com.smart.surveillance.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/{_id}")
	public ResponseEntity<Student> getStudent(@PathVariable String _id) {
	  Optional<Student> student = studentService.getStudent(_id);
	  return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/update/{_id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable String _id) {
		return studentService.updatePassword(student,_id);
	}
}
