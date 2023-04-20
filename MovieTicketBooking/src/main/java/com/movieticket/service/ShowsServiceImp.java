package com.movieticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticket.entity.Shows;
import com.movieticket.repository.ShowsRepository;

@Service
public class ShowsServiceImp implements IShowsService {
	
	@Autowired
	ShowsRepository repo;

	@Override
	public List<Shows> getallShows() {
		return repo.findAll();
	}

	@Override
	public List<Shows> searchShowsByTitle(String movieTitle) {
		return repo.searchShowsByTitle(movieTitle.toLowerCase());
	}

}
