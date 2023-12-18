package com.switchfully.parkshark.division;

import com.switchfully.parkshark.division.domain.dto.CreateDivisionDto;
import com.switchfully.parkshark.division.domain.dto.DivisionDto;
import org.springframework.stereotype.Service;

@Service
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

   
}
