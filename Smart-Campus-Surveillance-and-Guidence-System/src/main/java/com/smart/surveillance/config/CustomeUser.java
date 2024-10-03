package com.smart.surveillance.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smart.surveillance.model.Admin;
import com.smart.surveillance.model.Student;

public class CustomeUser implements UserDetails{
	  private String username;
	    private String password;
	    private Collection<? extends GrantedAuthority> authorities;

	public CustomeUser(Student student, String role) {
			super();
			this.username =student.getUsername();
			this.password =student.getPassword();
			this.authorities = List.of(new SimpleGrantedAuthority(role));
		}
	
	 public CustomeUser(Admin admin, String role) {
	        this.username = admin.getUsername();
	        this.password = admin.getPassword(); 
	        this.authorities = List.of(() -> role);
	    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

}
