Feature: Update users on dummyapi platform
  An user should be able to update information on the platform

  Scenario: update an user on dummyapi
    Given Jessica is an user of the platform
    When she updates her personal information:
      | id                       | firstName | lastName |
      | 60d0fe4f5311236168a109d9 | Jessica   | Carrillo |
    Then she should see that information was updated successfully

  Scenario: update an user that does not exist on dummyapi
    Given Jessica is an user of the platform
    When she tries to update the info of the user:
      | id                       | firstName | lastName |
      | 632cefa876f1294d07f835ee | Gabriel   | Garcia   |
    Then she should see that info was not updated
