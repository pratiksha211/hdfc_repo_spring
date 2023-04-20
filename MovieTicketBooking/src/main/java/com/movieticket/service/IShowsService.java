package com.movieticket.service;

import java.util.List;

import com.movieticket.entity.Shows;

public interface IShowsService {
	
	public List<Shows> getallShows();
	public List<Shows> searchShowsByTitle(String movieTitle);

}
