package com.example.cars_catalog.controller.auth;

import com.example.cars_catalog.controller.dto.user.signup.request.SignUpRequestDto;
import com.example.cars_catalog.controller.dto.user.signup.response.SignUpResponseDto;
import com.example.cars_catalog.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public SignUpResponseDto register(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        return registrationService.create(signUpRequestDto);
    }

}
