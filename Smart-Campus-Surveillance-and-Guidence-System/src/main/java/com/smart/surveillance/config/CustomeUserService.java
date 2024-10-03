package com.smart.surveillance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.surveillance.model.Admin;
import com.smart.surveillance.model.Student;
import com.smart.surveillance.repository.AdminRepo;
import com.smart.surveillance.repository.StudentRepo;

public class CustomeUserService implements UserDetailsService {
	@Autowired
	private StudentRepo studentrepo;
	
	@Autowired
	private AdminRepo adminrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  Student student = studentrepo.findByUsername(username);
	        if (student != null) {
	           
	            return new CustomeUser(student, "ROLE_STUDENT");
	        }
	        
	        Admin admin = adminrepo.findByUsername(username);
	        if (admin != null) {
	           
	            return new CustomeUser(admin, "ROLE_ADMIN");
	        }
	        
	        
	        throw new UsernameNotFoundException("User not found: " + username);
		
	}

}
