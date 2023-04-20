package com.movieticket.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data

@Entity
@Table(name= "Bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	private int bookingId;
	
	@Column(name="customer_id")
	private String customerId;
	
	@ManyToOne
	@JoinColumn(name = "show_id")
	private Shows show;
	
	@Column(name="seat_no")
	private int seatNo;
	
	@Column(name="booking_date")
	private Date bookingDate;
	
	@Column(name="total_amount")
	private double totalAmount;
	
	@Column(name="payment_method")
	private String paymentMethod;

}
