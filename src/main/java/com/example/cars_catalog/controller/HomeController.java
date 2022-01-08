package com.example.cars_catalog.controller;

import com.example.cars_catalog.controller.dto.adt.get.response.GetAdtResponseDto;
import com.example.cars_catalog.model.Adt;
import com.example.cars_catalog.service.AdtService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
@Validated
public class HomeController {

    private final AdtService adtService;

    @GetMapping
    public Page<GetAdtResponseDto> readAll(@PageableDefault Pageable pageable) {
        return adtService.readAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public GetAdtResponseDto readAdt(@PathVariable long id) {
        return adtService.read(id);
    }

    @GetMapping("/byModelAndYear")
    public Page<GetAdtResponseDto> findAllByModelAndYear(
            @RequestParam(value = "model") @Min(3) String model,
            @RequestParam(value = "year") @Min(4) int year,
            @PageableDefault Pageable pageable) {
        return adtService.findAllByModelAndYear(model, year, pageable);
    }

    @GetMapping("/byPrice/{price}")
    public Page<GetAdtResponseDto> findAllByPrice(
            @PathVariable float price,
            @PageableDefault Pageable pageable) {
        return adtService.findAllByPrice(price, pageable);
    }

    @GetMapping("/sortByPrice")
    public List<GetAdtResponseDto> findAllWithSortByPrice() {
        return adtService.findAllWithSortByPrice();
    }

}
