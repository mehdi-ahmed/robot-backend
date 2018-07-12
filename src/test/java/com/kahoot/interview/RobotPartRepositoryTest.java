package com.kahoot.interview;

import com.kahoot.interview.domain.RobotPart;
import com.kahoot.interview.repositories.RobotPartRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RobotPartRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RobotPartRepository robotPartRepository;

    @Test
    public void whenFindById_thenReturnRobotPart() {
        RobotPart robotPart1 = new RobotPart();
        robotPart1.setName("testRobotPartName1");
        robotPart1.setManufacturer("kahoot1");
        robotPart1.setSerialNumber("serialNumber1");
        robotPart1.setWeight("1kg");


        entityManager.persist(robotPart1);
        entityManager.flush();


    }
}
