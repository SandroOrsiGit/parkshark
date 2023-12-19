package com.switchfully.parkshark.manager;

import com.switchfully.parkshark.exception.ManagerPasswordIncorrectException;
import com.switchfully.parkshark.exception.NotAManagerException;
import com.switchfully.parkshark.manager.domain.Manager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager findManagerById (long id) {
        return managerRepository.findManagerById(id).orElseThrow(IllegalArgumentException::new);
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
