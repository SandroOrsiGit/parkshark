package com.switchfully.parkshark.manager;

import com.switchfully.parkshark.manager.domain.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest

@Sql("/data.sql")

class ManagerServiceTest {
   
   @Autowired
   private ManagerService managerService;
   
   @Autowired
   private ManagerRepository managerRepository;
   
   @Test
   void findManagerById_ShouldReturnManagerWhenFound() {
      

      Manager expectedManager = new Manager(
              1,
              "test",
              "test"
      );
      expectedManager.setId(1);
      
      managerRepository.save(expectedManager);
      
      Manager actualManager = managerService.findManagerById(1);
      
      assertEquals(expectedManager, actualManager);
   
   }
}