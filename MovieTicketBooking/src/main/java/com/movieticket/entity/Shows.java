package com.movieticket.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Shows {
	
	@Id
	@Column(name = "show_id")
	private int showId;
	
	@ManyToOne
	@JoinColumn(name = "theatre_id")
	private Theatre theatre;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;

	@Column(name = "show_date")
	private Date showDate;

	@Column(name = "show_time")
	private Time showTime;

	@Column(name = "available_seats")
	private int availableSeats;

}
