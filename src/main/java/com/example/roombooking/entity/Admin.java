package com.example.roombooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //Specifying class is an entity
@Data  //Generate getter and setter methods for all the data members
@AllArgsConstructor  //Generates an all-args constructor
@NoArgsConstructor  //Generates a no-args constructor
@Table(name="admin_info")  
public class Admin {

	@Id   //Making id a primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Making id as auto generated
	private int adminId;
	
	@NotEmpty(message = "UserName should not be empty")   
	private String adminUserName;							//Data members
	
	@NotEmpty(message = "Password should not be empty")
	private String adminPassword;
	
	@Email(message= "Email not valid")
	private String adminEmail;
}
