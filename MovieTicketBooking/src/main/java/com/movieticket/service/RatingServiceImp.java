package com.movieticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.movieticket.dto.RatingDTO;
import com.movieticket.entity.Movie;
import com.movieticket.entity.Rating;
import com.movieticket.exception.InvalidMovieException;
import com.movieticket.repository.MovieRepository;
import com.movieticket.repository.RatingRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class RatingServiceImp implements IRatingService {
	
	@Autowired
	RatingRepository ratingrepo;
	
	@Autowired
	MovieRepository movierepo;
	

	@Override
	public Rating addReview(RatingDTO ratingDTO) throws InvalidMovieException {
		Movie movie = movierepo.findById(ratingDTO.getMovieId()).orElse(null);
		Double userRating = ratingDTO.getRating();
		if (movie != null) {

			if (userRating >= 1 && userRating <= 10) {

				Rating ratings = new Rating();
				String customerId = SecurityContextHolder.getContext().getAuthentication().getName();
				ratings.setRating(userRating);
				ratings.setReview(ratingDTO.getReview());
				ratings.setMovie(movie);
				ratings.setCustomerId(customerId);
				ratings = ratingrepo.save(ratings);
				movierepo.save(movie);
				
				return ratings;
				
			}else {
				log.error("Rating should be between 1 and 10");
				throw (new InvalidMovieException("Rating should be between 1 and 10"));
				
			}
		} else {

			log.error("Cannot find the movie");
			throw (new InvalidMovieException("Cannot find the movie"));
			
		}
				
	}


	@Override
	public List<Rating> getRatingsBymovieName(String moviename) {
		return ratingrepo.findRatingsByMovieName(moviename.toLowerCase());
	}

}
