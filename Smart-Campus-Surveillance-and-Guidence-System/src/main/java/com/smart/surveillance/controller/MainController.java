package com.smart.surveillance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.smart.surveillance.model.Employee;
import com.smart.surveillance.service.EmployeeService;

@RestController
@RequestMapping("/admin")
public class MainController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeService.getEmployeeList();
	}
	
	@PostMapping("/employee/register")
	public Employee saveEmployee(@RequestBody Employee employee ) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/employee/{emp_id}")
	public Employee getEmployee(@PathVariable Long emp_id) {
		return employeeService.getEmployee(emp_id);
	}
	
	@PutMapping("/employee/{emp_id}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable Long emp_id) {
		return employeeService.updateEmployee(employee, emp_id);
	}
	
	@DeleteMapping("/employee/{emp_id}")
	public void deleteEmployee(@PathVariable Long emp_id) {
		employeeService.deleteEmployee(emp_id);
	}
	
}
