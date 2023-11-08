package com.example.roombooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.roombooking.entity.Payment;
import com.example.roombooking.model.PaymentDTO;
import com.example.roombooking.service.PaymentService;
import com.example.roombooking.util.PaymentConverter;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private PaymentConverter paymentConverter;
	
	
	// Method for creating the payment
	@PostMapping("/create")
	public ResponseEntity<PaymentDTO> createPayment (@Valid @RequestBody PaymentDTO paymentDto)
	{
		final Payment payment=paymentConverter.convertToPaymentEntity(paymentDto);
		return new ResponseEntity<PaymentDTO>(paymentService.createPayment(payment), HttpStatus.CREATED);
	}
	
	
	// Method for retrieving all payments
	@GetMapping("/getAll")
	public List<PaymentDTO> getAllPayments()
	{
		return paymentService.getAllPayments();
	}
	
	
	// method for retrieving payment using Id
	@GetMapping("/get/{id}")
	public PaymentDTO getPaymentById (@PathVariable int id)
	{
		return paymentService.getPaymentById(id);
	}
	
	
	// Method for updating the payment
	@PutMapping("/update/{id}")
	public PaymentDTO updatePayment(@Valid @PathVariable int id, @RequestBody PaymentDTO paymentDto)
	{
		final Payment payment=paymentConverter.convertToPaymentEntity(paymentDto);
		return paymentService.updatePayment(id, payment);
	}
	
	
	// Method for deleting the payment using id
	@DeleteMapping("delete/{id}")
	public String deletePayment(@PathVariable int id)
	{
		return paymentService.deletePayment(id);
	}
}
