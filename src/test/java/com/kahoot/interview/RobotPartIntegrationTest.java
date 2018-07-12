package com.kahoot.interview;


import com.kahoot.interview.domain.RobotPart;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RobotPartIntegrationTest {

    private static final String API_ROOT = "http://localhost:8081/kahoot/resources/robots";

    @Test
    public void whenGetAllRobotParts_thenOK() {
        final Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }

    @Test
    public void whenGetNotExistRobotPart_thenNotFound() {
        final Response response = RestAssured.get(API_ROOT + "/1000");
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }


    // POST
    @Test
    public void whenCreateRobotPart_thenCreated() {
        final RobotPart part = createRandomRobotPart();

        final Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(part)
                .post(API_ROOT + "/add");
        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }


    @Test
    public void whenInvalidRobotPart_thenError() {
        final RobotPart partInvalid = createRandomRobotPart();
        partInvalid.setSerialNumber(null);

        final Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(partInvalid)
                .post(API_ROOT + "/add");
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }

    private RobotPart createRandomRobotPart() {
        RobotPart justCreated = new RobotPart();
        justCreated.setName("testRobotPartName1");
        justCreated.setManufacturer("kahoot1");
        justCreated.setSerialNumber("serialNumber1");
        justCreated.setWeight("1kg");

        return justCreated;
    }


}
