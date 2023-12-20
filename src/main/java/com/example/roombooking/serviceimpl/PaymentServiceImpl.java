package com.example.roombooking.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roombooking.dao.BookingRepository;
import com.example.roombooking.dao.PaymentRepository;
import com.example.roombooking.entity.Booking;
import com.example.roombooking.entity.Payment;
import com.example.roombooking.model.PaymentDTO;
import com.example.roombooking.service.PaymentService;
import com.example.roombooking.util.PaymentConverter;


@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private PaymentConverter paymentConverter;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	
	// create payment method
	@Override
	public PaymentDTO createPayment(Payment payment)
	{
		Payment p=paymentRepository.save(payment);
		return paymentConverter.convertToPaymentDTO(p);
	}
	
	
	// Retrieve all payments
	@Override
	public List<PaymentDTO> getAllPayments()
	{
		List<Payment> payment=paymentRepository.findAll();
		
		//List of type DTO
		List<PaymentDTO> dtoList=new ArrayList<>();
		for(Payment p: payment)
		{
			dtoList.add(paymentConverter.convertToPaymentDTO(p));
		}
		return dtoList;
	}
	
	
	// Retrieve payment by id
	@Override
	public PaymentDTO getPaymentById(int id)
	{
		Payment p=paymentRepository.findByPaymentId(id);
		return paymentConverter.convertToPaymentDTO(p);
		
	}
	
	
	@Override
	public Payment assignBooking(int bookingId, int paymentId) {
	Booking booking1=bookingRepository.findByBookingId(bookingId);
	   Payment payment = paymentRepository.findByPaymentId(paymentId);
	   payment.setBooking(booking1);	
	  return paymentRepository.save(payment); 
	}
	
	
	
	// Update payment by id
	@Override
	public PaymentDTO updatePayment(int id, Payment payment)
	{
		Payment p=paymentRepository.findByPaymentId(id);
		
		p.setPaymentAmount(payment.getPaymentAmount());
		p.setPaymentDate(payment.getPaymentDate());
		
		
	
				
		Payment pm=paymentRepository.save(p);
		return paymentConverter.convertToPaymentDTO(pm);
	}
	
	
	// Delete payment by id
	@Override
	public String deletePayment(int id)
	{
		paymentRepository.deleteById(id);
		return "Payment got deleted successfully";
	}
}
