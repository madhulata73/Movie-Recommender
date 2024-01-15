package com.example.springbootmovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmovie.model.Movie;
import com.example.springbootmovie.service.MovieService;

@RestController
@RequestMapping(value = "movies")
public class MovieRestController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping(value="gaurav_movies")
	public ResponseEntity<List<Movie>> getAllMovies(){
		List<Movie> movies = movieService.getAllMovies();
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

}
