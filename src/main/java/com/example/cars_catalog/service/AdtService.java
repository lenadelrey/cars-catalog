package com.example.cars_catalog.service;

import com.example.cars_catalog.model.Adt;

import java.util.List;
import java.util.stream.Stream;

public interface AdtService {

    void create(Adt adt);

    Adt read(Long id);

    Stream<Adt> readAll(int limit, int offset);

    List<Adt> readAll();

    boolean update(Adt adt, Long id);

    boolean delete(Long id);

}
