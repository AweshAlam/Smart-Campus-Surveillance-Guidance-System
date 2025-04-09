package com.smart.surveillance.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.smart.surveillance.model.Student;

public interface StudentRepo extends MongoRepository<Student, String> {
	Student findByUsername(String username);
	
//	@Query("{ '_id' : ?0 }")
    Optional<Student> findById(String _id);
}
