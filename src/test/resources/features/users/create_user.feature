Feature: To register users on dummyapi platform
  An user should be able to register on the platform

  Scenario: create an user on dummyapi
    Given Jocelyn is an user of the platform
    When she sends her personal information:
      | title | firstName | lastName | email         |
      | mrs   | Jocelyn   | Oliva    | jocelyn.oliva |
    Then she should see register was successful

  Scenario: create an user already exists on dummyapi
    Given Jocelyn is an user of the platform
    When she wants to register to the already existent user:
      | title | firstName | lastName | email                       |
      | mrs   | Sibylle   | Leibold  | sibylle.leibold@example.com |
    Then she should see that user already exists
