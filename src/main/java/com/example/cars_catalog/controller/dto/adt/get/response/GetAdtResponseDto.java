package com.example.cars_catalog.controller.dto.adt.get.response;

import com.example.cars_catalog.model.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetAdtResponseDto {

    private Long carId;

    private String model;

    private String description;

    private float price;

    private int year;

}
