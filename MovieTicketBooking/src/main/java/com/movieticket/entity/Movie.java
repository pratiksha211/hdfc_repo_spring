package com.movieticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data

@Entity
@Table(name="Movies")
public class Movie {
	
	@Id
	@Column(name="movie_id")
	private int movieId;
	
	@Column(name="movie_title")
	private String movieTitle;
	
	private String genre;
	private String director;
	private int duration;
	private double rating;
	

}
