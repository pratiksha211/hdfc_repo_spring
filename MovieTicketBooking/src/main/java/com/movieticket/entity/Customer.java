package com.movieticket.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customer_id;
	@Column(name ="customer_name")
	private String customer_name;
	@Column(name ="customer_email")
	private String email;
	

}
