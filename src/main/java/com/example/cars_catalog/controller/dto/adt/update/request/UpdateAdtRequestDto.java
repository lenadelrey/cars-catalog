package com.example.cars_catalog.controller.dto.adt.update.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class UpdateAdtRequestDto {

    @Size(min = 3)
    private String model;

    @Size(min = 5)
    private String description;

    @NotNull
    private float price;

    @NotNull
    private int year;

}
