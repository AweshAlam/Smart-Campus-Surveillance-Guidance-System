package com.smart.surveillance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin(origins = " http://localhost:4200")
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
	
	@CrossOrigin(origins = " http://localhost:4200")
	@PostMapping("/student/register")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/student/{reg_no}")
	public Optional<Student> getStudent(@PathVariable String reg_no) {
		return studentService.getStudent(reg_no);
	}
	
	@PutMapping("/student/{reg_no}")
	public Student updateStudent(@RequestBody Student student,@PathVariable String reg_no) {
		return studentService.updateStudent(student,reg_no);
	}
	
	@DeleteMapping("/student/{reg_no}")
	public void deleteStudent(@PathVariable String reg_no) {
		studentService.deleteStudent(reg_no);
	}
}
