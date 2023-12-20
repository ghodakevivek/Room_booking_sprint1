package com.example.roombooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.roombooking.entity.Booking;
import com.example.roombooking.entity.Payment;
import com.example.roombooking.model.PaymentDTO;
import com.example.roombooking.service.PaymentService;
import com.example.roombooking.util.PaymentConverter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PaymentConverter paymentConverter;
	
	
	// Method for creating the payment
	@PostMapping("/createPayment")
	public ResponseEntity<PaymentDTO> createPayment (@Valid @RequestBody PaymentDTO paymentDto)
	{
		final Payment payment=paymentConverter.convertToPaymentEntity(paymentDto);
		return new ResponseEntity<PaymentDTO>(paymentService.createPayment(payment), HttpStatus.CREATED);
	}
	
	
	// Method for retrieving all payments
	@GetMapping("/getAllPayments")
	public List<PaymentDTO> getAllPayments()
	{
		return paymentService.getAllPayments();
	}
	
	
	// method for retrieving payment using Id
	@GetMapping("/getPaymentById/{id}")
	public PaymentDTO getPaymentById (@PathVariable int id)
	{
		return paymentService.getPaymentById(id);
	}
	
	
	//assign payment to booking
	@PostMapping("/payment/assignBooking/{bookingId}/{paymentId}")
	public ResponseEntity<Payment> assignBooking(@PathVariable("bookingId") int bookingId,
	@PathVariable("paymentId") int paymentId)
	{
		return new ResponseEntity<Payment>(paymentService.assignBooking(bookingId, paymentId),
		HttpStatus.CREATED);
	}
	
	
	// Method for updating the payment
	@PutMapping("/updatePayment/{id}")
	public PaymentDTO updatePayment(@Valid @PathVariable int id, @RequestBody PaymentDTO paymentDto)
	{
		final Payment payment=paymentConverter.convertToPaymentEntity(paymentDto);
		return paymentService.updatePayment(id, payment);
	}
	
	
	// Method for deleting the payment using id
	@DeleteMapping("deletePayment/{id}")
	public String deletePayment(@PathVariable int id)
	{
		return paymentService.deletePayment(id);
	}
}
