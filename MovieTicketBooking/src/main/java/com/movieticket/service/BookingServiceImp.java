package com.movieticket.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.movieticket.dto.BookingDTO;
import com.movieticket.entity.Booking;
import com.movieticket.entity.Shows;
import com.movieticket.exception.InvalidMovieException;
import com.movieticket.repository.BookingRepository;
import com.movieticket.repository.ShowsRepository;
import com.movieticket.repository.TheatreRepository;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
public class BookingServiceImp implements IBookingService {
	
	@Autowired
	BookingRepository bookingrepo;

	@Autowired
	ShowsRepository showsrepo;

	@Autowired
	TheatreRepository theatresrepo;
	

	@Override
	public List<Booking> getAll() {
		return bookingrepo.findAll();
	}
	
	
	

	@Override
	public Booking bookTicket(BookingDTO booking) throws InvalidMovieException {
		
		 Shows show = showsrepo.findById(booking.getShowId()).orElseThrow(() -> new InvalidMovieException("Invalid ShowID"));

		    LocalDateTime showDateTime = LocalDate.now().atTime(LocalTime.now());
		    LocalDateTime now = LocalDateTime.now();
		    String paymentMethod = booking.getPaymentMethod();

		    int theatreId = show.getTheatre().getTheatreId();
		    double ticketPrice = show.getTheatre().getTicketPrice();
		    Long noOfBookedSeats = bookingrepo.getBookedCount(show.getShowId());
		    Long totalCapacity = theatresrepo.getTotalCapacity(theatreId);
		    int availableSeats = (int) (totalCapacity - noOfBookedSeats);

		    if (availableSeats <= 0) {
		        throw new InvalidMovieException("No Seats Available");
		    }

		    int seatNo = booking.getSeatNo();
		    if (seatNo > totalCapacity || seatNo <= 0) {
		        throw new InvalidMovieException("Invalid Seat Number");
		    }

		    if (bookingrepo.getSeatNo(show.getShowId(), seatNo) != 0) {
		        throw new InvalidMovieException("Seat already booked");
		    }

		    if (showDateTime.isBefore(now)) {
		        throw new InvalidMovieException("Movie already started");
		    }

		    PaymentMethod payment = PaymentMethod.fromString(paymentMethod);
		    if (payment == null) {
		        throw new InvalidMovieException("Payment method not supported");
		    }

		    Booking details = new Booking();
		    details.setSeatNo(seatNo);
		    details.setBookingDate(Date.valueOf(now.toLocalDate()));
		    details.setCustomerId(SecurityContextHolder.getContext().getAuthentication().getName());
		    details.setPaymentMethod(paymentMethod);
		    details.setShow(show);
		    details.setTotalAmount(ticketPrice);

		    show.setAvailableSeats(availableSeats - 1);

		    return bookingrepo.save(details);
		}

		enum PaymentMethod {
		    NETBANKING("NETBANKING"),
		    DC("DC"),
		    UPI("UPI");

		    private final String value;

		    PaymentMethod(String value) {
		        this.value = value;
		    }

		    public static PaymentMethod fromString(String value) {
		        for (PaymentMethod paymentMethod : PaymentMethod.values()) {
		            if (paymentMethod.value.equals(value)) {
		                return paymentMethod;
		            }
		        }
		        return null;
		    }
		}
	
	@Transactional
	@Override
	public String cancelBooking(int bookingId) throws InvalidMovieException {
		String customerId = SecurityContextHolder.getContext().getAuthentication().getName();
		Shows show = bookingrepo.getShow(bookingId, customerId);
		log.error(show);
		if (show != null) {
			Date showDate = show.getShowDate();
			Time showTime = show.getShowTime();
			LocalDateTime showDateAndTime = showDate.toLocalDate().atTime(showTime.toLocalTime());
			LocalDateTime now = LocalDateTime.now();
			int availableSeats = show.getAvailableSeats();

			if (showDateAndTime.isAfter(now)) {

				bookingrepo.deleteByIdAndCustomerId(bookingId, customerId);
				show.setAvailableSeats(availableSeats + 1);
				showsrepo.save(show);
				return "Booking Cancelled (refund in 2 days)";

			} else {

				log.error("Show can't be cancelled, its Already Started");
				throw (new InvalidMovieException("You cannot cancel the Show, its Already Started"));

			}
		} else {

			log.error("Cannot find a show with the booking Id");
			throw (new InvalidMovieException("Cannot find a show with this booking Id"));

		}
	}




	@Override
	public List<Booking> getAllMyBookings() {
		String customerId = SecurityContextHolder.getContext().getAuthentication().getName();
		return bookingrepo.findByCustomerId(customerId);
	}

}
