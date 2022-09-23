Feature: Delete registered users from dummyapi platform
  An administrator should be able to delete registered users on the platform

  Scenario: delete an user on dummyapi
    Given Juan is an administrator of the platform
    When he deletes an user by id
    Then he should see that user was deleted successfully

  Scenario: delete an user that does not exist on dummyapi
    Given Juan is an administrator of the platform
    When he deletes an user with id 632cefa876f1294d07f835ee
    Then he should see that user does not exist
