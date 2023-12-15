package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.parking_lot.domain.ParkingLot;
import com.switchfully.parkshark.parking_lot.dto.CreateParkingLotDto;
import com.switchfully.parkshark.parking_lot.dto.ParkingLotDto;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {

	private ParkingLotRepository parkingLotRepository;
	private ParkingLotMapper parkingLotMapper;

	public ParkingLotService(ParkingLotRepository parkingLotRepository, ParkingLotMapper parkingLotMapper) {
		this.parkingLotRepository = parkingLotRepository;
		this.parkingLotMapper = parkingLotMapper;
	}

	public ParkingLotDto createParkingLot(CreateParkingLotDto createParkingLotDto) {
		ParkingLot parkingLot = parkingLotMapper.mapCreateParkingLotDtoToParkingLot(createParkingLotDto);

		parkingLotRepository.save(parkingLot);

		return parkingLotMapper.mapParkingLotToParkingLotDto(parkingLot);
	}



}
