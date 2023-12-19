package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.exception.ManagerPasswordIncorrectException;
import com.switchfully.parkshark.exception.NotAManagerException;
import com.switchfully.parkshark.parking_lot.domain.ParkingLot;
import com.switchfully.parkshark.parking_lot.dto.CreateParkingLotDto;
import com.switchfully.parkshark.parking_lot.dto.ParkingLotDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParkingLotService {

	private final ParkingLotRepository parkingLotRepository;
	private final ParkingLotMapper parkingLotMapper;

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

	public void checkIfUserIsManager(String username, String password) throws NotAManagerException {
		checkIfManagerPasswordIsCorrect(password);
		if (!username.equals("sharky")) {
			throw new NotAManagerException();
		}
	}

	public void checkIfManagerPasswordIsCorrect(String password) throws ManagerPasswordIncorrectException {
		if (!password.equals("parky")) {
			throw new ManagerPasswordIncorrectException();
		}
	}
}
