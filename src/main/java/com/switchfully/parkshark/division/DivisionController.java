package com.switchfully.parkshark.division;

import com.switchfully.parkshark.division.domain.dto.CreateDivisionDto;
import com.switchfully.parkshark.division.domain.dto.DivisionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/divisions")
public class DivisionController {
   
   private final DivisionService divisionService;
   
   public DivisionController(DivisionService divisionService) {
      this.divisionService = divisionService;
   }

   @ResponseStatus(HttpStatus.CREATED)
   @PostMapping(produces = "application/json", consumes = "application/json")
   public DivisionDto createDivision(@RequestBody CreateDivisionDto createDivisionDto) {
      return divisionService.saveDivision((createDivisionDto));
   }

   @GetMapping(path = "{id}", produces = "application/json")
   public DivisionDto getDivisionById(@PathVariable long id) {
      return divisionService.getDivisionById(id);
   }

   @GetMapping(produces = "application/json")
   public List<DivisionDto> getAllDivisions() {
      return divisionService.getAllDivisions();
   }
}
