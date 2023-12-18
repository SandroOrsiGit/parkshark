package com.switchfully.parkshark.division;


import com.switchfully.parkshark.division.domain.dto.CreateDivisionDto;
import com.switchfully.parkshark.division.domain.dto.DivisionDto;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DivisionService {

    private final DivisionRepository divisionRepository;

    private final DivisionMapper divisionMapper;

    public DivisionService(DivisionRepository divisionRepository, DivisionMapper divisionMapper) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
    }

    public DivisionDto saveDivision(CreateDivisionDto createDivisionDto) {
        return divisionMapper.mapDivisionToDivisionDto(divisionRepository.save(divisionMapper.mapCreateDivisionDToToDivision(createDivisionDto)));
    }


    //TODO add custom exception
    public DivisionDto getDivisionById(long id) {
        return divisionMapper.mapDivisionToDivisionDto(divisionRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    public List<DivisionDto> getAllDivisions() {
        return divisionRepository.findAll().stream().map(divisionMapper::mapDivisionToDivisionDto).collect(Collectors.toList());
    }
}
