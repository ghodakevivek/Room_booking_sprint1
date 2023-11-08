package com.example.roombooking.model;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

//Generate getter and setter methods for all the data members
@Getter
@Setter
public class AdminLoginDTO {


	private int adminLoginId;
	
	@NotEmpty(message = "UserName should not be empty")
	private String adminUserName;							//Data members
	
	@NotEmpty(message = "Password should not be empty")
	private String adminPassword;
	
	
}
