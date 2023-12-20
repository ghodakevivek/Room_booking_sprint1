package com.example.roombooking.model;

import javax.validation.constraints.NotEmpty;

import com.example.roombooking.entity.Admin;

import lombok.Getter;
import lombok.Setter;

//Generate getter and setter methods for all the data members
@Getter
@Setter
public class PermissionDTO {

	private int permissionId;
	
	@NotEmpty(message="Request status should not be empty")
	private String requestStatus;								//Data members
	
	private Admin admin;
	
}
