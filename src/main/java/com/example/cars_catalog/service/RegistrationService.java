package com.example.cars_catalog.service;

import com.example.cars_catalog.controller.dto.user.signup.request.SignUpRequestDto;
import com.example.cars_catalog.controller.dto.user.signup.response.SignUpResponseDto;

public interface RegistrationService {

    SignUpResponseDto create(SignUpRequestDto signUpRequestDto);

}
