package org.store.pets;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.store.pets.util.ConfigProperties;

public class PetStoreApiPetTest extends ConfigProperties {

  private int petId = 2;

  @Test
  public void testAddNewPet() {
    String petJson =
        String.format(
            """
                {
                    "id": %d,
                    "category": {
                        "id": 1,
                        "name": "Dog"
                    },
                    "name": "Buddy",
                    "photoUrls": [
                        "https://images.dog.ceo/breeds/retriever-chesapeake/n02099849_938.jpg"
                    ],
                    "tags": [
                        {
                            "id": 1,
                            "name": "Friendly"
                        }
                    ],
                    "status": "available"
                }""",
            petId);

    given()
        .contentType("application/json")
        .body(petJson)
        .when()
        .post("/pet")
        .then()
        .statusCode(200);
  }

  @Test
  public void testUpdatePet() {
    String petJson =
        String.format(
            """
                {
                    "id": %d,
                    "category": {
                        "id": 1,
                        "name": "Dog"
                    },
                    "name": "Buddy",
                    "photoUrls": [
                        "https://images.dog.ceo/breeds/retriever-curly/n02099429_1178.jpg"
                    ],
                    "tags": [
                        {
                            "id": %d,
                            "name": "Friendly"
                        }
                    ],
                    "status": "sold"
                }""",
            petId);

    given().contentType("application/json").body(petJson).when().put("/pet").then().statusCode(200);
  }

  @Test
  public void testGetPetById() {

    given()
        .pathParam("petId", petId)
        .when()
        .get("/pet/{petId}")
        .then()
        .statusCode(200)
        .body("id", equalTo(petId));

    //        TODO: Enable this assertion later
    //                .body(matchesJsonSchemaInClasspath("pet-schema.json")); // Validate against
    // JSON Schema

  }

  @Test
  public void testGetPetByStatus() {
    String status = "available";

    given().queryParam("status", status).when().get("/pet/findByStatus").then().statusCode(200);
  }

  @Test
  public void testUpdatePetWithForm() {
    String name = "Buddy";
    String status = "sold";

    given()
        .queryParam("name", name)
        .queryParam("status", status)
        .when()
        .post("/pet/{petId}", petId)
        .then()
        .statusCode(200);
  }

  @Test
  public void testDeletePet() {

    given().pathParam("petId", petId).when().delete("/pet/{petId}").then().statusCode(200);
  }
}
