package com.example.cars_catalog.repository;

import com.example.cars_catalog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    boolean existsByEmail(String email);

}
