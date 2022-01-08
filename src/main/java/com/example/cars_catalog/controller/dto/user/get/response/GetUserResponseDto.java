package com.example.cars_catalog.controller.dto.user.get.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetUserResponseDto {

    private long id;

    private String name;

    private String email;

}
