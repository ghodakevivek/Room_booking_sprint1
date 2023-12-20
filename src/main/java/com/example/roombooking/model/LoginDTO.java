package com.example.roombooking.model;

import lombok.Data;

@Data
public class LoginDTO {

	private String userEmail;
	private String userPassword;
	
	public LoginDTO() {
	}
	public LoginDTO(String userEmail, String userPassword) {
	this.userEmail = userEmail;
	this.userPassword = userPassword;
	}
}
