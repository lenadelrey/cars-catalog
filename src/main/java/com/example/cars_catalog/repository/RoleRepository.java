package com.example.cars_catalog.repository;

import com.example.cars_catalog.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

    Role findById(long id);
}
