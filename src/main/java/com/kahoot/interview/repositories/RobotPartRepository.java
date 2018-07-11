package com.kahoot.interview.repositories;

import com.kahoot.interview.domain.RobotPart;
import com.kahoot.interview.domain.RobotPartCompatible;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RobotPartRepository extends CrudRepository<RobotPart, Long> {

    /**
     * Finds a person by using the last name as a search criteria.
     *
     * @param id
     * @return A list of persons whose last name is an exact match with the given last name.
     * If no persons is found, this method returns an empty list.
     */
    // @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
    List<RobotPartCompatible> findCompatiblePartsById(String id);
}
