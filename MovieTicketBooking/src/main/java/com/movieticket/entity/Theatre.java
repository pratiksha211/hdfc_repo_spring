package com.movieticket.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Theatre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long theatre_id;
	@Column(name ="theatre_name")
	private String theatre_name;
	@Column(name ="location")
	private String location;
	@Column(name ="amenities")
	private String amenitites;
	

}
