package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.parking_lot.domain.ParkingLot;
import com.switchfully.parkshark.parking_lot.dto.CreateParkingLotDto;
import com.switchfully.parkshark.parking_lot.dto.ParkingLotDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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


    public List<ParkingLotDto> getAllParkingLots() {

        return parkingLotRepository.findAll().stream().map(parkingLot -> parkingLotMapper.mapParkingLotToParkingLotDto(parkingLot)).toList();
    }

	//TODO add custom exceptions
	public ParkingLotDto getParkingLotById(long id) {
		return parkingLotMapper.mapParkingLotToParkingLotDto(parkingLotRepository.findById(id).orElseThrow(IllegalArgumentException::new));
	}
}
