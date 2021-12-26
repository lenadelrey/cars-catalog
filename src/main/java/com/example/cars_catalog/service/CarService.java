package com.example.cars_catalog.service;

import com.example.cars_catalog.model.CarModel;

import java.util.List;

public interface CarService {

    void create(CarModel carModel);

    CarModel read(Long id);

    List<CarModel> readAll();

    boolean update(CarModel carModel, Long id);

    boolean delete(Long id);

}
