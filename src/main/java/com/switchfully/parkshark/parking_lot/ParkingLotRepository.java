package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.parking_lot.domain.ParkingLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Long> {

}
