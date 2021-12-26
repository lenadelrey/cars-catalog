package com.example.cars_catalog.repository;

import com.example.cars_catalog.model.AdtModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdtRepository extends JpaRepository<AdtModel, Long> {
}
