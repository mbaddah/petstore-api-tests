package org.store.pets;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.store.pets.util.ConfigProperties;

import static io.restassured.RestAssured.given;

public class PetStoreApiUserTest extends ConfigProperties {

    private int userId = 1;
    private String username = "jDoe01";
    private String password = "pass1";


    @Test
    public void testCreateUserList() {
        String userJson = String.format("""
                [
                    {
                        "id": %d,
                        "username": %s,
                        "firstName": "John",
                        "lastName": "Doe",
                        "email": "john.doe@example.com",
                        "password": "pass1",
                        "phone": "1234567890",
                        "userStatus" : 0
                    }
                ]""", userId, username);

        given()
                .contentType(ContentType.JSON)
                .body(userJson)
                .when()
                .post("/user/createWithList")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetUserByUsername() {
//        String username = "jDoe01";

        given()
                .pathParam("username", username)
                .when()
                .get("/user/{username}")
                .then()
                .statusCode(200);
    }

    @Test
    public void testUserLogin() {
//        String username = "jDoe01";
//        String password = "pass1";

        given()
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .get("/user/login")
                .then()
                .statusCode(200);
    }

    @Test
    public void testUserLogout() {
        given()
                .when()
                .get("/user/logout")
                .then()
                .statusCode(200);
    }
}
