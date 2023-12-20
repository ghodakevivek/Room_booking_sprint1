package com.example.roombooking.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.example.roombooking.entity.Booking;

import lombok.Getter;
import lombok.Setter;

//Generate getter and setter methods for all the data members
@Getter
@Setter
public class PaymentDTO {

	private int paymentId;
	
	@NotNull(message="Amount should not be null")
	private int paymentAmount;							//Data members
	
	@NotNull(message = "Date should not be null. The expected format is yyyy-MM-dd")
	private LocalDate paymentDate;
	
	private Booking booking;
	
}
