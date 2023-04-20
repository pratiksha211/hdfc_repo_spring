package com.movieticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.movieticket.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	// to find movie by genre or movieTitle
	
	@Query("SELECT m FROM Movie m WHERE LOWER(m.genre) like %:key% OR LOWER(m.movieTitle) like %:key%")
	public List<Movie> searchMovies(@Param("key") String keyword);


}
