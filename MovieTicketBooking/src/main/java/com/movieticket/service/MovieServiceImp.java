package com.movieticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticket.entity.Movie;
import com.movieticket.repository.MovieRepository;

@Service
public class MovieServiceImp implements IMovieService {
	
	@Autowired
	MovieRepository repo;
	

	@Override
	public List<Movie> getAllMovies() {
		return repo.findAll();
	}

	@Override
	public List<Movie> searchMovies(String keyword) {
		return repo.searchMovies(keyword.toLowerCase());
	}

}
