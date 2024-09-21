package com.smart.surveillance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.surveillance.model.Employee;
import com.smart.surveillance.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeService.getEmployeeList();
	}
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee ) {
		return employeeService.saveEmployee(employee);
	}
}
