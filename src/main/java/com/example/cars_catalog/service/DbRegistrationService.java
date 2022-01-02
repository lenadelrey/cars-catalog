package com.example.cars_catalog.service;

import com.example.cars_catalog.exception.IsExistException;
import com.example.cars_catalog.model.User;
import com.example.cars_catalog.repository.RoleRepository;
import com.example.cars_catalog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DbRegistrationService implements RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository repository;

    @Transactional
    @Override
    public User create(User user) {
        if (validateUser(user)) {
            if (user.getRole().getName().equals(repository.findByName("admin").getName())) {
                user.setRole(repository.findByName("admin"));
                return userRepository.save(user);
            } else if (user.getRole().getName().equals(repository.findByName("user").getName())) {
                user.setRole(repository.findByName("admin"));
                return userRepository.save(user);
            }
        }
        return null;
    }

    private boolean validateUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IsExistException("User with email " + user.getEmail() + " is exist!", "add");
        }

        return true;
    }

}
