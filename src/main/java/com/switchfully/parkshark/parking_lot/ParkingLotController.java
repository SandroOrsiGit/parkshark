package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.parking_lot.dto.CreateParkingLotDto;
import com.switchfully.parkshark.parking_lot.dto.ParkingLotDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "parking-lots")
public class ParkingLotController {

	private final ParkingLotService parkingLotService;

	public ParkingLotController(ParkingLotService parkingLotService) {
		this.parkingLotService = parkingLotService;
	}

	//TODO add manager checks
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ParkingLotDto createParkingLot(@RequestBody CreateParkingLotDto createParkingLotDto) {
		return parkingLotService.createParkingLot(createParkingLotDto);
	}

	//TODO add manager checks
	@GetMapping(produces = "application/json")
	public List<ParkingLotDto> getAllParkingLots() {
		return parkingLotService.getAllParkingLots();
	}

	@GetMapping(path = "{id}", produces = "application/json")
	public ParkingLotDto getParkingLotById(@PathVariable long id) {
		return parkingLotService.getParkingLotById(id);
	}

}
