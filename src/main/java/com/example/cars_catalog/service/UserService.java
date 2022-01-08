package com.example.cars_catalog.service;

import com.example.cars_catalog.controller.dto.user.get.response.GetUserResponseDto;
import com.example.cars_catalog.controller.dto.user.update.request.UpdateUserRequestDto;
import com.example.cars_catalog.controller.dto.user.update.response.UpdateUserResponseDto;
import com.example.cars_catalog.model.User;

import java.util.List;

public interface UserService {

    GetUserResponseDto read(String email);

    User getByEmail(String email);

    List<User> readAll();

    UpdateUserResponseDto update(UpdateUserRequestDto updateUserRequestDto, String email);

    boolean delete(String email);

    UpdateUserResponseDto updateById(UpdateUserRequestDto updateUserRequestDto, long id);

    boolean deleteById(long id);

}
