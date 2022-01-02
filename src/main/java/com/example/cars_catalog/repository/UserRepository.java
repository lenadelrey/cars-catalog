package com.example.cars_catalog.repository;

import com.example.cars_catalog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserModelByEmail(String email);

    boolean existsByEmail(String email);

}
