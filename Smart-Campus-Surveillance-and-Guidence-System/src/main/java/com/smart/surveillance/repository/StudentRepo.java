package com.smart.surveillance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.smart.surveillance.model.Student;

public interface StudentRepo extends MongoRepository<Student, String> {
	Student findByUsername(String email);
}
