package com.example.cars_catalog.service;

import com.example.cars_catalog.model.UserModel;
import com.example.cars_catalog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbUserService implements UserService {

    private final UserRepository userRepository;

    public DbUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserModel userModel) {
        userRepository.save(userModel);
    }

    @Override
    public UserModel read(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<UserModel> readAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean update(UserModel userModel, Long id) {
        if (userRepository.existsById(id)) {
            userModel.setId(id);
            userRepository.save(userModel);
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
