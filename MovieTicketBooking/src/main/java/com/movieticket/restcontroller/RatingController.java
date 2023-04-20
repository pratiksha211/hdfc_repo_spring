package com.movieticket.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieticket.dto.RatingDTO;
import com.movieticket.entity.Rating;
import com.movieticket.exception.InvalidMovieException;
import com.movieticket.service.IRatingService;

@RestController
@RequestMapping("/movies")
public class RatingController {
	
	@Autowired
	IRatingService ratingservices;
	
	@PostMapping("/ratemovie")
	public Rating addrating(@RequestBody RatingDTO ratings) throws InvalidMovieException {
		return ratingservices.addReview(ratings);
	}
	
	@GetMapping("/getratingsbymovie/{movieName}")
	public List<Rating> getRatingByMovie(@PathVariable String movieName){
		return ratingservices.getRatingsBymovieName(movieName);
	}

}
