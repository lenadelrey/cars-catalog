package com.example.cars_catalog.controller.dto.user.signup.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignUpResponseDto {

    private long id;

    private String name;

    private String email;

    private String password;

}
