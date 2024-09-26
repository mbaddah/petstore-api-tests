package org.store.pets.util;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.jupiter.api.BeforeAll;

public class ConfigProperties {

  @BeforeAll
  public static void setup() {
    Properties properties = new Properties();
    try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
      properties.load(input);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    RestAssured.baseURI = properties.getProperty("baseURI");
    RestAssured.filters(new AllureRestAssured());
  }
}
