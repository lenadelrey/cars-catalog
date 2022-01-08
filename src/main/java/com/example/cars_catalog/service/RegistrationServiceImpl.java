package com.example.cars_catalog.service;

import com.example.cars_catalog.controller.dto.user.signup.request.SignUpRequestDto;
import com.example.cars_catalog.controller.dto.user.signup.response.SignUpResponseDto;
import com.example.cars_catalog.exception.IsExistException;
import com.example.cars_catalog.mapper.UserMapper;
import com.example.cars_catalog.model.Role;
import com.example.cars_catalog.model.User;
import com.example.cars_catalog.repository.RoleRepository;
import com.example.cars_catalog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public SignUpResponseDto create(SignUpRequestDto signUpRequestDto) {
        validateUser(signUpRequestDto);

        User user = UserMapper.signUpRequestDtoToUser(signUpRequestDto);

        Optional<Role> role = roleRepository.findByName(signUpRequestDto.getRoleName());
        if (role.isEmpty())
            throw new IsExistException("no such role", "create");
        user.setRole(role.get());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);
        return UserMapper.mapUserToSignUpResponseDto(savedUser);
    }

    private void validateUser(SignUpRequestDto signUpRequestDto) {
        if (userRepository.existsByEmail(signUpRequestDto.getEmail())) {
            throw new IsExistException("User with email " + signUpRequestDto.getEmail() + " is exist!", "add");
        }
    }

}
