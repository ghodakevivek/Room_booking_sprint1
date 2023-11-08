package com.example.roombooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //Specifying class is an entity
@Data  //Generate getter and setter methods for all the data members
@AllArgsConstructor  //Generates an all-args constructor
@NoArgsConstructor  //Generates a no-args constructor
@Table(name="user_info")
public class User {

	
	@Id   //Making id a primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Making id as auto generated
	private int userId;
	
	@NotNull(message="First name should not be null")
	private String userFirstName;							//Data members
	
	@NotNull(message="Last name should not be null")
	private String userLastName;
	
	@NotNull(message="Aadhar should not be null")
	@Size(min=12, max=12)
	private String userAadhar;
	
	@Min(value = 18, message = "Age must not be greater than 18")
	@Max(value = 100, message = "Age must not be greater than 100")
	private int userAge;
	
	@NotNull(message="City should not be null")
	private String userCity;
	
	@NotNull(message="Mobile should not be null")
	@Size(min=10, max=10)
	private String userMobile;
	
	@Email(message="Enter valid email")
	private String userEmail;
	
	@NotEmpty(message = "Username should not be empty")
	private String userUserName;
	
	@NotEmpty(message = "Password should not be empty")
	private String userPassword;
	

}
