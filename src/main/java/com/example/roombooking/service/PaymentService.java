package com.example.roombooking.service;

import java.util.List;

import com.example.roombooking.entity.Payment;
import com.example.roombooking.model.PaymentDTO;

public interface PaymentService {

	public PaymentDTO createPayment(Payment payment);
	public List<PaymentDTO> getAllPayments();
	public PaymentDTO getPaymentById(int id);
	public PaymentDTO updatePayment(int id, Payment payment);
	public String deletePayment(int id);

}
