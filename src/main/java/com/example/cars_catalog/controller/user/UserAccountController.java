package com.example.cars_catalog.controller.user;

import com.example.cars_catalog.controller.dto.user.get.response.GetUserResponseDto;
import com.example.cars_catalog.controller.dto.user.update.request.UpdateUserRequestDto;
import com.example.cars_catalog.controller.dto.user.update.response.UpdateUserResponseDto;
import com.example.cars_catalog.model.User;
import com.example.cars_catalog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAccountController {

    private final UserService userService;

    @GetMapping
    public GetUserResponseDto read(Authentication authentication) {
        String email = (String) authentication.getCredentials();
        return userService.read(email);
    }

    @PutMapping
    public UpdateUserResponseDto update(@Valid @RequestBody UpdateUserRequestDto updateUserRequestDto, Authentication authentication) {
        String email = (String) authentication.getCredentials();
        return userService.update(updateUserRequestDto, email);
    }

    @DeleteMapping
    public boolean delete(Authentication authentication) {
        String email = (String) authentication.getCredentials();
        return userService.delete(email);
    }

}
