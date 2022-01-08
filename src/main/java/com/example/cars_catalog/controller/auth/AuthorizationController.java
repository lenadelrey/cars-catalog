package com.example.cars_catalog.controller.auth;


import com.example.cars_catalog.controller.dto.user.signin.request.SignInRequestDto;
import com.example.cars_catalog.controller.dto.user.signin.response.SignInResponseDto;
import com.example.cars_catalog.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/authorization")
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @PostMapping
    public SignInResponseDto authorize(@Valid @RequestBody SignInRequestDto signInRequestDto) {
        return authorizationService.authorization(signInRequestDto);
    }

}
