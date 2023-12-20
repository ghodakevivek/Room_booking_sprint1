package com.example.roombooking.model;

import javax.validation.constraints.NotBlank;
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
	
	@NotEmpty(message="Room number should not be Empty")
	private String roomNumber;								//Data members
	
	@NotBlank(message="Room type should not be blank")
	private String roomType;
	
	@NotNull(message="Price should not be null")
	private int roomPrice;
	
	@NotNull(message="Beds should not be null")
	private int roomBeds;
	
	private String roomImage;
	
	
	private User user;	
}
