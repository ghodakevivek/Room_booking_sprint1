package com.example.roombooking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

//Generate getter and setter methods for all the data members
@Getter
@Setter
public class AdminDTO {
	
	private int adminId;
	
	@NotEmpty(message = "UserName should not be empty")
	private String adminUserName;							//Data members                   
	
	@NotEmpty(message = "Password should not be empty")
	private String adminPassword;
	
	@Email(message= "Email not valid")
	private String adminEmail;
	
}
