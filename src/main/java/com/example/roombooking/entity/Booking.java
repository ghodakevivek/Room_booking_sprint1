package com.example.roombooking.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //Specifying class is an entity
@Data  //Generate getter and setter methods for all the data members
@AllArgsConstructor  //Generates an all-args constructor
@NoArgsConstructor  //Generates a no-args constructor
@Table(name="booking_info")
public class Booking {

	@Id   //Making id a primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Making id as auto generated
	private int bookingId;
	
	@NotEmpty(message = "Date should not be empty. The expected format is yyyy-MM-dd")
	private LocalDate bookingDate;
	
	@NotEmpty(message="Days should not be empty")  
	private int bookingDays;							//Data members
	
	@NotEmpty(message="Persons should not be empty")
	private int bookingPersons;
	
	//Booking has one to one connection with room
	@OneToOne
    @JoinColumn(name = "roomId")
    private Room room;
	
	
}
