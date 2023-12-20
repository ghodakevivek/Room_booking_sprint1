package com.example.roombooking.service;

import java.util.List;

import com.example.roombooking.entity.Booking;
import com.example.roombooking.model.BookingDTO;

public interface BookingService {

	public BookingDTO createBooking(Booking booking);
	public List<BookingDTO> getAllBookings();
	public BookingDTO getBookingById(int id);
	public BookingDTO updateBooking(int id, Booking booking);
	public String deleteBooking(int id);
	public Booking assignRoom(int roomId, int roomId2);
}
