package com.example.roombooking.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.roombooking.entity.Booking;
import com.example.roombooking.model.BookingDTO;
@Component
public class BookingConverter {

	public Booking convertToBookingEntity(BookingDTO bookingDto) {
		Booking booking=new Booking();
		if(bookingDto!=null)
		{
			BeanUtils.copyProperties(bookingDto, booking);
		}
		return booking;
	}

	public BookingDTO convertToBookingDTO(Booking b)
	{
		BookingDTO bookingDto=new BookingDTO();
		if(b!=null)
		{
			BeanUtils.copyProperties(b, bookingDto);
		}
		return bookingDto;
	}

}
