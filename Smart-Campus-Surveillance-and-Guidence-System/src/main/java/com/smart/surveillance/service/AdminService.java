package com.smart.surveillance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart.surveillance.model.Admin;
import com.smart.surveillance.model.Student;
import com.smart.surveillance.repository.AdminRepo;

@Service
public class AdminService {
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
    @PreAuthorize("hasAnyRole('ADMIN')")
	public Admin saveAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		return adminRepo.save(admin);
	}
	
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Admin updateAdmin(Admin admin, Long id) {
        Optional<Admin> existingAdmin = adminRepo.findById(id);
        if (existingAdmin.isPresent()) {
            Admin stuToUpdate = existingAdmin.get();
            stuToUpdate.setUsername(admin.getUsername());
            if (!admin.getPassword().isEmpty()) {
                stuToUpdate.setPassword(passwordEncoder.encode(admin.getPassword()));
            }

            return adminRepo.save(stuToUpdate);
        }
        return null;
    }
}
