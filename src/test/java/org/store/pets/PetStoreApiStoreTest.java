package org.store.pets;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.store.pets.util.ConfigProperties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreApiStoreTest extends ConfigProperties {
    @Test
    public void testGetStoreInventory() {
        given()
                .when()
                .get("/store/inventory")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetStoreOrderById() {
        int orderId = 3;

        given()
                .pathParam("orderId", orderId)
                .when()
                .get("/store/order/{orderId}")
                .then()
                .statusCode(200);
    }
}
