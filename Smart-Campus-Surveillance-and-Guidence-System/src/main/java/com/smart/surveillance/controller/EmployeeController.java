package com.smart.surveillance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.surveillance.model.Student;
import com.smart.surveillance.service.StudentService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getStudentList(){
		return studentService.getStudentList();
	}
	
	@PostMapping("/student/register")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/student/{reg_no}")
	public Student getStudent(@PathVariable Long reg_no) {
		return studentService.getStudent(reg_no);
	}
	
	@PutMapping("/student/{reg_no}")
	public Student updateStudent(@RequestBody Student student,@PathVariable Long reg_no) {
		return studentService.updateStudent(student,reg_no);
	}
	
	@DeleteMapping("/student/{reg_no}")
	public void deleteStudent(@PathVariable Long reg_no) {
		studentService.deleteStudent(reg_no);
	}
}
