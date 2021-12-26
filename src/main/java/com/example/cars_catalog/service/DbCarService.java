package com.example.cars_catalog.service;

import com.example.cars_catalog.model.CarModel;
import com.example.cars_catalog.repository.CarRepository;

import java.util.List;

public class DbCarService implements CarService {

    private final CarRepository carRepository;

    public DbCarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void create(CarModel carModel) {
        carRepository.save(carModel);
    }

    @Override
    public CarModel read(Long id) {
        return carRepository.getById(id);
    }

    @Override
    public List<CarModel> readAll() {
        return carRepository.findAll();
    }

    @Override
    public boolean update(CarModel carModel, Long id) {
        if (carRepository.existsById(id)) {
            carModel.setCar_id(id);
            carRepository.save(carModel);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
