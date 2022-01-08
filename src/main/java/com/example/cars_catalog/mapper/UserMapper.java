package com.example.cars_catalog.mapper;

import com.example.cars_catalog.controller.dto.user.get.response.GetUserResponseDto;
import com.example.cars_catalog.controller.dto.user.signin.response.SignInResponseDto;
import com.example.cars_catalog.controller.dto.user.signup.request.SignUpRequestDto;
import com.example.cars_catalog.controller.dto.user.signup.response.SignUpResponseDto;
import com.example.cars_catalog.controller.dto.user.update.request.UpdateUserRequestDto;
import com.example.cars_catalog.controller.dto.user.update.response.UpdateUserResponseDto;
import com.example.cars_catalog.model.User;

public class UserMapper {

    public static User signUpRequestDtoToUser(SignUpRequestDto signUpRequestDto) {
        User user = new User();
        user.setEmail(signUpRequestDto.getEmail());
        user.setName(signUpRequestDto.getName());
        user.setPassword(signUpRequestDto.getPassword());
        return user;
    }

    public static SignUpResponseDto mapUserToSignUpResponseDto(User user) {
        return SignUpResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .build();
    }

    public static UpdateUserResponseDto mapUserToUpdateUserResponseDto(User user) {
        return UpdateUserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static SignInResponseDto mapUserToSignInResponseDto(User user) {
        return SignInResponseDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .build();
    }


    public static User mapUpdateUserRequestDtoToUser(UpdateUserRequestDto updateUserRequestDto) {
        User user = new User();
        user.setEmail(updateUserRequestDto.getEmail());
        user.setName(updateUserRequestDto.getName());
        return user;
    }

    public static GetUserResponseDto mapUserToGetUserResponseDto(User user) {
        return GetUserResponseDto.builder()
                .email(user.getEmail())
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
