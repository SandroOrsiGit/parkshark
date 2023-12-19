package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.manager.ManagerService;
import com.switchfully.parkshark.parking_lot.dto.CreateParkingLotDto;
import com.switchfully.parkshark.parking_lot.dto.ParkingLotDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "parking-lots")
public class ParkingLotController {

	private final ParkingLotService parkingLotService;
	private final ManagerService managerService;

	public ParkingLotController(ParkingLotService parkingLotService, ManagerService managerService) {
		this.parkingLotService = parkingLotService;
		this.managerService = managerService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ParkingLotDto createParkingLot(@RequestHeader String username, @RequestHeader String password, @RequestBody CreateParkingLotDto createParkingLotDto){
		managerService.checkIfUserIsManager(username, password);

		return parkingLotService.createParkingLot(createParkingLotDto);
	}

	@GetMapping(produces = "application/json")
	public List<ParkingLotDto> getAllParkingLots(@RequestHeader String username, @RequestHeader String password) {
		managerService.checkIfUserIsManager(username, password);

		return parkingLotService.getAllParkingLots();
	}

	@GetMapping(path = "{id}", produces = "application/json")
	public ParkingLotDto getParkingLotById(@RequestHeader String username, @RequestHeader String password, @PathVariable long id) {
		managerService.checkIfUserIsManager(username, password);

		return parkingLotService.getParkingLotById(id);
	}

}
