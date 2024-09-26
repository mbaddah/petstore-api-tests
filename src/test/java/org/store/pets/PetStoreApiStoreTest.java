package org.store.pets;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.store.pets.util.ConfigProperties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreApiStoreTest extends ConfigProperties {
    int orderId = 3;

    @Test
    public void testGetStoreInventory() {
        given()
                .when()
                .get("/store/inventory")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPostOrderPet() {
        String orderJson = String.format("""
                {
                    "id": %d,
                    "petId": 2,
                    "quantity": 1,
                    "shipDate": "2021-09-01T12:00:00.000Z",
                    "status": "placed",
                    "complete": true
                }""", orderId);

        given()
                .contentType("application/json")
                .body(orderJson)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200);
    }
    @Test
    public void testGetStoreOrderById() {

        given()
                .pathParam("orderId", orderId)
                .when()
                .get("/store/order/{orderId}")
                .then()
                .statusCode(200);
    }

    @Test
    public void testDeleteStoreOrderById() {

        given()
                .pathParam("orderId", orderId)
                .when()
                .delete("/store/order/{orderId}")
                .then()
                .statusCode(200);
    }
}
