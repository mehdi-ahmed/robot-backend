package com.kahoot.interview.rest;

import com.kahoot.interview.domain.RobotPart;
import com.kahoot.interview.domain.RobotPartCompatible;
import com.kahoot.interview.repositories.RobotPartCompatibleRepository;
import com.kahoot.interview.repositories.RobotPartRepository;
import com.kahoot.interview.rest.exception.RobotPartIdMismatchException;
import com.kahoot.interview.rest.exception.RobotPartNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/kahoot/resources/robots")
public class RobotPartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RobotPartController.class);


    @Autowired
    private RobotPartRepository robotPartRepository;

    @Autowired
    private RobotPartCompatibleRepository robotPartCompatibleRepository;


    @ApiOperation(value = "Return all robot parts", notes = "All Robot Parts")
    @GetMapping
    public Iterable findAll() {
        LOGGER.info("Finding All Robot Parts..");

        return robotPartRepository.findAll();
    }

    @ApiOperation(value = "Returns a RobotPart by Id", notes = "Returns a RobotPart object")
    @GetMapping(value = "/{id}")
    public RobotPart findOneRobotPart(@PathVariable long id) {
        return robotPartRepository.findById(id).orElseThrow(() -> new RobotPartNotFoundException("The RobotPart is MIA !"));
    }

    @ApiOperation(value = "Returns a list of RobotParts compatible with a given robot RobotPart Id", notes = "List of compatible Stuff")
    @GetMapping(value = "/compatible/{sourceRobotPartId}")
    public List<RobotPartCompatible> getCompatibleParts(@PathVariable long sourceRobotPartId) {
        return robotPartCompatibleRepository.findBySourceRobotPartId(sourceRobotPartId) ;
    }


    @ApiOperation(value = "Adds a new RobotPart", notes = "Return a newly added part if success")
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public RobotPart add(@RequestBody RobotPart robotPart) {
        return robotPartRepository.save(robotPart);
    }

    @ApiOperation(value = "Delete a RobotPart", notes = "Delete")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info(String.format("Deleting Robot part with Id = %d", id));

        robotPartRepository.findById(id).orElseThrow(() -> new RobotPartNotFoundException("The RobotPart is MIA !"));
        robotPartRepository.deleteById(id);
    }

    @ApiOperation(value = "Updates a RobotPart", notes = "Updates a RobotPart. Any new compatible RobotPart needs to be added via UPDATE")
    @PutMapping("/update/{id}")
    public RobotPart update(@RequestBody RobotPart robotPart, @PathVariable Long id) {
        LOGGER.info(String.format("Updating Robot part with Id = %d", id));

        if (robotPart.getId() != id) {
            throw new RobotPartIdMismatchException("Robot Part Id mismatch !");
        }

        //check if the compatible part to be added is already in the catalogue.
        //In a real life scenario,  a RobotPart that doesn't exist in the cataloge can theoretically be added too...
        //But for the sake of simplicity, I will not only consider the later.
        Set<RobotPartCompatible> compatibleParts = robotPart.getCompatibleParts();
        if (!compatibleParts.isEmpty()) {
            for (RobotPartCompatible compatiblePart : compatibleParts) {
                robotPartRepository.findById(compatiblePart.getId()).orElseThrow(() ->
                        new RobotPartNotFoundException("Only Parts from the catalogue can be added ! "));
            }
        }


        robotPartRepository.findById(id).orElseThrow(() -> new RobotPartNotFoundException("The RobotPart is MIA !"));
        return robotPartRepository.save(robotPart);
    }

    @GetMapping("/name/{name}")
    public List<RobotPart> findByName(@PathVariable String name) {
        return robotPartRepository.findByName(name);
    }
}
