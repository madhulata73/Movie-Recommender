package com.example.springbootmovie.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column
	private Integer id;

	@Column
	private String title;

	@Column(name = "description")
	private String description;

	@Column
	private Long noOfLikes;

	@Lob
	@Column(name = "movieImage", columnDefinition="LONGBLOB")
	private byte[] movieImage;

	@Column
	private Float averageRating;

	@ManyToMany
	@JoinTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genres_id"))
	private List<Genres> genres = new ArrayList<>();;

	@ManyToMany
	@JoinTable(name = "movie_language", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
	private List<Language> languages;

	@OneToOne
	private Playbills playbills;

	/*
	 * @JoinTable(name = "movies_actors", joinColumns = @JoinColumn(name =
	 * "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id") )
	 */
	@ManyToMany
	private List<Actor> actors = new ArrayList<>();

	private String movieImageEncoded;
	
 
	@Transient
	public String getPhotosImagePath() {
		if (movieImage == null || id == null)
			return null;

		return "/movie-images/" + id + "/" + movieImage;
	}

}
