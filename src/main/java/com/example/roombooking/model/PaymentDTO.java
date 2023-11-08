package com.example.roombooking.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.example.roombooking.entity.Booking;

import lombok.Getter;
import lombok.Setter;

//Generate getter and setter methods for all the data members
@Getter
@Setter
public class PaymentDTO {

	private int paymentId;
	
	@NotEmpty(message="Amount should not be empty")
	private int paymentAmount;							//Data members
	
	@NotEmpty(message = "Date should not be empty. The expected format is yyyy-MM-dd")
	private LocalDate paymentDate;
	
	private Booking booking;
	
}
