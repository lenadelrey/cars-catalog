package com.example.cars_catalog.service;

import com.example.cars_catalog.controller.dto.user.signin.request.SignInRequestDto;
import com.example.cars_catalog.controller.dto.user.signin.response.SignInResponseDto;
import com.example.cars_catalog.exception.IsExistException;
import com.example.cars_catalog.mapper.UserMapper;
import com.example.cars_catalog.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignInResponseDto authorization(SignInRequestDto signInRequestDto) {
        User user = userService.getByEmail(signInRequestDto.getEmail());
        if (passwordEncoder.matches(signInRequestDto.getPassword(), user.getPassword())) {
            return UserMapper.mapUserToSignInResponseDto(user);
        } else
            throw new IsExistException("not exist with such password", "auth");
    }

}
