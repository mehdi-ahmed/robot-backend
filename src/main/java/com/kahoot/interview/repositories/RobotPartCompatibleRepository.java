package com.kahoot.interview.repositories;

import com.kahoot.interview.domain.RobotPartCompatible;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RobotPartCompatibleRepository extends JpaRepository<RobotPartCompatible, Long> {

    List<RobotPartCompatible> findBySourceRobotPartId(long sourceRobotPartId);

}
