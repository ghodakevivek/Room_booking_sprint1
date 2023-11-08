package com.example.roombooking.model;

import javax.validation.constraints.NotNull;

import com.example.roombooking.entity.Admin;

import lombok.Getter;
import lombok.Setter;

//Generate getter and setter methods for all the data members
@Getter
@Setter
public class PermissionDTO {

	private int permissionId;
	
	@NotNull(message="Request status should not be null")
	private String requestStatus;								//Data members
	
	private Admin admin;
	
}
