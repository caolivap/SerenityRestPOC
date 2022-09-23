Feature: Validate errors management on dummyapi platform
  An user should be able to see correct error messages on the platform

  Scenario: Try to get registered users list on dummyapi without having app-id
    Given Carlos is an user of the platform
    When he tries look for registered users without having an app-id
    Then he must see the error message missing app-id

  Scenario: Try to get registered users list on dummyapi with incorrect app-id
    Given Carlos is an user of the platform
    When he tries look for registered users with app-id 132a863935bdd3b8cff4d5jo
    Then he must see the error message app-id not exist