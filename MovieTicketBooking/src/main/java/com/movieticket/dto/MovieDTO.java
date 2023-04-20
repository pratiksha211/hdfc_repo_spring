package com.movieticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class MovieDTO {
	
	private int movieId;
	private String movieTitle;
	private String genre;
	private String director;
	private int duration;
	private double rating;

}
