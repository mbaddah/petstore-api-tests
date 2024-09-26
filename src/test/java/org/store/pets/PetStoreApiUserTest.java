package org.store.pets;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.store.pets.util.ConfigProperties;

public class PetStoreApiUserTest extends ConfigProperties {

  private int userId = 1;
  private String username = "jDoe01";
  private String password = "pass1";

  @Test
  public void testCreateUserList() {

    String userJson =
        """
        [
            {
                "id": %d,
                "username": "%s",
                "firstName": "John",
                "lastName": "Doe",
                "email": "john.doe@example.com",
                "password": "%s",
                "phone": "1234567890",
                "userStatus": 0
            }
        ]"""
            .formatted(userId, username, password);
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
    given().pathParam("username", username).when().get("/user/{username}").then().statusCode(200);
  }

  @Test
  public void testUserLogin() {
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
    given().when().get("/user/logout").then().statusCode(200);
  }
}
