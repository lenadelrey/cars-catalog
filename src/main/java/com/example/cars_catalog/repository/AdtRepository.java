package com.example.cars_catalog.repository;

import com.example.cars_catalog.model.Adt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdtRepository extends JpaRepository<Adt, Long> {

    Optional<Adt> findAdtByCarId(Long carId);

    Page<Adt> findAllByModelAndYear(String model, int year, Pageable pageable);

    Page<Adt> findAllByPrice(float price, Pageable pageable);

    Page<Adt> findAllByDeletedIsFalse(Pageable pageable);

}
