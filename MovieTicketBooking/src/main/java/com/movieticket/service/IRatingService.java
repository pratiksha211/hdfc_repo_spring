package com.movieticket.service;

import java.util.List;

import com.movieticket.dto.RatingDTO;
import com.movieticket.entity.Rating;
import com.movieticket.exception.InvalidMovieException;

public interface IRatingService {
	
	public Rating addReview(RatingDTO ratingDTO)throws InvalidMovieException;
	public List<Rating> getRatingsBymovieName(String moviename);

}
