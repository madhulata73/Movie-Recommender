package com.example.springbootmovie.repository;

import com.example.springbootmovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query(value="SELECT * FROM movie.movies WHERE title like %:keyword%  or description like %:keyword%",nativeQuery = true)
    List<Movie> findByKeyword(@Param("keyword") String keyword);
}
