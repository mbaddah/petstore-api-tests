 # petstore-api-tests

## Description

This project contains automated tests for the Petstore API. The tests are written in Java using the RestAssured library.

## Configuration

baseURI is configured in the `config.properties` file.


## Spotless

Before raising a PR, please run the following command to fix any formatting issues with your code:

- `./gradlew spotlessApply`

## Running tests

Run your tests using Gradle:

- `./gradlew test`

## References

- [RestAssured](https://rest-assured.io/)
- [Swagger Petstore](https://petstore.swagger.io/)