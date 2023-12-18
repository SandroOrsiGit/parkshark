package com.switchfully.parkshark.division;

import com.switchfully.parkshark.division.domain.dto.CreateDivisionDto;
import com.switchfully.parkshark.division.domain.dto.DivisionDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/divisions")
public class DivisionController {
   
   private final DivisionService divisionService;
   
   public DivisionController(DivisionService divisionService) {
      this.divisionService = divisionService;
   }
   
   @PostMapping(produces = "application/json", consumes = "application/json")
   public DivisionDto createDivision(@RequestBody CreateDivisionDto createDivisionDto) {
      return divisionService.saveDivision((createDivisionDto));
   }
}
