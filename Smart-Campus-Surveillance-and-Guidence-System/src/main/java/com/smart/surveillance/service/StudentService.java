package com.smart.surveillance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart.surveillance.model.Student;
import com.smart.surveillance.repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
	public List<Student> getStudentList() {
		return studentRepo.findAll();
	}
	
	public Student saveStudent(Student student) {
    	student.setPassword(passwordEncoder.encode(student.getPassword()));
		return studentRepo.save(student);
	}
	
	public Student getStudent(Long reg_no) {
		return studentRepo.getOne(reg_no);
	}
	
	public Student updateStudent(Student student,Long reg_no) {
		if(studentRepo.existsById(reg_no)) {
			student.setReg_no(reg_no);
	    	student.setPassword(passwordEncoder.encode(student.getPassword()));
			return studentRepo.save(student);
		}
		return null;
	}
	
    @PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
	public void deleteStudent(Long reg_no) {
    	studentRepo.deleteById(reg_no);
	}
}
