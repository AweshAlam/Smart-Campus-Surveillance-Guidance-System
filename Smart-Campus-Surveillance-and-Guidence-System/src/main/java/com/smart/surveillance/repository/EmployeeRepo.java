package com.smart.surveillance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.surveillance.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
