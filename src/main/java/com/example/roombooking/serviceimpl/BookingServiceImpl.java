package com.example.roombooking.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roombooking.dao.BookingRepository;
import com.example.roombooking.entity.Booking;
import com.example.roombooking.model.BookingDTO;
import com.example.roombooking.service.BookingService;
import com.example.roombooking.util.BookingConverter;

@Service
public class BookingServiceImpl implements BookingService{

	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private BookingConverter bookingConverter;
	
	
	// create booking method
	@Override
	public BookingDTO createBooking(Booking booking)
	{
		Booking b=bookingRepository.save(booking);
		return bookingConverter.convertToBookingDTO(b);
	}
	
	
	// Retrieve all booking
	@Override
	public List<BookingDTO> getAllBookings()
	{
		List<Booking> booking=bookingRepository.findAll();
		
		//List of type DTO
		List<BookingDTO> dtoList=new ArrayList<>();
		for(Booking b: booking)
		{
			dtoList.add(bookingConverter.convertToBookingDTO(b));
		}
		return dtoList;
	}
	
	
	// Retrieve booking by id
	@Override
	public BookingDTO getBookingById(int id)
	{
		Booking b=bookingRepository.findByBookingId(id);
		return bookingConverter.convertToBookingDTO(b);
		
	}
	
	
	// Update booking by id
	@Override
	public BookingDTO updateBooking(int id, Booking booking)
	{
		Booking b=bookingRepository.findByBookingId(id);
		
		b.setBookingDate(booking.getBookingDate());
		b.setBookingDays(booking.getBookingDays());
		b.setBookingPersons(booking.getBookingPersons());
		
		
		
		Booking bk=bookingRepository.save(b);
		return bookingConverter.convertToBookingDTO(bk);
	}
	
	
	// Delete adminLogin by id
	@Override
	public String deleteBooking(int id)
	{
		bookingRepository.deleteById(id);
		return "Booking got deleted successfully";
	}
	
}
