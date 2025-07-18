package com.employeemanagament.dto;

import java.util.Date;

public class ErrorDetails {
	private String message;
	private String description;
	private Date timestamp;
	
	public ErrorDetails(String message, Date timestamp, String description) {
		super();
		this.message = message;
		this.description = description;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
