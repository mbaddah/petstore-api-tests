package org.store.pets;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PetStoreApiUserTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.filters(new AllureRestAssured());
    }

    @Test
    public void testCreateUserList() {
        String userJson =  """
            [
                {
                    "id": 1,
                    "username": "jDoe01",
                    "firstName": "John",
                    "lastName": "Doe",
                    "email": "john.doe@example.com",
                    "password": "pass1",
                    "phone": "1234567890",
                    "userStatus" : 0
                }
            ]""";

        given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .body(userJson)
                .when()
                .post("/user/createWithList")
                .then()
                .statusCode(200);
    }
    @Test
    public void testGetUserByUsername() {
        String username = "jDoe01";

        given()
                .filter(new AllureRestAssured())
                .pathParam("username", username)
                .when()
                .get("/user/{username}")
                .then()
                .statusCode(200);
    }

    @Test
    public void testUserLogin() {
        String username = "jDoe01";
        String password = "pass1";

        given()
                .filter(new AllureRestAssured())
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
                .filter(new AllureRestAssured())
                .when()
                .get("/user/logout")
                .then()
                .statusCode(200);
    }
}
