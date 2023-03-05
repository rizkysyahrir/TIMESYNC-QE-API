Feature: Put Attendances Employees Timesync API
  @Timesync @PositiveCase
  Scenario: Put Attendances with valid token
    Given Put attendances with valid token
    When Send request put attendances
    Then Should return status code 200
    And Response body message "clock out success"

  @Timesync @NegativeCase
  Scenario: Put Attendances employee absent twice in one day
    Given Put attendances with valid token
    When Send request put attendances
    Then Should return status code 400
    And Response body message "clock out fail, you already clock out today"

  @Timesync @NegativeCase
  Scenario: Put Attendances dont have clock in data today
    Given Put attendances with valid token
    When Send request put attendances
    Then Should return status code 400
    And Response body message "you dont have clock in data today,you must clock in first"

