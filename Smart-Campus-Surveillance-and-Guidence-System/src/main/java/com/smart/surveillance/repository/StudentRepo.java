package com.smart.surveillance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.surveillance.model.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
	
}