package com.example.cars_catalog.repository;

import com.example.cars_catalog.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
