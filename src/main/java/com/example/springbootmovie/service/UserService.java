package com.example.springbootmovie.service;

import java.util.List;

import com.example.springbootmovie.model.User;
import com.example.springbootmovie.model.UserDto;

public interface UserService {
	void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}