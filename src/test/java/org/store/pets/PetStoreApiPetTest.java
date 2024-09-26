package org.store.pets;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.store.pets.util.ConfigProperties;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreApiPetTest extends ConfigProperties {


    @Test
    public void testGetPetById() {

        int petId = 2;

        given()
                .pathParam("petId", petId)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(petId));

//        TODO: Enable this assertion later
//                .body(matchesJsonSchemaInClasspath("pet-schema.json")); // Validate against JSON Schema

    }

    @Test
    public void testGetPetByStatus() {
        String status = "available";

        given()
                .queryParam("status", status)
                .when()
                .get("/pet/findByStatus")
                .then()
                .statusCode(200);
    }

}
