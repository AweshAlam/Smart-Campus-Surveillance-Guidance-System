package com.smart.surveillance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.surveillance.model.Employee;
import com.smart.surveillance.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<Employee> getEmployeeList() {
		return employeeRepo.findAll();
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
}
