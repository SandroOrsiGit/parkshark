package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.address.domain.Address;
import com.switchfully.parkshark.division.domain.Division;
import com.switchfully.parkshark.exception.ManagerPasswordIncorrectException;
import com.switchfully.parkshark.exception.NotAManagerException;
import com.switchfully.parkshark.manager.domain.Manager;
import com.switchfully.parkshark.parking_lot.domain.Category;
import com.switchfully.parkshark.parking_lot.domain.ContactPerson;
import com.switchfully.parkshark.parking_lot.domain.ParkingLot;
import com.switchfully.parkshark.parking_lot.domain.PostalCode;
import com.switchfully.parkshark.parking_lot.dto.CreateParkingLotDto;
import com.switchfully.parkshark.parking_lot.dto.ParkingLotDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ParkingLotServiceTest {
   @Autowired
   private ParkingLotService parkingLotService;
   
   @Autowired
   private ParkingLotRepository parkingLotRepository;
   @Autowired
   private ParkingLotMapper parkingLotMapper;
   @Autowired
   private ParkingLotController parkingLotController;
   
   @Test
   void givenParkingLot_whenMappingParkingLotToParkingLotDto_thenResultIsOfTypeParkingLotDtoWithSameFields() {
      ParkingLot parkingLot = new ParkingLot("mark of parkshark", Category.ABOVE_GROUND_BUILDING, 2000, 4.5, new Address("StreetOfMark", "NumberOfMark", new PostalCode("12345", "MarkVille")), List.of(new ContactPerson("Mark", "MarksMobile", null, "mark@parkshark.com", new Address("StreetName", "StreetNumber", new PostalCode("12345", "MarkVille")))), new Division("divisionName", "originalDevisionName", "Jef"));
      
      //WHEN
      ParkingLotDto parkingLotDto = parkingLotMapper.mapParkingLotToParkingLotDto(parkingLot);
      
      //THEN
      assertThat(parkingLotDto).isInstanceOf(ParkingLotDto.class);
      assertThat(parkingLotDto.getName()).isEqualTo(parkingLot.getName());
   }
   
   @Test
   void givenCreateParkingLotDto_whenMapToParkingLot_thenResultIsOfTypeParkingLotWithSameFields() {
      CreateParkingLotDto createParkingLotDto = new CreateParkingLotDto("bork of porkshork", Category.ABOVE_GROUND_BUILDING, 2000, 4.5, new Address("StreetOfPork", "NumberOfPork", new PostalCode("12345", "PorkVille")), List.of(new ContactPerson("Pork", "PorksMobile", null, "mork@porkshork.com", new Address("StreetName", "StreetNumber", new PostalCode("12345", "PorkVille")))), new Division("divisionName", "originalDevisionName", "Jef"));
      
      //WHEN
      ParkingLot parkingLot = parkingLotMapper.mapCreateParkingLotDtoToParkingLot(createParkingLotDto);
      
      //THEN
      assertThat(parkingLot).isInstanceOf(ParkingLot.class);
      assertThat(parkingLot.getName()).isEqualTo("bork of porkshork");
   }
   
   
   @Test
   void whenCreateParkingLot_thenThatParkingLotIsInDatabase() {
      
      CreateParkingLotDto createParkingLotDto = new CreateParkingLotDto("mark of parkshark", Category.ABOVE_GROUND_BUILDING, 2000, 4.5, new Address("StreetOfMark", "NumberOfMark", new PostalCode("12345", "MarkVille")), List.of(new ContactPerson("Mark", "MarksMobile", null, "mark@parkshark.com", new Address("StreetName", "StreetNumber", new PostalCode("12345", "MarkVille")))), new Division("divisionName", "originalDevisionName", "Jef"));
      
      
      ParkingLotDto parkingLotDto = parkingLotService.createParkingLot(createParkingLotDto);
      
      //WHEN
      ParkingLotDto actual = parkingLotService.getParkingLotById(parkingLotDto.getId());
      
      //THEN
      assertThat(actual.getName()).isEqualTo("mark of parkshark");
      assertThat(actual.getContactPersons()).hasSize(1).extracting(ContactPerson::getMobilePhoneNumber).containsExactly("MarksMobile");
      assertThat(actual.getContactPersons()).extracting(ContactPerson::getTelephoneNumber).containsExactly((String) null);
      assertThat(actual.getContactPersons()).extracting(ContactPerson::getEmail).containsExactly("mark@parkshark.com");
   }
   
   @Test
   void givenNewParkingLotInDatabase_whenGetParkingLotByIdWithId_thenReturnThisNewParkingLot() {
      
      CreateParkingLotDto createParkingLotDto = new CreateParkingLotDto("marky of parksharky", Category.ABOVE_GROUND_BUILDING, 2000, 4.5, new Address("StreetOfMark", "NumberOfMark", new PostalCode("12345", "MarkVille")), List.of(new ContactPerson("Mark", "MarksMobile", null, "mark@parkshark.com", new Address("StreetName", "StreetNumber", new PostalCode("12345", "MarkVille")))), new Division("divisionName", "originalDevisionName", "Jef"));
      
      
      ParkingLotDto parkingLotDto = parkingLotService.createParkingLot(createParkingLotDto);
      
      //TODO check if ID cleans up after each test
      //WHEN
      ParkingLotDto actual = parkingLotService.getParkingLotById(parkingLotDto.getId());
      
      //TODO add custom exception
      //THEN
      assertThat(actual.getName()).isEqualTo("marky of parksharky");
      assertThat(actual.getMaxCapacity()).isEqualTo(2000);
      assertThat(actual.getAddress().getPostalCode().getLocation()).isEqualTo("MarkVille");
      assertThat(actual.getAddress().getPostalCode().getPostalCode()).isEqualTo("12345");
   }
   
   @Test
   void givenTwoNewParkingLotsInDatabase_whenGetAllParkingLots_thenReturnTheseParkingLots() {
      //GIVEN
      CreateParkingLotDto createParkingLotDto1 = new CreateParkingLotDto("marko of parksharko", Category.ABOVE_GROUND_BUILDING, 2000, 4.5, new Address("StreetOfMarko", "NumberOfMarko", new PostalCode("12345o", "MarkoVille")), List.of(new ContactPerson("Marko", "MarkosMobile", null, "marko@parkshark.com", new Address("StreetName", "StreetNumber", new PostalCode("12345", "MarkoVille")))), new Division("divisionName", "originalDevisionName", "Jef"));
      
      
      ParkingLotDto parkingLotDto1 = parkingLotService.createParkingLot(createParkingLotDto1);
      
      CreateParkingLotDto createParkingLotDto2 = new CreateParkingLotDto("markeh of parksharkeh", Category.UNDERGROUND_BUILDING, 2500, 8.5, new Address("StreetOfMarkeh", "NumberOfMarkeh", new PostalCode("12345eh", "MarkehVille")), List.of(new ContactPerson("Markeh", "MarkehsMobile", null, "markehparkshark.com", new Address("StreetName", "StreetNumber", new PostalCode("12345", "MarkehVille")))), new Division("divisionName", "originalDevisionName", "Jef"));
      
      
      ParkingLotDto parkingLotDto2 = parkingLotService.createParkingLot(createParkingLotDto2);
      
      //WHEN
      List<ParkingLotDto> parkingLotDtoList = parkingLotService.getAllParkingLots();
      
      //THEN
      assertThat(parkingLotDtoList).allSatisfy(parkingLotDto -> assertThat(parkingLotDto).isInstanceOf(ParkingLotDto.class));
      assertThat(parkingLotDtoList).hasSize(3);
      
      assertThat(parkingLotDtoList.get(0).getName()).isEqualTo("ParkingLotName");
      assertThat(parkingLotDtoList.get(1).getName()).isEqualTo(parkingLotDto1.getName());
      assertThat(parkingLotDtoList.get(2).getName()).isEqualTo(parkingLotDto2.getName());
      
      
   }

   @Test
   void givenInvalidManagerUserName_whenGetAllParkingLots_thenThrowNotAManagerException() {
      //GIVEN
      Manager manager = new Manager("wrongUsername", "parky");

      //WHEN & THEN
      assertThrows(NotAManagerException.class, () -> parkingLotController.getAllParkingLots(manager.getUsername(), manager.getPassword()))
      ;
   }

   @Test
   void givenInvalidManagerPassword_whenGetAllParkingLots_thenThrowManagerPasswordException() {
      //GIVEN
      Manager manager = new Manager("wrongUsername", "wrongPassword");

      //WHEN & THEN
      assertThrows(ManagerPasswordIncorrectException.class, () -> parkingLotController.getAllParkingLots(manager.getUsername(), manager.getPassword()))
      ;
   }

   @Test
   void givenInvalidManagerPassword_whenGetParkingLotById_thenThrowManagerPasswordException() {
      //GIVEN
      Manager manager = new Manager("wrongUsername", "wrongPassword");

      //WHEN & THEN
      assertThrows(ManagerPasswordIncorrectException.class, () -> parkingLotController.getParkingLotById(manager.getUsername(), manager.getPassword(), 1));
   }
   
}
