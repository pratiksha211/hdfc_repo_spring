package com.movieticket.dto;

import lombok.Data;
@Data
public class TheatreDTO {
	
	private int theatre_id;
	private String theatre_name;
	private String location;
	private int seatingCapacity;

}
