package com.example.roombooking.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.roombooking.dao.PaymentRepository;
import com.example.roombooking.entity.Payment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentRepositoryTest {

	
	
	  @Autowired
	  private PaymentRepository paymentRepository;
	 

      
	    @Test
	    public void testCreatePayment() {
	    	 // Create and save an payment
	        Payment payment = new Payment();
	        payment.setPaymentAmount(1000);
	        payment.setPaymentDate(LocalDate.now());
	       

	        Payment savedPayment = paymentRepository.save(payment);
	        assertNotNull(savedPayment.getPaymentId());
	    }
	    
	    

	 
	    public void testGetAllPayments() {
	    	
	    	 // Clear the database to ensure a clean state
	        paymentRepository.deleteAll();
	    	
	        // Create and save multiple payment entities
	        Payment payment1 = new Payment(1, 2000, LocalDate.now(), null);
	        Payment payment2 = new Payment(2,2000, LocalDate.now(), null);
	        Payment payment3 = new Payment(3,2000, LocalDate.now(), null);

	        paymentRepository.save(payment1);
	        paymentRepository.save(payment2);
	        paymentRepository.save(payment3);

	        // Retrieve all payments from the database
	        List<Payment> allPayments = paymentRepository.findAll();

	        // Assert that the list is not empty and contains the expected number of payments
	        assertNotNull(allPayments);
	        assertEquals(3, allPayments.size());
	    }
	    

	    
	    
	    @Test
	    public void testGetPaymentById() {
	        // Create and save an payment
	        Payment payment = new Payment();
	        payment.setPaymentAmount(1000);
	        payment.setPaymentDate(LocalDate.now());

	        payment = paymentRepository.save(payment);

	        // Retrieve the payment by ID
	        Payment retrievedPayment = paymentRepository.findById(payment.getPaymentId()).orElse(null);

	        // Assert that the retrieved payment is not null and has the correct ID
	        assertNotNull(retrievedPayment);
	        assertEquals(payment.getPaymentId(), retrievedPayment.getPaymentId());
	        assertEquals(1000, retrievedPayment.getPaymentAmount());
	        assertEquals(LocalDate.now(), retrievedPayment.getPaymentDate());
	        
	    }
	
	    
	    
	    @Test
	    public void testUpdatePaymentById() {
	        // Create and save an payment
	        Payment payment = new Payment();
	        payment.setPaymentAmount(1000);
	        payment.setPaymentDate(LocalDate.now());

	        payment = paymentRepository.save(payment);

	        // Update the payment's details
	        int paymentId = payment.getPaymentId();
	        Payment updatedPayment = paymentRepository.findById(paymentId).orElse(null);
	        assertNotNull(updatedPayment);

	        // Modify the payment's attributes
	        updatedPayment.setPaymentAmount(1000); 
	        updatedPayment.setPaymentDate(LocalDate.now()); 
	       

	        // Save the updated payment
	        updatedPayment = paymentRepository.save(updatedPayment);

	        // Retrieve the updated payment from the database
	        Payment retrievedPayment = paymentRepository.findById(paymentId).orElse(null);
	        assertNotNull(retrievedPayment);

	        // Assert that the attributes have been updated
	        assertEquals(1000, retrievedPayment.getPaymentAmount());
	        assertEquals(LocalDate.now(), retrievedPayment.getPaymentDate());
	        
	    }


	    
	    
	    @Test
	    public void testDeletePaymentById() {
	        // Create and save an payment
	        Payment payment = new Payment();
	        payment.setPaymentAmount(1000);
	        payment.setPaymentDate(LocalDate.now());

	        payment = paymentRepository.save(payment);

	        // Get the ID of the payment to be deleted
	        int paymentId = payment.getPaymentId();

	        // Delete the payment by ID
	        paymentRepository.deleteById(paymentId);

	        // Try to retrieve the deleted payment by ID, and it should be null
	        Payment deletedPayment = paymentRepository.findById(paymentId).orElse(null);
	        assertNull(deletedPayment);
	    }

	
	
}
