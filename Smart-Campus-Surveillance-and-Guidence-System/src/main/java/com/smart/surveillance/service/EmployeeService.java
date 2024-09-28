package com.smart.surveillance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart.surveillance.model.Employee;
import com.smart.surveillance.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

    @PreAuthorize("hasRole('ADMIN')")
	public List<Employee> getEmployeeList() {
		return employeeRepo.findAll();
	}
	
    @PreAuthorize("hasRole('ADMIN')")
	public Employee saveEmployee(Employee employee) {
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		return employeeRepo.save(employee);
	}
	
	public Employee getEmployee(Long emp_id) {
		return employeeRepo.getOne(emp_id);
	}
	
	public Employee updateEmployee(Employee employee,Long emp_id) {
		if(employeeRepo.existsById(emp_id)) {
			employee.setEmp_id(emp_id);
			employee.setPassword(passwordEncoder.encode(employee.getPassword()));
			return employeeRepo.save(employee);
		}
		return null;
	}
	
    @PreAuthorize("hasRole('ADMIN')")
	public void deleteEmployee(Long emp_id) {
		employeeRepo.deleteById(emp_id);
	}
}
