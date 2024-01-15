package com.example.springbootmovie.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.springbootmovie.model.Actor;
import com.example.springbootmovie.model.Genres;
import com.example.springbootmovie.model.Language;
import com.example.springbootmovie.model.Movie;
import com.example.springbootmovie.service.ActorService;
import com.example.springbootmovie.service.GenresService;
import com.example.springbootmovie.service.LanguageService;
import com.example.springbootmovie.service.impl.MovieServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/movie")
public class MovieController {
	private final MovieServiceImpl movieService;
	private final ActorService actorService;
	@Autowired
	GenresService genresService;
	@Autowired
	LanguageService languageService;

	@Autowired
	public MovieController(MovieServiceImpl movieService, ActorService actorService) {
		this.movieService = movieService;
		this.actorService = actorService;
	}

	@GetMapping("/dashboard")
	public String showMovieList(HttpSession session, HttpServletRequest request, Model model, String keyword) throws UnsupportedEncodingException {
		List<Movie> movieList=new ArrayList<Movie>();
		if (keyword != null) {
			movieList= movieService.findByKeyword(keyword);
		} else {
			movieList=movieService.getAllMovies();
		}
		model.addAttribute("movies", movieList);
			movieList.forEach(m -> {
			if(m.getMovieImage()!=null){m.setMovieImageEncoded(Base64.getEncoder().encodeToString(m.getMovieImage()));}});
				    
			
			model.addAttribute("movies", movieList);
	
		if (request.isUserInRole("ROLE_ADMIN")) {
			System.out.println("ROLE_ADMIN.....in dashboard method..???...");
			return "/admin-page";
		} else if (request.isUserInRole("ROLE_USER")) {
			System.out.println("ROLE_USER....in dashboard method..???..");
			return "/user-page";
		}

		return "menu";
	}

	protected String showAllMovie(Model model, String keyword) {
		if (keyword != null) {
			model.addAttribute("movies", movieService.findByKeyword(keyword));
		} else {
			model.addAttribute("movies", movieService.getAllMovies());
			// model.addAttribute("actors",actorService.getActors());
		}
		return "menu";
	}

	@GetMapping("/addNewMovie")
	public String addNewMovie(Model model) {
		Movie movie = new Movie();
		List<Actor> actors = actorService.getActors();
		List<Genres> genresList = genresService.getAllGenres();
		List<Language> langList = languageService.getAllLanguage();

		model.addAttribute("movie", movie);
		model.addAttribute("actors", actors);
		model.addAttribute("genresList", genresList);
		model.addAttribute("langList", langList);
		System.out.println("..." + langList + ".......langList");
		return "new_movie";
	}

	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie movie, @RequestParam("image") MultipartFile multipartFile)
			throws IOException {
		byte[] byteObjects = convertToBytes(multipartFile); // we have to convert it to Byte[] array
		movie.setMovieImage(byteObjects);
       movieService.saveMovie(movie);
		
		
		return "redirect:/movie/dashboard";
	}

	private byte[] convertToBytes(MultipartFile file) throws IOException {
		byte[] byteObjects = new byte[file.getBytes().length];
		int i = 0;
		for (byte b : file.getBytes()) {
			byteObjects[i++] = b;
		}
		return byteObjects;
	}

	/*
	 * @GetMapping("/showFormForUpdate/{id}") public String
	 * showFormForUpdate(@PathVariable(value = "id") int id, Model model) { Movie
	 * movie = movieService.getMovieById(id); System.out.println("..inside fucn");
	 * model.addAttribute("movie", movie); return "update_movie"; }
	 */
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate1(@PathVariable("id") String id,Model model) {
		Movie movie = movieService.getMovieById(Integer.valueOf(id)); 
		List<Genres> genresList = genresService.getAllGenres();
		List<Language> langList = languageService.getAllLanguage();

		
		model.addAttribute("genresList", genresList);
		model.addAttribute("langList", langList);
		
		 model.addAttribute("movie", movie); 
		 return "update_movie"; 
	}
	@GetMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable(value = "id") int id) {
		movieService.deleteMovie(id);
		return "redirect:/";
	}
}
