package com.example.springbootmovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.springbootmovie.model.Movie;
import com.example.springbootmovie.service.impl.MovieServiceImpl;

@Service
public class CommonService {

	@Autowired
	private MovieServiceImpl movieService;

	public Model showAllMovie(Model model) {

		model.addAttribute("movies", movieService.getAllMovies());
		// model.addAttribute("actors",actorService.getActors());

		return model;
	}

}
