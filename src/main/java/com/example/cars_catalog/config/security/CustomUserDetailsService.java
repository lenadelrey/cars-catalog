package com.example.cars_catalog.config.security;

import com.example.cars_catalog.model.UserModel;
import com.example.cars_catalog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel userModel = userRepository.getUserModelByEmail(email);
        if (userModel == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new CustomUserDetails(userModel);
    }
}
