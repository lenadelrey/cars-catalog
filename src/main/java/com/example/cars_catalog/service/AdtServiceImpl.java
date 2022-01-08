package com.example.cars_catalog.service;

import com.example.cars_catalog.controller.dto.adt.create.request.CreateAdtRequestDto;
import com.example.cars_catalog.controller.dto.adt.create.response.CreateAdtResponseDto;
import com.example.cars_catalog.controller.dto.adt.get.response.GetAdtResponseDto;
import com.example.cars_catalog.controller.dto.adt.update.request.UpdateAdtRequestDto;
import com.example.cars_catalog.controller.dto.adt.update.response.UpdateAdtResponseDto;
import com.example.cars_catalog.exception.IsExistException;
import com.example.cars_catalog.mapper.AdtMapper;
import com.example.cars_catalog.model.Adt;
import com.example.cars_catalog.model.User;
import com.example.cars_catalog.repository.AdtRepository;
import com.example.cars_catalog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdtServiceImpl implements AdtService {

    private final AdtRepository adtRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public CreateAdtResponseDto create(CreateAdtRequestDto createAdtRequestDto) {
        Adt adt = AdtMapper.mapCreateAdtResponseDtoToAdt(createAdtRequestDto);

        User user = userRepository.findUserByEmail(createAdtRequestDto.getEmail());
        adt.setUser(user);

        Adt savedAdt = adtRepository.save(adt);
        return AdtMapper.mapAdtToCreateAdtResponseDto(savedAdt);
    }

    @Override
    @Transactional(readOnly = true)
    public GetAdtResponseDto read(long id) {
        return AdtMapper.mapAdtToGetAdtResponseDto(adtRepository.getById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GetAdtResponseDto> readAll(Pageable pageable) {
        Page<Adt> adts = adtRepository.findAllByDeletedIsFalse(pageable);
        return AdtMapper.mapPageAdtsToPageGetAdtResponseDtos(adts);
    }

    @Override
    @Transactional
    public UpdateAdtResponseDto update(UpdateAdtRequestDto updateAdtRequestDto, long id) {
        Optional<Adt> optionalAdt = adtRepository.findAdtByCarId(id);
        if (optionalAdt.isEmpty())
            throw new IsExistException("no such adt", "update");

        Adt adt = optionalAdt.get();

        adt.setModel(updateAdtRequestDto.getModel());
        adt.setDescription(updateAdtRequestDto.getDescription());
        adt.setPrice(updateAdtRequestDto.getPrice());
        adt.setYear(updateAdtRequestDto.getYear());

        adt = adtRepository.save(adt);
        return AdtMapper.mapAdtToUpdateAdtResponseDto(adt);
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        Optional<Adt> adt = adtRepository.findById(id);
        if (adt.isPresent()) {
            Adt adtForSoftDelete = adt.get();
            adtForSoftDelete.setDeleted(true);
            adtRepository.save(adtForSoftDelete);
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GetAdtResponseDto> findAllByModelAndYear(String model, int year, Pageable pageable) {
        Page<Adt> adts = adtRepository.findAllByModelAndYear(model, year, pageable);
        return AdtMapper.mapPageAdtsToPageGetAdtResponseDtos(adts);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GetAdtResponseDto> findAllByPrice(float price, Pageable pageable) {
        Page<Adt> adts = adtRepository.findAllByPrice(price, pageable);
        return AdtMapper.mapPageAdtsToPageGetAdtResponseDtos(adts);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GetAdtResponseDto> findAllWithSortByPrice() {
        List<Adt> adts = adtRepository.findAll(Sort.by("price"));
        return AdtMapper.mapListAdtsToListGetAdtResponseDtos(adts);
    }
}
