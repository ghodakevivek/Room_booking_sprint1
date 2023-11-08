package com.example.roombooking.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.roombooking.entity.Payment;
import com.example.roombooking.model.PaymentDTO;
@Component
public class PaymentConverter {

	public Payment convertToPaymentEntity(PaymentDTO paymentDto) {
		Payment payment=new Payment();
		if(paymentDto!=null)
		{
			BeanUtils.copyProperties(paymentDto, payment);
		}
		return payment;
	}

	public PaymentDTO convertToPaymentDTO(Payment p)
	{
		PaymentDTO paymentDto=new PaymentDTO();
		if(p!=null)
		{
			BeanUtils.copyProperties(p, paymentDto);
		}
		return paymentDto;
	}

}
