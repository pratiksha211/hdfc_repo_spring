package com.movieticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.movieticket.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
	//To search theatre by theatreName or location
	@Query("SELECT t FROM Theatre t  WHERE LOWER(t.theatreName) like %:key% OR LOWER(t.location) like %:key%")
	public List<Theatre> searchTheatres(@Param("key")String keyword);
	
	//To get seating capacity by theatreId
	@Query("SELECT t.seatingCapacity FROM Theatre t  WHERE t.theatreId = :theatreId")
	public Long getTotalCapacity(@Param("theatreId")int theatreId);

}
