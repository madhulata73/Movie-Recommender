package com.example.springbootmovie.model;

import java.util.List;

import lombok.Data;

@Data
public class MovieDto {
	
	private Integer id;

	private String title;

	private String description;

	private Long noOfLikes;

	private Byte[] movieImage;

	private Float averageRating;

	private List<Genres> genres ;

	private List<Language> languages;

	private Playbills playbills;

	private List<Actor> actors;

}
