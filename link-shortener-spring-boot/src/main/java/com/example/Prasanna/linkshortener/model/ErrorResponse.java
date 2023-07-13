package com.example.Prasanna.linkshortener.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ErrorResponse {
	private String message;

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}
	public ErrorResponse() {}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
