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
@Table(name="payment_info")
public class Payment {

	@Id   //Making id a primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Making id as auto generated
	private int paymentId;
	
	@NotEmpty(message="Amount should not be empty")   
	private int paymentAmount;							//Data members
	
	@NotEmpty(message = "Date should not be empty. The expected format is yyyy-MM-dd")
	private LocalDate paymentDate;
	
	// Payment has One to one connection with booking
	@OneToOne
	@JoinColumn(name = "bookingId")
    private Booking booking;
	
	

}
