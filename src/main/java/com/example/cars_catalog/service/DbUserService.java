package com.example.cars_catalog.service;

import com.example.cars_catalog.model.Role;
import com.example.cars_catalog.model.UserModel;
import com.example.cars_catalog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbUserService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void create(UserModel userModel) {
        userRepository.save(new UserModel(userModel.getName(), userModel.getEmail(),
                passwordEncoder.encode(userModel.getPassword()), new HashSet<Role>()));
    }

    @Override
    public UserModel read(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public UserModel getByEmail(String email) {
        return userRepository.getUserModelByEmail(email);
    }

    @Override
    public List<UserModel> readAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean update(UserModel userModel, Long id) {
        if (userRepository.existsById(id)) {
            userModel.setId(id);
            userRepository.save(new UserModel(userModel.getName(), userModel.getEmail(),
                    passwordEncoder.encode(userModel.getPassword()), new HashSet<Role>()));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
