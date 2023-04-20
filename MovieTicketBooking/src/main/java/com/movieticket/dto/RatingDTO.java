package com.movieticket.dto;



import lombok.Data;

@Data
public class RatingDTO {
	
	private int movieId;
	private double rating;
	private String review;

}
