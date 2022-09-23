Feature: Look for users registered on dummyapi platform
  An administrator should be able to see the users registered on the platform

  Scenario: get registered users list on dummyapi
    Given Carlos is an administrator of the platform
    When look for the registered users
    Then he must see a registered users list with some names as Vetle, Pwry and Heinz-Georg

  Scenario: get registered user by id
    Given Carlos is an administrator of the platform
    When look for the registered user by id 632d3c8d3637b0743aba577d
    Then he must see the first name of the user is Jocelyn
