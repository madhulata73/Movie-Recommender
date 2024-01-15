package com.example.springbootmovie.repository;

import com.example.springbootmovie.model.Actor;
import com.example.springbootmovie.model.Genres;
import com.example.springbootmovie.model.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Integer> {
	@Override
	List<Genres> findAll();

}
