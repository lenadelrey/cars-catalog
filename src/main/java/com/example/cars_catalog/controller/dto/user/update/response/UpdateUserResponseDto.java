package com.example.cars_catalog.controller.dto.user.update.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateUserResponseDto {

    private long id;

    private String name;

    private String email;

    private String password;

}
