package com.movieticket.service;

import java.util.List;
import com.movieticket.entity.Movie;

public interface IMovieService {
	
	public List<Movie> getAllMovies();
	
	public List<Movie>searchMovies(String keyword);

}
