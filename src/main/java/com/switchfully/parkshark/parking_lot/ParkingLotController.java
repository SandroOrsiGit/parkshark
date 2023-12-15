package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.parking_lot.dto.CreateParkingLotDto;
import com.switchfully.parkshark.parking_lot.dto.ParkingLotDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "parking-lot")
public class ParkingLotController {

	private final ParkingLotService parkingLotService;

	public ParkingLotController(ParkingLotService parkingLotService) {
		this.parkingLotService = parkingLotService;
	}

//	@PostMapping(consumes = "application/json", produces = "application/json")
//	public ParkingLotDto createParkingLot(CreateParkingLotDto createParkingLotDto){
//		return parkingLotService.createParkingLot(createParkingLotDto);
//	}
}
