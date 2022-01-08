package com.example.cars_catalog.controller.dto.user.signup.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
public class SignUpRequestDto {

    @Size(min = 2)
    private String name;

    @Email
    private String email;

    @Size(min = 4, max = 8)
    private String password;

    @Size(min = 4, max = 5)
    private String roleName;

}
