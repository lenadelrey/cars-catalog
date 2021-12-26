package com.example.cars_catalog.service;

import com.example.cars_catalog.model.AdtModel;

import java.util.List;

public interface AdtService {

    void create(AdtModel adtModel);

    AdtModel read(Long id);

    List<AdtModel> readAll();

    boolean update(AdtModel adtModel, Long id);

    boolean delete(Long id);

}
