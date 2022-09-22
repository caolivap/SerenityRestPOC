Feature: Look for users registered on dummyapi platform
  An administrator should be able to see the users registered on the platform

  Scenario: get registered users list on dummyapi
    Given Carlos is an administrator of the platform
    When look for the registered users
    Then he must see a registered users list

  Scenario: get registered user by id
    Given Carlos is an administrator of the platform
    When look for the registered user by id 60d0fe4f5311236168a109cf
    Then he must see the first name of the user is Carolina
