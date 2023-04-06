package com.movieticket.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long booking_id;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Movie movie;
	@ManyToOne
	private Theatre theatre;
	@Column(name="booking_date")
	private LocalDate booking_date;
	

}
