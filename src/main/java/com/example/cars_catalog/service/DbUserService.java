package com.example.cars_catalog.service;

import com.example.cars_catalog.model.User;
import com.example.cars_catalog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbUserService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User read(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getUserModelByEmail(email);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean update(User user, Long id) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(new User(user.getName(), user.getEmail(),
                    passwordEncoder.encode(user.getPassword()), user.getRole()));
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
