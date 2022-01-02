package com.example.cars_catalog.repository;

import com.example.cars_catalog.model.Adt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdtRepository extends JpaRepository<Adt, Long> {
}
