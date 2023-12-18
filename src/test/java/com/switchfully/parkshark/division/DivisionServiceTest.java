package com.switchfully.parkshark.division;

import com.switchfully.parkshark.division.domain.Division;
import com.switchfully.parkshark.division.domain.dto.CreateDivisionDto;
import com.switchfully.parkshark.division.domain.dto.DivisionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class DivisionServiceTest {

    @Autowired
    private DivisionService divisionService;
    @Autowired
    private DivisionMapper divisionMapper;

    @Test
    void whenCreateDivision_thenCheckIfDivisionHoldsTheSameFieldsAsGiven() {
        //WHEN
        Division division = new Division("Dall-E", "Dall-E by Microsoft", "boss");

        String expectedName = "Dall-E";
        String expectedOriginalName = "Dall-E by Microsoft";
        String expectedDirector = "boss";

        //THEN
        assertThat(division.getDivisionName()).isEqualTo(expectedName);
        assertThat(division.getOriginalName()).isEqualTo(expectedOriginalName);
        assertThat(division.getDirector()).isEqualTo(expectedDirector);
    }

    @Test
    void givenDivision_whenMappingToDivisionDto_thenReturnDivisionDtoWithSameFields() {
        //GIVEN
        Division division = new Division("Dall-B", "Dall-B by MicroBoft", "bossy");

        //WHEN
        DivisionDto divisionDto = divisionMapper.mapDivisionToDivisionDto(division);

        //THEN
        assertThat(division.getDivisionName()).isEqualTo(divisionDto.getDivisionName());
    }

    @Test
    void givenDivision_whenSaveDivision_thenDivisionIsInDatabase() {
        //GIVEN
        CreateDivisionDto createDivisionDto = new CreateDivisionDto("Dall-E", "Dall-E by Microsoft", "boss");

        //WHEN
        DivisionDto divisionDto = divisionService.saveDivision(createDivisionDto);

        //THEN
        assertThat(divisionDto.getDivisionName()).isEqualTo(createDivisionDto.getDivisionName());
        assertThat(divisionDto.getOriginalName()).isEqualTo(createDivisionDto.getOriginalName());
        assertThat(divisionDto.getDirector()).isEqualTo(createDivisionDto.getDirector());
    }

    @Test
    void whenCreateDivisionWithParentDivisionId_whenSaveDivision_thenDivisionIsInDatabase() {
        //WHEN
        CreateDivisionDto createDivisionDto = new CreateDivisionDto("Dall-E", "Dall-E by Microsoft", "boss", 1);

        //WHEN
        DivisionDto divisionDto = divisionService.saveDivision(createDivisionDto);

        //THEN
        assertThat(divisionDto.getDivisionName()).isEqualTo(createDivisionDto.getDivisionName());
        assertThat(divisionDto.getOriginalName()).isEqualTo(createDivisionDto.getOriginalName());
        assertThat(divisionDto.getDirector()).isEqualTo(createDivisionDto.getDirector());
    }

    @Test
    void whenCreateDivisionWithIncorrectParentDivisionId_whenSaveDivision_thenDivisionNotSavedInDatabase() {
        //WHEN
        CreateDivisionDto createDivisionDto = new CreateDivisionDto("Dall-E", "Dall-E by Microsoft", "boss", 999999999);

        //WHEN
        DivisionDto divisionDto = divisionService.saveDivision(createDivisionDto);

        //THEN
        System.out.println(divisionDto);
        assertThat(divisionDto).isNull();

    }
}
