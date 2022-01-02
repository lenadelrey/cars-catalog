package com.example.cars_catalog.service;

import com.example.cars_catalog.model.Adt;
import com.example.cars_catalog.repository.AdtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DbAdtService implements AdtService {

    private final AdtRepository adtRepository;

    @Override
    public void create(Adt adt) {
        adtRepository.save(new Adt(adt.getModel(), adt.getDescription(),
                adt.getPrice(), adt.getYear(), adt.getUser()));
    }

    @Override
    public Adt read(Long id) {
        return adtRepository.getById(id);
    }

    @Override
    public Stream<Adt> readAll(int limit, int offset) {
        return adtRepository.findAll().stream().limit(limit).skip(offset);
    }

    @Override
    public List<Adt> readAll() {
        return adtRepository.findAll();
    }

    @Override
    public boolean update(Adt adt, Long id) {
        if (adtRepository.existsById(id)) {
            adt.setCar_id(id);
            adtRepository.save(adt);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (adtRepository.existsById(id)) {
            adtRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
