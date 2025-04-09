package com.smart.surveillance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.surveillance.model.Admin;
import com.smart.surveillance.model.Student;
import com.smart.surveillance.service.AdminService;
import com.smart.surveillance.service.StudentService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register")
	public Admin saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@PutMapping("/update")
	public Admin updateAdmin(@RequestBody Admin admin,@PathVariable Long id) {
		return adminService.updateAdmin(admin,id);
	}
	
	@GetMapping("/students")
	public List<Student> getStudentList(){
		return studentService.getStudentList();
	}
	
	@PostMapping("/student/register")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/student/{_id}")
	public ResponseEntity<Student> getStudent(@PathVariable String _id) {
		Optional<Student> student = studentService.getStudent(_id);
		return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/student/{_id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable String _id) {
		return studentService.updateStudent(student,_id);
	}
	
	@DeleteMapping("/student/{_id}")
	public void deleteStudent(@PathVariable String _id) {
		studentService.deleteStudent(_id);
	}
	
	    
	   
}
