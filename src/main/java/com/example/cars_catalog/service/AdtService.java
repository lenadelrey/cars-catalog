package com.example.cars_catalog.service;

import com.example.cars_catalog.controller.dto.adt.create.request.CreateAdtRequestDto;
import com.example.cars_catalog.controller.dto.adt.create.response.CreateAdtResponseDto;
import com.example.cars_catalog.controller.dto.adt.get.response.GetAdtResponseDto;
import com.example.cars_catalog.controller.dto.adt.update.request.UpdateAdtRequestDto;
import com.example.cars_catalog.controller.dto.adt.update.response.UpdateAdtResponseDto;
import com.example.cars_catalog.model.Adt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdtService {

    CreateAdtResponseDto create(CreateAdtRequestDto createAdtRequestDto);

    GetAdtResponseDto read(long id);

    Page<GetAdtResponseDto> readAll(Pageable pageable);

    UpdateAdtResponseDto update(UpdateAdtRequestDto updateAdtRequestDto, long id);

    boolean delete(long id);

    Page<GetAdtResponseDto> findAllByModelAndYear(String model, int year, Pageable pageable);

    Page<GetAdtResponseDto> findAllByPrice(float price, Pageable pageable);

    List<GetAdtResponseDto> findAllWithSortByPrice();

}
