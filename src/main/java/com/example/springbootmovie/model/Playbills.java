package com.example.springbootmovie.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Playbills")
public class Playbills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne(mappedBy = "playbills")
	private Movie movies ;

	public Playbills() {
	}

	public Playbills(int id, Movie movies) {
		this.id = id;
		this.movies = movies;
	}

	
	public Movie getMovies() {
		return movies;
	}

	public void setMovies(Movie movies) {
		this.movies = movies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
