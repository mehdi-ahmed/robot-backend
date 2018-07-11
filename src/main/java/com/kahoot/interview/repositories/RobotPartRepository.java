package com.kahoot.interview.repositories;

import com.kahoot.interview.domain.RobotPart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RobotPartRepository extends CrudRepository<RobotPart, Long> {

    List<RobotPart> findCompatiblePartsBySerialNumber(String serialId);
}
