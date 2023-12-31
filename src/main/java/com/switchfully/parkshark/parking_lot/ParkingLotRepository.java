package com.switchfully.parkshark.parking_lot;

import com.switchfully.parkshark.parking_lot.domain.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {

    Optional<ParkingLot> findParkingLotById(long id);

    List<ParkingLot> findAll();

}
