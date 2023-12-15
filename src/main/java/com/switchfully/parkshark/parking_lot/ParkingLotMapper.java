package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.parking_lot.domain.ParkingLot;
import com.switchfully.parkshark.parking_lot.dto.CreateParkingLotDto;
import com.switchfully.parkshark.parking_lot.dto.ParkingLotDto;

public class ParkingLotMapper {

	public ParkingLot mapCreateParkingLotDtoToParkingLot(CreateParkingLotDto createParkingLotDto){
		return new ParkingLot(createParkingLotDto.getName(),
				createParkingLotDto.getCategory(),
				createParkingLotDto.getMaxCapacity(),
				createParkingLotDto.getPricePerHour(),
				createParkingLotDto.getAddress(),
				createParkingLotDto.getContactPersons());
	}

	public ParkingLotDto mapParkingLotToParkingLotDto(ParkingLot parkingLot){
		return new ParkingLotDto(parkingLot.getId(),
				parkingLot.getName(),
				parkingLot.getCategory(),
				parkingLot.getMaxCapacity(),
				parkingLot.getPricePerHour(),
				parkingLot.getAddress(),
				parkingLot.getContactPersons());
	}
}
