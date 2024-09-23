package com.smart.surveillance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.surveillance.model.Employee;
import com.smart.surveillance.service.EmployeeService;

@Controller
//@RequestMapping
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/register")
    public String showRegistrationForm() {
        return "register";  // This returns the register.html page
    }
//	@GetMapping
//	public List<Employee> getAllEmployee(){
//		return employeeService.getEmployeeList();
//	}
	
	@PostMapping("/register")
	public Employee saveEmployee(@RequestBody Employee employee ) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/employee/{emp_id}")
	public Employee getEmployee(@PathVariable Long emp_id) {
		return employeeService.getEmployee(emp_id);
	}
	
	@PutMapping("/update/{emp_id}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable Long emp_id) {
		return employeeService.updateEmployee(employee, emp_id);
	}
	
	@DeleteMapping("/delete/{emp_id}")
	public void deleteEmployee(@PathVariable Long emp_id) {
		employeeService.deleteEmployee(emp_id);
	}
	
}
