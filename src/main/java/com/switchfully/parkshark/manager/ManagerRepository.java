package com.switchfully.parkshark.manager;

import com.switchfully.parkshark.manager.domain.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {
    Optional<Manager> findManagerById(long id);
}
