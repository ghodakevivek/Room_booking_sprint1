package com.example.roombooking.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.example.roombooking.entity.Room;

import lombok.Getter;
import lombok.Setter;

//Generate getter and setter methods for all the data members
@Setter
@Getter
public class BookingDTO {

	
	private int bookingId;
	
	@NotNull(message = "Date should not be null. The expected format is yyyy-MM-dd")
	private LocalDate checkInDate;
	
	@NotNull(message = "Date should not be null. The expected format is yyyy-MM-dd")
	private LocalDate checkOutDate;
	
	@NotNull(message="Days should not be null")
	private int bookingDays;							//Data members
	
	@NotNull(message="Persons should not be null")
	private int bookingPersons;

	
	private Room room;
	
}
