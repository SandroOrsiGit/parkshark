package com.switchfully.parkshark.member;


import com.switchfully.parkshark.address.domain.Address;
import com.switchfully.parkshark.member.domain.LicensePlate;
import com.switchfully.parkshark.member.domain.Name;
import com.switchfully.parkshark.member.domain.dto.CreateMemberDto;
import com.switchfully.parkshark.member.domain.dto.MemberDto;
import com.switchfully.parkshark.parking_lot.domain.PostalCode;
import com.switchfully.parkshark.parking_lot.dto.ParkingLotDto;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MemberControllerIntegrationTest {

	@LocalServerPort
	private int port;
	private CreateMemberDto createMemberDto;

	@Autowired
	private MemberRepository memberRepository;

	@BeforeEach
	void init(){
		createMemberDto = new CreateMemberDto(new Name("testFirst", "testLast"),
				new Address("testStreet",
				"66",
				new PostalCode("3333", "testLocation")),
				"0123456789",
				"test@test.be",
				new LicensePlate("123456", "BE"));
	}

	@Test
	void whenCreateMember_thenReturnCreatedAndPopulateRepository() {
		MemberDto result = given()
				.contentType(ContentType.JSON)
				.baseUri("http://localhost")
				.port(port)
				.header("username", "sharky")
				.header("password", "parky")
				.when()
				.body(createMemberDto)
				.post("/members")
				.then()
				.assertThat()
				.statusCode(201)
				.extract()
				.as(MemberDto.class);

		assertThat(memberRepository.findAll()
				.stream()
				.filter(member -> member.getId() == result.getId())
				.collect(Collectors.toList()))
				.isNotEmpty();
	}

	@Test
	void whenGetAllMembers_thenReturnOk(){
		given()
				.contentType(ContentType.JSON)
				.baseUri("http://localhost")
				.port(port)
				.header("username", "sharky")
				.header("password", "parky")
				.when()
				.get("/members")
				.then()
				.assertThat()
				.statusCode(200);
	}
}