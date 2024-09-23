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
	
//	public List<Employee> getEmployeeList() {
//		return employeeRepo.findAll();
//	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee getEmployee(Long emp_id) {
		return employeeRepo.getOne(emp_id);
	}
	public Employee updateEmployee(Employee employee,Long emp_id) {
		if(employeeRepo.existsById(emp_id)) {
			employee.setEmp_id(emp_id);
			return employeeRepo.save(employee);
		}
		return null;
	}
	
	public void deleteEmployee(Long emp_id) {
		employeeRepo.deleteById(emp_id);
	}
}
