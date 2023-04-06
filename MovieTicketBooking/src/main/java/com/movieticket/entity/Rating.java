package com.movieticket.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rating_id;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Movie movie;
	@Column(name ="ratings")
	private double ratings;
	@Column(name= "review")
	private String review;
	

}
