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

import com.example.roombooking.dao.BookingRepository;
import com.example.roombooking.entity.Booking;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingRepositoryTest {

	
	@Autowired
    private BookingRepository bookingRepository;

    @Test
    public void testCreateBooking() {
    	 // Create and save an booking
        Booking booking = new Booking();
        booking.setBookingDate(LocalDate.now());
        booking.setBookingDays(2);
        booking.setBookingPersons(4);
        booking.setRoom(null);
     

        Booking savedBooking = bookingRepository.save(booking);
        assertNotNull(savedBooking.getBookingId());
    }
    
    
    
    
    @Test
    public void testGetAllBookings() {
    	
    	 // Clear the database to ensure a clean state
        bookingRepository.deleteAll();
    	
        // Create and save multiple booking entities
        Booking booking1 = new Booking(1, LocalDate.now( ), 2,4,null );
        Booking booking2 = new Booking(2, LocalDate.now( ), 2,4,null);
        Booking booking3 = new Booking(3, LocalDate.now( ), 2,4,null);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);

        // Retrieve all bookings from the database
        List<Booking> allBookings = bookingRepository.findAll();

        // Assert that the list is not empty and contains the expected number of bookings
        assertNotNull(allBookings);
        assertEquals(3, allBookings.size());
    }
    
    
    
    
    
    @Test
    public void testGetBookingById() {
        // Create and save an booking
        Booking booking = new Booking();
        booking.setBookingDate(LocalDate.now());
        booking.setBookingDays(2);
        booking.setBookingPersons(4);

        booking = bookingRepository.save(booking);

        // Retrieve the booking by ID
        Booking retrievedBooking = bookingRepository.findById(booking.getBookingId()).orElse(null);

        // Assert that the retrieved booking is not null and has the correct ID
        assertNotNull(retrievedBooking);
        assertEquals(booking.getBookingId(), retrievedBooking.getBookingId());
        assertEquals(LocalDate.now(), retrievedBooking.getBookingDate());
        assertEquals(2, retrievedBooking.getBookingDays());
        assertEquals(4, retrievedBooking.getBookingPersons());
    }

    
    
    @Test
    public void testUpdateBookingById() {
        // Create and save an booking
        Booking booking = new Booking();
        booking.setBookingDate(LocalDate.now());
        booking.setBookingDays(2);
        booking.setBookingPersons(4);

        booking = bookingRepository.save(booking);

        // Update the booking's details
        int bookingId = booking.getBookingId();
        Booking updatedBooking = bookingRepository.findById(bookingId).orElse(null);
        assertNotNull(updatedBooking);

        // Modify the booking's attributes
        updatedBooking.setBookingDate(LocalDate.now()); 
        updatedBooking.setBookingDays(2); 
        updatedBooking.setBookingPersons(4); 

        // Save the updated booking
        updatedBooking = bookingRepository.save(updatedBooking);

        // Retrieve the updated booking from the database
        Booking retrievedBooking = bookingRepository.findById(bookingId).orElse(null);
        assertNotNull(retrievedBooking);

        // Assert that the attributes have been updated
        assertEquals(LocalDate.now(), retrievedBooking.getBookingDate());
        assertEquals(2, retrievedBooking.getBookingDays());
        assertEquals(4, retrievedBooking.getBookingPersons());
    }


    
    
    @Test
    public void testDeleteBookingById() {
        // Create and save an booking
        Booking booking = new Booking();
        booking.setBookingDate(LocalDate.now());
        booking.setBookingDays(2);
        booking.setBookingPersons(4);

        booking = bookingRepository.save(booking);

        // Get the ID of the booking to be deleted
        int bookingId = booking.getBookingId();

        // Delete the booking by ID
        bookingRepository.deleteById(bookingId);

        // Try to retrieve the deleted booking by ID, and it should be null
        Booking deletedBooking = bookingRepository.findById(bookingId).orElse(null);
        assertNull(deletedBooking);
    }

	
	
	
}
