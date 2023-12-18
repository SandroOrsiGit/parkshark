package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.address.domain.Address;
import com.switchfully.parkshark.parking_lot.domain.Category;
import com.switchfully.parkshark.parking_lot.domain.ContactPerson;
import com.switchfully.parkshark.parking_lot.domain.ParkingLot;
import com.switchfully.parkshark.parking_lot.domain.PostalCode;
import com.switchfully.parkshark.parking_lot.dto.CreateParkingLotDto;
import com.switchfully.parkshark.parking_lot.dto.ParkingLotDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ParkingLotServiceTest {
    @Autowired
    private ParkingLotService parkingLotService;

    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private ParkingLotMapper parkingLotMapper;

//    @BeforeEach
//    void clearDataBase(@Autowired Flyway flyway)

    @Test
    void givenParkingLot_whenMappingParkingLotToParkingLotDto_thenResultIsOfTypeParkingLotDtoWithSameFields() {
        ParkingLot parkingLot =
                new ParkingLot("mark of parkshark",
                        Category.ABOVE_GROUND_BUILDING,
                        2000,
                        4.5,
                        new Address("StreetOfMark",
                                "NumberOfMark",
                                new PostalCode("12345",
                                        "MarkVille")),
                        List.of(
                                new ContactPerson("Mark",
                                        "MarksMobile",
                                        null,
                                        "mark@parkshark.com",
                                        new Address("StreetName",
                                                "StreetNumber",
                                                new PostalCode("12345",
                                                        "MarkVille")))));

        //WHEN
        ParkingLotDto parkingLotDto = parkingLotMapper.mapParkingLotToParkingLotDto(parkingLot);

        //THEN
        assertThat(parkingLotDto).isInstanceOf(ParkingLotDto.class);
        assertThat(parkingLotDto.getName()).isEqualTo(parkingLot.getName());
    }

    @Test
    void givenCreateParkingLotDto_whenMapToParkingLot_thenResultIsOfTypeParkingLotWithSameFields() {
        CreateParkingLotDto createParkingLotDto =
                new CreateParkingLotDto("bork of porkshork",
                        Category.ABOVE_GROUND_BUILDING,
                        2000,
                        4.5,
                        new Address("StreetOfPork",
                                "NumberOfPork",
                                new PostalCode("12345",
                                        "PorkVille")),
                        List.of(
                                new ContactPerson("Pork",
                                        "PorksMobile",
                                        null,
                                        "mork@porkshork.com",
                                        new Address("StreetName",
                                                "StreetNumber",
                                                new PostalCode("12345",
                                                        "PorkVille")))));

        //WHEN
        ParkingLot parkingLot = parkingLotMapper.mapCreateParkingLotDtoToParkingLot(createParkingLotDto);

        //THEN
        assertThat(parkingLot).isInstanceOf(ParkingLot.class);
        assertThat(parkingLot.getName()).isEqualTo("bork of porkshork");
    }



    @Test
    void whenCreateParkingLot_thenThatParkingLotIsInDatabase() {

        CreateParkingLotDto createParkingLotDto =
                new CreateParkingLotDto("mark of parkshark",
                        Category.ABOVE_GROUND_BUILDING,
                        2000,
                        4.5,
                        new Address("StreetOfMark",
                                "NumberOfMark",
                                new PostalCode("12345",
                                        "MarkVille")),
                        List.of(
                                new ContactPerson("Mark",
                                        "MarksMobile",
                                        null,
                                        "mark@parkshark.com",
                                        new Address("StreetName",
                                                "StreetNumber",
                                                new PostalCode("12345",
                                                        "MarkVille")))));


        parkingLotService.createParkingLot(createParkingLotDto);

//        assertThat(parkingLotRepository.findParkingLotById(2).get().getName()).isEqualTo("mark of parkshark");
        assertThat(parkingLotService.getParkingLotById(2).getName()).isEqualTo("mark of parkshark");
    }

    @Test
    void givenNewParkingLotInDatabase_whenGetParkingLotByIdWithId_thenReturnThisNewParkingLot() {

        CreateParkingLotDto createParkingLotDto =
                new CreateParkingLotDto("marky of parksharky",
                        Category.ABOVE_GROUND_BUILDING,
                        2000,
                        4.5,
                        new Address("StreetOfMark",
                                "NumberOfMark",
                                new PostalCode("12345",
                                        "MarkVille")),
                        List.of(
                                new ContactPerson("Mark",
                                        "MarksMobile",
                                        null,
                                        "mark@parkshark.com",
                                        new Address("StreetName",
                                                "StreetNumber",
                                                new PostalCode("12345",
                                                        "MarkVille")))));


        parkingLotService.createParkingLot(createParkingLotDto);

        //TODO check if ID cleans up after each test
        //WHEN
        ParkingLotDto actual = parkingLotService.getParkingLotById(3);

        //TODO add custom exception
        //THEN
        assertThat(actual.getName()).isEqualTo("marky of parksharky");
        assertThat(actual.getMaxCapacity()).isEqualTo(2000);
    }

    @Test
    void givenTwoNewParkingLotsInDatabase_whenGetAllParkingLots_thenReturnTheseParkingLots() {



    }

}
