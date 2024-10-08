package com.smart.surveillance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {

    @Id
    private Long reg_no;
    private String s_name;
    private String email;
    private String mob_no;
    private String username;
    private String password;
    
	@DBRef
    private ClassSchedule classSchedule;
	
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ClassSchedule getClassSchedule() {
		return classSchedule;
	}

	public void setClassSchedule(ClassSchedule classSchedule) {
		this.classSchedule = classSchedule;
	}

    public Long getReg_no() {
        return reg_no;
    }

    public void setReg_no(Long reg_no) {
        this.reg_no = reg_no;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        this.username = email;
    }

    public String getMob_no() {
        return mob_no;
    }

    public void setMob_no(String mob_no) {
        this.mob_no = mob_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Student(Long reg_no, String s_name, String email, String mob_no, String username, String password,
			ClassSchedule classSchedule) {
		super();
		this.reg_no = reg_no;
		this.s_name = s_name;
		this.email = email;
		this.mob_no = mob_no;
		this.username = email;
		this.password = password;
		this.classSchedule = classSchedule;
	}
}
