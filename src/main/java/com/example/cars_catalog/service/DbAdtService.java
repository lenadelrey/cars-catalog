package com.example.cars_catalog.service;

import com.example.cars_catalog.model.AdtModel;
import com.example.cars_catalog.repository.AdtRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbAdtService implements AdtService {

    private final AdtRepository adtRepository;

    public DbAdtService(AdtRepository adtRepository) {
        this.adtRepository = adtRepository;
    }

    @Override
    public void create(AdtModel adtModel) {
        adtRepository.save(adtModel);
    }

    @Override
    public AdtModel read(Long id) {
        return adtRepository.getById(id);
    }

    @Override
    public List<AdtModel> readAll() {
        return adtRepository.findAll();
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
