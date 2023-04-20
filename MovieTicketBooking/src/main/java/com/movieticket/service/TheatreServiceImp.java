package com.movieticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticket.entity.Theatre;
import com.movieticket.repository.TheatreRepository;

@Service
public class TheatreServiceImp implements ITheatreService {

	@Autowired
	TheatreRepository theatrerepo;

	@Override
	public List<Theatre> getAllTheatres() {
		return theatrerepo.findAll();
	}

	@Override
	public List<Theatre> searchTheatres(String keyword) {
		return theatrerepo.searchTheatres(keyword.toLowerCase());
	}

}
