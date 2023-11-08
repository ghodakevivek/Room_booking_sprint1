package com.example.roombooking.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.roombooking.entity.User;

import lombok.Getter;
import lombok.Setter;

//Generate getter and setter methods for all the data members
@Setter
@Getter
public class RoomDTO {

	private int roomId;
	
	@NotNull(message="Room number should not be null")
	private String roomNumber;								//Data members
	
	@NotNull(message="Room type should not be null")
	private String roomType;
	
	@NotEmpty(message="Price should not be null")
	private int roomPrice;
	
	@NotEmpty(message="Beds should not be null")
	private int roomBeds;
	
	private User user;	
}
