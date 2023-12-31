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
import com.example.roombooking.entity.Room;
import com.example.roombooking.model.BookingDTO;
import com.example.roombooking.service.BookingService;
import com.example.roombooking.util.BookingConverter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private BookingConverter bookingConverter;
	
	
	// Method for creating the booking
	@PostMapping("/createBooking")
	public ResponseEntity<BookingDTO> createBooking (@Valid @RequestBody BookingDTO bookingDto)
	{
		final Booking booking=bookingConverter.convertToBookingEntity(bookingDto);
		return new ResponseEntity<BookingDTO>(bookingService.createBooking(booking), HttpStatus.CREATED);
	}

	
	// Method for retrieving all bookings
	@GetMapping("/getAllBookings")
	public List<BookingDTO> getAllBookings()
	{
		return bookingService.getAllBookings();
	}
	
	
	// method for retrieving booking using Id
	@GetMapping("/getBookingById/{id}")
	public BookingDTO getBookingById (@PathVariable int id)
	{
		return bookingService.getBookingById(id);
	}
	
	
	//assign booking to room
		@PostMapping("/booking/assignRoom/{roomId}/{bookingId}")
		public ResponseEntity<Booking> assignRoom(@PathVariable("roomId") int roomId,
		@PathVariable("bookingId") int bookingId)
		{
			return new ResponseEntity<Booking>(bookingService.assignRoom(roomId, bookingId),
			HttpStatus.CREATED);
		}
	
	
	// Method for updating the booking
	@PutMapping("/updateBooking/{id}")
	public BookingDTO updateBooking(@Valid @PathVariable int id, @RequestBody BookingDTO bookingDto)
	{
		final Booking booking=bookingConverter.convertToBookingEntity(bookingDto);
		return bookingService.updateBooking(id, booking);
	}
	
	
	// Method for deleting the booking using id
	@DeleteMapping("deleteBooking/{id}")
	public String deleteBooking (@PathVariable int id)
	{
		return bookingService.deleteBooking(id);
	}
}
