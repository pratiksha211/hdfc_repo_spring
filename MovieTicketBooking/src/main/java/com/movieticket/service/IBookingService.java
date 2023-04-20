package com.movieticket.service;

import java.util.List;

import com.movieticket.dto.BookingDTO;
import com.movieticket.entity.Booking;
import com.movieticket.exception.InvalidMovieException;

public interface IBookingService {
	
	public List<Booking> getAll();
	public List<Booking> getAllMyBookings();
	public Booking bookTicket(BookingDTO booking)  throws InvalidMovieException;
	public String cancelBooking(int bookingId)  throws InvalidMovieException;

}
