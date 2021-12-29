package com.example.cars_catalog.service;

import com.example.cars_catalog.model.AdtModel;
import com.example.cars_catalog.repository.AdtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DbAdtService implements AdtService {

    private final AdtRepository adtRepository;

    @Override
    public void create(AdtModel adtModel) {
        adtRepository.save(new AdtModel(adtModel.getModel(), adtModel.getDescription(),
                adtModel.getPrice(), adtModel.getYear(), adtModel.getUserModel()));
    }

    @Override
    public AdtModel read(Long id) {
        return adtRepository.getById(id);
    }

    @Override
    public Stream<AdtModel> readAll(int limit, int offset) {
        return adtRepository.findAll().stream().limit(limit).skip(offset);
    }

    @Override
    public boolean update(AdtModel adtModel, Long id) {
        if (adtRepository.existsById(id)) {
            adtModel.setCar_id(id);
            adtRepository.save(adtModel);
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
