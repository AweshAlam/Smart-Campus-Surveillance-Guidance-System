package com.smart.surveillance.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/{reg_no}")
	public Optional<Student> getStudent(@PathVariable String reg_no) {
		return studentService.getStudent(reg_no);
	}
	
	@PutMapping("/update/{reg_no}")
	public Student updateStudent(@RequestBody Student student,@PathVariable String reg_no) {
		return studentService.updatePassword(student,reg_no);
	}
}
