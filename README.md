 # petstore-api-tests

## Description

Create a test strategy and automated tests for a REST API service:

    Implement REST API automated tests for the https://petstore.swagger.io/
    The idea of this exercise is to implement automated tests for an API
        creating data, modifying existing data, or deleting data.
        test cases for HTTP status codes, sending proper information, invalid information, incorrect format, and other possible edge cases;
    Create the test plans for the features under test
    Choose a framework from your preference
        You can use the same one from the previous exercise explaining it as a part of your resolution
    Report bugs with at least severity and priorities
    Add the instructions to install and how to run the tests (you can use the same one from the previous exercise)
        README.MD
        EXERCISE-2.MD
        BUGREPORT-2.MD

To do:
- [x] Create a test plan for the Petstore API
- [x] Create automated tests for the Petstore API
- [x] Report bugs with severity and priorities
- [x] Add instructions to install and run the tests
- [x] Java formatting and linting
- [x] Create a README.md
- [x] Create a EXERCISE-2.md
- [x] Create a BUGREPORT-2.md
- [x] Create a Github actions workflow
- [x] Create a Dockerfile



## Running tests

Run your tests using Gradle:

- `./gradlew clean build test`

Generate the Allure report:
- `./gradlew allureReport`

Serve the Allure report:
- `./gradlew allureServe`