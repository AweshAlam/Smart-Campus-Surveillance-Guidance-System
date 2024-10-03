package com.smart.surveillance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.smart.surveillance.model.Admin;

public interface AdminRepo extends MongoRepository<Admin,Long> {
	Admin findByUsername(String username);

}
