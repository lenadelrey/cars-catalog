package com.example.cars_catalog.service;

import com.example.cars_catalog.model.User;

import java.util.List;

public interface UserService {

    User read(Long id);

    User getByEmail(String email);

    List<User> readAll();

    boolean update(User user, Long id);

    boolean delete(Long id);

}
