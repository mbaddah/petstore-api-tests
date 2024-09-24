package org.store.pets;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreApiPetTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    public void testGetPetById() {
        int petId = 2;

        given()
                .filter(new AllureRestAssured())
                .pathParam("petId", petId)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(petId));

//        TODO: Enable this assertion later
//                .body(matchesJsonSchemaInClasspath("pet-schema.json")); // Validate against JSON Schema

    }
//        @Test
//        void testSomeRequest() {
//            given()
//                    .filter(new AllureRestAssured())
//                    .get("https://jsonplaceholder.typicode.com/todos/1")
//                    .then()
//                    .body("userId", equalTo(1));
//        }
}
