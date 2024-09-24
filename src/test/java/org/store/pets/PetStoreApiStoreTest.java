package org.store.pets;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreApiStoreTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    public void testGetStoreInventory() {
        given()
                .filter(new AllureRestAssured())
                .when()
                .get("/store/inventory")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetStoreOrderById() {
        int orderId = 3;

        given()
                .filter(new AllureRestAssured())
                .pathParam("orderId", orderId)
                .when()
                .get("/store/order/{orderId}")
                .then()
                .statusCode(200);
    }
}
