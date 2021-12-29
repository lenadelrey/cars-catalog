package com.example.cars_catalog.service;

import com.example.cars_catalog.model.UserModel;

import java.util.List;

public interface UserService {

    void create(UserModel userModel);

    UserModel read(Long id);

    UserModel getByEmail(String email);

    List<UserModel> readAll();

    boolean update(UserModel userModel, Long id);

    boolean delete(Long id);

}
