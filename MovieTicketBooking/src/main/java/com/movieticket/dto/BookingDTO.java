package com.movieticket.dto;

import lombok.Data;

@Data
public class BookingDTO {
	
	private int seatNo;
	private int showId;
	private String paymentMethod;

}
