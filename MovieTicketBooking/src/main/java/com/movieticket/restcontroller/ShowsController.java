package com.movieticket.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieticket.entity.Shows;
import com.movieticket.service.IShowsService;

@RestController
@RequestMapping("/movies")
public class ShowsController {
	
	@Autowired
	IShowsService showservices;
	
	@GetMapping("/getshows/{keyword}")
	public List<Shows> getShowsByMovies(@PathVariable String keyword){
		return showservices.searchShowsByTitle(keyword);
	}

}
