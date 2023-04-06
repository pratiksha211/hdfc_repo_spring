package com.movieticket.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long payment_id;
	@ManyToOne
	private Booking booking;
	@Column(name="total_amount")
	private double total_amount;
	@Column(name="payment_date")
	private LocalDate paymentDate;
	

}
