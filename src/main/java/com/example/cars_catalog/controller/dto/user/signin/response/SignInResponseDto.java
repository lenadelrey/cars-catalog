package com.example.cars_catalog.controller.dto.user.signin.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInResponseDto {

    private String name;

    private String email;

    private String password;

    public SignInResponseDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
