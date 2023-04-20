package com.movieticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.movieticket.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
	
	// find ratings by moviTitle
	@Query("SELECT r FROM Rating r WHERE LOWER(r.movie.movieTitle) like %:title%")
	public List<Rating> findRatingsByMovieName(@Param("title") String movieName);
	
	@Query("SELECT AVG(r.rating) FROM Rating r WHERE r.movie.movieTitle like %:title%")
	public Double getTotalRatingByMovie(@Param("title") String movieName);

}
