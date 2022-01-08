package com.example.cars_catalog.controller.dto.adt.create.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAdtResponseDto {

    private long carId;

    private String model;

    private String description;

    private float price;

    private int year;

}
