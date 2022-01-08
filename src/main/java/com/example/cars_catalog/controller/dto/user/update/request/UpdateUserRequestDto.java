package com.example.cars_catalog.controller.dto.user.update.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class UpdateUserRequestDto {

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    @Size(min = 4, max = 8)
    private String password;


}
