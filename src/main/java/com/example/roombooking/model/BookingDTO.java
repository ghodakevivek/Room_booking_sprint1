package com.example.roombooking.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.example.roombooking.entity.Room;

import lombok.Getter;
import lombok.Setter;

//Generate getter and setter methods for all the data members
@Setter
@Getter
public class BookingDTO {

	
	private int bookingId;
	
 @NotEmpty(message = "Date should not be empty. The expected format is yyyy-MM-dd")
	private LocalDate bookingDate;
	
	@NotEmpty(message="Days should not be empty")
	private int bookingDays;							//Data members
	
	@NotEmpty(message="Persons should not be empty")
	private int bookingPersons;
	
	private Room room;
	
}
