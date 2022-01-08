package com.example.cars_catalog.controller.dto.adt.update.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateAdtResponseDto {

    private long carId;

    private String model;

    private String description;

    private float price;

    private int year;

}
