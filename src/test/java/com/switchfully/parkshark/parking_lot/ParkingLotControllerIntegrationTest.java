package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.address.domain.Address;
import com.switchfully.parkshark.division.domain.Division;
import com.switchfully.parkshark.parking_lot.domain.Category;
import com.switchfully.parkshark.parking_lot.domain.ContactPerson;
import com.switchfully.parkshark.parking_lot.domain.PostalCode;
import com.switchfully.parkshark.parking_lot.dto.CreateParkingLotDto;
import com.switchfully.parkshark.parking_lot.dto.ParkingLotDto;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingLotControllerIntegrationTest {

	@LocalServerPort
	private int port;

	private CreateParkingLotDto createParkingLotDto;

	@Autowired
	ParkingLotRepository parkingLotRepository;

	@BeforeEach
	void init() {
		createParkingLotDto = new CreateParkingLotDto("testParking",
				Category.ABOVE_GROUND_BUILDING,
				500,
				5.5,
				new Address("testStreet",
						"66",
						new PostalCode("3333", "testLocation")),
				List.of(new ContactPerson("testPerson",
						"012345674896",
						null,
						"test@test.be",
						new Address("testStreet2",
								"77",
								new PostalCode("4444", "testLocation2")))),
				new Division("testDivision",
						"testOriginalDivisionName",
						"testDirector")
		);
	}

	@Test
	void whenCreateParkingLot_thenReturnCreatedAndPopulateRepository() {
		ParkingLotDto result = given()
				.contentType(ContentType.JSON)
				.baseUri("http://localhost")
				.port(port)
				.header("username", "sharky")
				.header("password", "parky")
				.when()
				.body(createParkingLotDto)
				.post("/parking-lots")
				.then()
				.assertThat()
				.statusCode(201)
				.extract()
				.as(ParkingLotDto.class);

		assertThat(parkingLotRepository.findAll()
				.stream()
				.filter(parkingLot -> parkingLot.getId() == result.getId())
				.collect(Collectors.toList()))
				.isNotEmpty();
	}

	@Test
	void whenGetAllParkingLots_thenReturnOk(){
		given()
				.contentType(ContentType.JSON)
				.baseUri("http://localhost")
				.port(port)
				.header("username", "sharky")
				.header("password", "parky")
				.when()
				.get("/parking-lots")
				.then()
				.assertThat()
				.statusCode(200);
	}

	@Test
	void whenGetParkingLotById_thenReturnOk(){
		ParkingLotDto result = given()
				.contentType(ContentType.JSON)
				.baseUri("http://localhost")
				.port(port)
				.header("username", "sharky")
				.header("password", "parky")
				.when()
				.get("/parking-lots/1")
				.then()
				.assertThat()
				.statusCode(200)
				.extract()
				.as(ParkingLotDto.class);

		assertThat(result.getId()).isEqualTo(1);
	}
}