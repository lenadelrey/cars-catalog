package com.example.cars_catalog.service;

import com.example.cars_catalog.model.AdtModel;

import java.util.stream.Stream;

public interface AdtService {

    void create(AdtModel adtModel);

    AdtModel read(Long id);

    Stream<AdtModel> readAll(int limit, int offset);

    boolean update(AdtModel adtModel, Long id);

    boolean delete(Long id);

}
