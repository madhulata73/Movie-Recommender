package com.example.springbootmovie.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo
;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column
    private String name;
  
    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies = new ArrayList<>();


    public Genres() {
    }

    public Genres(int id, String name,List<Movie> movies) {
        this.id = id;
        this.name = name;
        this.movies = movies;
    }

    @ManyToMany
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

