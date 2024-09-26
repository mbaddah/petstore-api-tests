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

## Schema validation

To validate schemas add your schema file in the `resources` directory and use `matchesJsonSchemaInClasspath` (see https://github.com/rest-assured/rest-assured/wiki/Usage#json-schema-validation).

## References

- [RestAssured](https://rest-assured.io/)
- [Swagger Petstore](https://petstore.swagger.io/)