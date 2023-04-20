package com.movieticket.service;

import java.util.List;

import com.movieticket.entity.Theatre;

public interface ITheatreService {
	
	public List<Theatre> getAllTheatres();
	
	public List<Theatre>searchTheatres(String keyword);

}
