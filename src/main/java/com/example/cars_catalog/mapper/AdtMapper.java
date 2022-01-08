package com.example.cars_catalog.mapper;

import com.example.cars_catalog.controller.dto.adt.create.request.CreateAdtRequestDto;
import com.example.cars_catalog.controller.dto.adt.create.response.CreateAdtResponseDto;
import com.example.cars_catalog.controller.dto.adt.get.response.GetAdtResponseDto;
import com.example.cars_catalog.controller.dto.adt.update.response.UpdateAdtResponseDto;
import com.example.cars_catalog.model.Adt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class AdtMapper {

    public static CreateAdtResponseDto mapAdtToCreateAdtResponseDto(Adt adt) {
        return CreateAdtResponseDto.builder()
                .carId(adt.getCarId())
                .description(adt.getDescription())
                .model(adt.getModel())
                .price(adt.getPrice())
                .year(adt.getYear())
                .build();
    }

    public static UpdateAdtResponseDto mapAdtToUpdateAdtResponseDto(Adt adt) {
        return UpdateAdtResponseDto.builder()
                .carId(adt.getCarId())
                .description(adt.getDescription())
                .model(adt.getModel())
                .price(adt.getPrice())
                .year(adt.getYear())
                .build();
    }

    public static GetAdtResponseDto mapAdtToGetAdtResponseDto(Adt adt) {
        return GetAdtResponseDto.builder()
                .carId(adt.getCarId())
                .description(adt.getDescription())
                .model(adt.getModel())
                .price(adt.getPrice())
                .year(adt.getYear())
                .build();
    }

    public static List<GetAdtResponseDto> mapListAdtsToListGetAdtResponseDtos(List<Adt> adts) {
        return adts.stream().map(AdtMapper::mapAdtToGetAdtResponseDto).collect(Collectors.toList());
    }

    public static Page<GetAdtResponseDto> mapPageAdtsToPageGetAdtResponseDtos(Page<Adt> adts) {
        return new PageImpl<>(mapListAdtsToListGetAdtResponseDtos(adts.getContent()));
    }

    public static Adt mapCreateAdtResponseDtoToAdt(CreateAdtRequestDto createAdtRequestDto) {
        Adt adt = new Adt();
        adt.setModel(createAdtRequestDto.getModel());
        adt.setDescription(createAdtRequestDto.getDescription());
        adt.setPrice(createAdtRequestDto.getPrice());
        adt.setYear(createAdtRequestDto.getYear());
        return adt;
    }
}
