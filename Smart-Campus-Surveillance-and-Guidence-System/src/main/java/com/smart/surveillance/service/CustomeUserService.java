package com.smart.surveillance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smart.surveillance.config.CustomeUser;
import com.smart.surveillance.model.Admin;
import com.smart.surveillance.model.Student;
import com.smart.surveillance.repository.AdminRepo;
import com.smart.surveillance.repository.StudentRepo;
@Service 
public class CustomeUserService implements UserDetailsService {
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  Student student = studentRepo.findByUsername(username);
	        if (student != null) {
	           
	            return new CustomeUser(student, "ROLE_STUDENT");
	        }
	        
	        Admin admin = adminRepo.findByUsername(username);
	        if (admin != null) {
	           
	            return new CustomeUser(admin, "ROLE_ADMIN");
	        }
	        
	        
	        throw new UsernameNotFoundException("User not found: " + username);
		
	}

}
