package com.movieticket.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieticket.entity.Theatre;
import com.movieticket.service.ITheatreService;

@RestController
@RequestMapping("/movies")
public class TheatreController {
	
	@Autowired
	ITheatreService theatreservices;
	
	@GetMapping("/searchTheatres/{keyword}")
	public List<Theatre> searchTheatres(@PathVariable String keyword){
		return theatreservices.searchTheatres(keyword);
	}
	
	@GetMapping("/getall")
	public List<Theatre> getAllTheatres(){
		return theatreservices.getAllTheatres();
	}

}
