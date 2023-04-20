package com.movieticket.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.movieticket.exception.InvalidMovieException;

@ControllerAdvice
public class MovieExceptionHandler {
	
	@ExceptionHandler(InvalidMovieException.class)
	public ResponseEntity<String> exceptionHandler(InvalidMovieException exp){
		return new ResponseEntity<String>(exp.getMessage().toString(),HttpStatus.EXPECTATION_FAILED);
	}

}
