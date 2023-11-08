package com.example.roombooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //Specifying class is an entity
@Data  //Generate getter and setter methods for all the data members
@AllArgsConstructor  //Generates an all-args constructor
@NoArgsConstructor  //Generates a no-args constructor
@Table(name="room_info")
public class Room {

	
	@Id   //Making id a primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Making id as auto generated
	private int roomId;
	
	@NotNull(message="Room number should not be null")   
	private String roomNumber;								//Data members
	
	@NotNull(message="Room type should not be null")
	private String roomType;
	
	@NotEmpty(message="Price should not be null")
	private int roomPrice;
	
	@NotEmpty(message="Beds should not be null")
	private int roomBeds;
	
	// Room has many to one connection with user
	@ManyToOne
    @JoinColumn(name = "userId")
    private User user;	
	
}
