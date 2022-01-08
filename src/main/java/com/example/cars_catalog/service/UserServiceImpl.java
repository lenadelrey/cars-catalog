package com.example.cars_catalog.service;

import com.example.cars_catalog.controller.dto.user.get.response.GetUserResponseDto;
import com.example.cars_catalog.controller.dto.user.update.request.UpdateUserRequestDto;
import com.example.cars_catalog.controller.dto.user.update.response.UpdateUserResponseDto;
import com.example.cars_catalog.exception.IsExistException;
import com.example.cars_catalog.mapper.UserMapper;
import com.example.cars_catalog.model.User;
import com.example.cars_catalog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public GetUserResponseDto read(String email) {
        User user = userRepository.findUserByEmail(email);
        return UserMapper.mapUserToGetUserResponseDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public UpdateUserResponseDto update(UpdateUserRequestDto updateUserRequestDto, String email) {
        User userByEmail = userRepository.findUserByEmail(email);
        if (userByEmail == null)
            throw new IsExistException("no such user", "update");

        User user = UserMapper.mapUpdateUserRequestDtoToUser(updateUserRequestDto);
        user.setPassword(passwordEncoder.encode(updateUserRequestDto.getPassword()));
        user.setRole(userByEmail.getRole());
        user.setId(userByEmail.getId());

        User savedUser = userRepository.save(user);
        return UserMapper.mapUserToUpdateUserResponseDto(savedUser);
    }

    @Override
    @Transactional
    public boolean delete(String email) {
        User userByEmail = userRepository.findUserByEmail(email);

        if (userByEmail != null) {
            userRepository.deleteById(userByEmail.getId());
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public UpdateUserResponseDto updateById(UpdateUserRequestDto updateUserRequestDto, long id) {
        if (!userRepository.existsById(id))
            throw new IsExistException("no such user", "update");

        User user = UserMapper.mapUpdateUserRequestDtoToUser(updateUserRequestDto);
        user.setPassword(passwordEncoder.encode(updateUserRequestDto.getPassword()));
        user.setRole(userRepository.getById(id).getRole());
        user.setId(id);

        User savedUser = userRepository.save(user);
        return UserMapper.mapUserToUpdateUserResponseDto(savedUser);
    }

    @Override
    @Transactional
    public boolean deleteById(long id) {
        boolean isUserExists = userRepository.existsById(id);

        if (isUserExists) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
