package com.example.roombooking.model;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

//Generate getter and setter methods for all the data members
@Getter
@Setter
public class UserLoginDTO {

	private int userLoginId;
	
	@NotEmpty(message = "Username should not be empty")
	private String userUserName;							//Data members
	
	@NotEmpty(message = "Password should not be empty")
	private String userPassword;
	
}
