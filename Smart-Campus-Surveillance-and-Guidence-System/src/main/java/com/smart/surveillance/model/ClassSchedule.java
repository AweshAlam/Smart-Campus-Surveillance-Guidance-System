package com.smart.surveillance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "classSchedule")
public class ClassSchedule {
	@Id
	private String id;
	private String day;
	private String subject;
	private String startTime;
	private String endTime;
	
	public ClassSchedule(String id, String day, String subject,String startTime, String endTime) {
		super();
		this.id = id;
		this.day = day;
		this.subject = subject;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
