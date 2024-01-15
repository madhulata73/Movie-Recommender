package com.example.springbootmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootmovie.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
    User findByEmail(String email);
}