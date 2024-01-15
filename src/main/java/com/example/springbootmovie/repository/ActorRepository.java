package com.example.springbootmovie.repository;

import com.example.springbootmovie.model.Actor;
import com.example.springbootmovie.model.Movie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
	 @Override
	    @Query(value = "SELECT * FROM movie.actors",nativeQuery = true)
	    List<Actor> findAll();

}
