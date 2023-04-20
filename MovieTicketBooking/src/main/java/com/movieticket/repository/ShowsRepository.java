package com.movieticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.movieticket.entity.Shows;

public interface ShowsRepository extends JpaRepository<Shows, Integer> {
	
	//To find show by movie title
	@Query("SELECT s FROM Shows s WHERE LOWER(s.movie.movieTitle) like %:movieTitle%")
	public List<Shows> searchShowsByTitle(@Param("movieTitle")String movieTitle);
	

}
