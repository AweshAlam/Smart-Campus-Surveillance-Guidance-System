package com.smart.surveillance.service;

import java.util.List;
import java.util.Optional;

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

    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<Student> getStudentList() {
        return studentRepo.findAll();
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Student saveStudent(Student student) {
    	String defaultPassword = "12345";
    	String encodedPassword = passwordEncoder.encode(defaultPassword);
        student.setPassword(encodedPassword);
        student.setUsername(student.getReg_no());
        return studentRepo.save(student);
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    public Optional<Student> getStudent(String _id) {
        return studentRepo.findById(_id);
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    public Student updateStudent(Student student, String _id) {
        Optional<Student> existingStudent = studentRepo.findById(_id);
        if (existingStudent.isPresent()) {
            Student stuToUpdate = existingStudent.get();
            stuToUpdate.setReg_no(_id);
            stuToUpdate.setS_name(student.getS_name());
            stuToUpdate.setEmail(student.getEmail());
            stuToUpdate.setMob_no(student.getMob_no());
            
            if (!student.getPassword().isEmpty()) {
                stuToUpdate.setPassword(passwordEncoder.encode(student.getPassword()));
            }

            return studentRepo.save(stuToUpdate);
        }
        return null;
    }
    
    public Student updatePassword(Student student, String _id) {
        Optional<Student> existingStudent = studentRepo.findById(_id);
        if (existingStudent.isPresent()) {
            Student stuToUpdate = existingStudent.get();
            if (!student.getPassword().isEmpty()) {
                stuToUpdate.setPassword(passwordEncoder.encode(student.getPassword()));
            }

            return studentRepo.save(stuToUpdate);
        }
        return null;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public void deleteStudent(String _id) {
        studentRepo.deleteById(_id);
    }
}
