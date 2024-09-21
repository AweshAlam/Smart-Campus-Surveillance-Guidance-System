package com.smart.surveillance.model;

import jakarta.persistence.Entity;

@Entity
public class Employee {
	private long emp_id;
	private String emp_name;
	private String email;
	private long mob_no;
	private String username;
	private String password;
}
