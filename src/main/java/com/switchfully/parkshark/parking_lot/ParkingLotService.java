package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.parking_lot.dto.CreateParkingLotDto;
import com.switchfully.parkshark.parking_lot.dto.ParkingLotDto;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {

	private ParkingLotRepository parkingLotRepository;

	public ParkingLotService(ParkingLotRepository parkingLotRepository) {
		this.parkingLotRepository = parkingLotRepository;
	}

//	public ParkingLotDto createParkingLot(CreateParkingLotDto createParkingLotDto) {
//
//	}
}