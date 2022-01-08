package com.example.cars_catalog.controller.dto.adt.create.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
@Setter
public class CreateAdtRequestDto {

    @Size(min = 3)
    @NotBlank
    private String model;

    @Size(min = 5)
    private String description;

    @NotNull
    private float price;

    @NotNull
    private int year;

    @Email
    private String email;

}
