package com.movieticket.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieticket.dto.BookingDTO;
import com.movieticket.entity.Booking;
import com.movieticket.exception.InvalidMovieException;
import com.movieticket.service.IBookingService;

@RestController
@RequestMapping("/movies")
public class BookingController {
	
	@Autowired
	IBookingService bookingservices;
	
	@PostMapping("/bookticket")
	public Booking bookTicket(@RequestBody BookingDTO booking) throws InvalidMovieException {
		return bookingservices.bookTicket(booking);
	}
	
	@GetMapping("/getmybookinghistory")
	public List<Booking> getAllBookings() {
		return bookingservices.getAllMyBookings();
	}
	
	@DeleteMapping("/cancelbooking/{bookingId}")
	public String cancelBooking(@PathVariable int bookingId) throws InvalidMovieException {
		return bookingservices.cancelBooking(bookingId);

	}

}
