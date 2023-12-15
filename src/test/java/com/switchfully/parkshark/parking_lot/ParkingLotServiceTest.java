package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.address.domain.Address;
import com.switchfully.parkshark.parking_lot.domain.Category;
import com.switchfully.parkshark.parking_lot.domain.ContactPerson;
import com.switchfully.parkshark.parking_lot.domain.PostalCode;
import com.switchfully.parkshark.parking_lot.dto.CreateParkingLotDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql("/data.sql")

public class ParkingLotServiceTest {
    @Autowired
    private ParkingLotService parkingLotService;

    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private ParkingLotMapper parkingLotMapper;

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

        assertThat(parkingLotRepository.findParkingLotById(2).orElse(null))
                .isEqualTo(parkingLotMapper
                        .mapCreateParkingLotDtoToParkingLot(createParkingLotDto));
    }

}
