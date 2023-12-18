package com.switchfully.parkshark.manager;

import com.switchfully.parkshark.manager.domain.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@Transactional
class ManagerServiceTest {
   
   @Autowired
   private ManagerService managerService;
   
   @Autowired
   private ManagerRepository managerRepository;

   
   @Test
   void whenFindManagerById_ShouldReturnManagerWhenFound() {
      //GIVEN
      Manager expectedManager = new Manager(
              "testertest",
              "testertest"
      );

      //WHEN
      managerRepository.save(expectedManager);

      Manager result = managerService.findManagerById(expectedManager.getId());

      //THEN
      assertEquals(expectedManager, result);
   }

}