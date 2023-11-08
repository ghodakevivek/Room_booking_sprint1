package com.example.roombooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.roombooking.entity.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

	Booking findByBookingId(int bookingId);
}
