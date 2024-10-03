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
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepo.save(student);
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    public Optional<Student> getStudent(Long reg_no) {
        return studentRepo.findById(reg_no);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public Student updateStudent(Student student, Long reg_no) {
        Optional<Student> existingStudent = studentRepo.findById(reg_no);
        if (existingStudent.isPresent()) {
            Student stuToUpdate = existingStudent.get();
            stuToUpdate.setReg_no(reg_no);
            stuToUpdate.setS_name(student.getS_name());
            stuToUpdate.setEmail(student.getEmail());
            stuToUpdate.setMob_no(student.getMob_no());
            stuToUpdate.setUsername(student.getUsername());

            if (!student.getPassword().isEmpty()) {
                stuToUpdate.setPassword(passwordEncoder.encode(student.getPassword()));
            }

            return studentRepo.save(stuToUpdate);
        }
        return null;
    }
    
    public Student updatePassword(Student student, Long reg_no) {
        Optional<Student> existingStudent = studentRepo.findById(reg_no);
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
    public void deleteStudent(Long reg_no) {
        studentRepo.deleteById(reg_no);
    }
}
