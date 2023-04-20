package com.movieticket.controller;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import com.movieticket.entity.Movie;

class MovieTest {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Test
	void testSearchMovies() {
		RestTemplateBuilder restTemplateBuilder=new RestTemplateBuilder();
	//	this.restTemplate = restTemplateBuilder.basicAuthentication("pratiksha", "pass").build();

		List<Movie> searchByTitle = restTemplate.getForObject("http://localhost:8787/movies/searchmovies/Fight Club", List.class);
		Assertions.assertNotEquals(0,searchByTitle.size());
		
	}


}
