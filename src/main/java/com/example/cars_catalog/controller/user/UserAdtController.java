package com.example.cars_catalog.controller.user;

import com.example.cars_catalog.controller.dto.adt.create.request.CreateAdtRequestDto;
import com.example.cars_catalog.controller.dto.adt.create.response.CreateAdtResponseDto;
import com.example.cars_catalog.controller.dto.adt.get.response.GetAdtResponseDto;
import com.example.cars_catalog.controller.dto.adt.update.request.UpdateAdtRequestDto;
import com.example.cars_catalog.controller.dto.adt.update.response.UpdateAdtResponseDto;
import com.example.cars_catalog.service.AdtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user/adt")
@RequiredArgsConstructor
public class UserAdtController {

    private final AdtService adtService;

    @PostMapping
    public CreateAdtResponseDto create(@Valid @RequestBody CreateAdtRequestDto createAdtRequestDto) {
        return adtService.create(createAdtRequestDto);
    }

    @GetMapping(value = "/{id}")
    public GetAdtResponseDto read(@PathVariable long id) {
        return adtService.read(id);
    }

    @PutMapping(value = "/{id}")
    public UpdateAdtResponseDto update(@RequestBody @Valid UpdateAdtRequestDto updateAdtRequestDto, @PathVariable long id) {
        return adtService.update(updateAdtRequestDto, id);
    }

    @DeleteMapping(value = "/{id}")
    public boolean delete(@PathVariable long id) {
        return adtService.delete(id);
    }

}
