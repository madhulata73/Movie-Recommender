package com.example.springbootmovie.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column
    private String name;
    
    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies = new ArrayList<>();
    
    @Column
    private Boolean is_director; 


    public Actor() {
    }

    public Actor(int id, String name, boolean is_director, List<Movie> movies) {
        this.id = id;
        this.name = name;
        this.is_director = is_director;
        this.movies = movies;
    }

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

    public Boolean getIsDirector() {
        return is_director;
    }

    public void setIsDirector(Boolean is_director) {
        this.is_director = is_director;
    }
}

