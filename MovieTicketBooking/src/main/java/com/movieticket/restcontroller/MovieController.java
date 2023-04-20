package com.movieticket.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieticket.entity.Movie;
import com.movieticket.service.IMovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	IMovieService movieservices;
	
	@GetMapping("/getallMovies")
	public List<Movie> getAllMovies(){
		return movieservices.getAllMovies();
	}
	
	
	
	@GetMapping("/searchmovies/{keyword}")
	public List<Movie> searchMovies(@PathVariable String keyword) {

		return movieservices.searchMovies(keyword);
	}
	

}
