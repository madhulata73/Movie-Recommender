package com.example.springbootmovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootmovie.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}