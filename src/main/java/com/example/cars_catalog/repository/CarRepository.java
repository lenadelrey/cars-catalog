package com.example.cars_catalog.repository;

import com.example.cars_catalog.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarModel, Long> {
}
