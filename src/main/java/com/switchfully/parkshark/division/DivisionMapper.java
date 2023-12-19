package com.switchfully.parkshark.division;

import com.switchfully.parkshark.division.domain.Division;
import com.switchfully.parkshark.division.domain.dto.CreateDivisionDto;
import com.switchfully.parkshark.division.domain.dto.DivisionDto;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {
   public DivisionDto mapDivisionToDivisionDto(Division division) {
      if (division.getParentId() == null) {
         return new DivisionDto(division.getDivisionName(), division.getOriginalName(), division.getDirector());
      }
      return new DivisionDto(division.getDivisionName(), division.getOriginalName(), division.getDirector(), division.getParentId());
   }
   
   public Division mapCreateDivisionDToToDivision (CreateDivisionDto createDivisionDto) {
      return new Division(createDivisionDto.getDivisionName(), createDivisionDto.getOriginalName(), createDivisionDto.getDirector(), createDivisionDto.getParentId());
   }
}
