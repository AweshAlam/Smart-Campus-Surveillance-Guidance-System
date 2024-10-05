package com.smart.surveillance.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "classSchedule")
public class ClassSchedule {
	private Long cs_id;
	private String sec;
	private String day;
	private String time;
	private String subject;
	public Long getCs_id() {
		return cs_id;
	}
	public void setCs_id(Long cs_id) {
		this.cs_id = cs_id;
	}
	public String getSec() {
		return sec;
	}
	public void setSec(String sec) {
		this.sec = sec;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
