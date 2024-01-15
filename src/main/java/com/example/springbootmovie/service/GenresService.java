package com.example.springbootmovie.service;

import com.example.springbootmovie.model.Actor;
import com.example.springbootmovie.model.Genres;
import com.example.springbootmovie.model.Movie;
import com.example.springbootmovie.repository.ActorRepository;
import com.example.springbootmovie.repository.GenresRepository;
import com.example.springbootmovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenresService {
   
  
    @Autowired
    private GenresRepository genresRepository;

    public List<Genres> getAllGenres(){
        return genresRepository.findAll();
    }

  
}
