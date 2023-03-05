Feature: Get Attendances Employees Timesync API
  @Timesync @PositiveCase
  Scenario: Get attendances with valid token and valid params employee
    Given Get attendances employee with token and params value date_from "2023-02-09" and date_to "2023-02-10"
    When Send request get attendances
    Then Should return status code 200
    And Response body message "success show employee attendance record"
    And Validate JSON schema get attendances

  @Timesync @NegativeCase
  Scenario: Get attendances with valid token and Invalid Params
    Given Get attendances employee with token and invalid params value date_from "2023-02-10" and date_to "2023-02-02"
    When Send request get attendances
    Then Should return status code 400
    And Response body message "input format inccorect"

  @Timesync @NegativeCase
  Scenario: Get attendances with invalid token and valid params
    Given Get attendances employee with invalid token and params value date_from "2023-02-09" and date_to "2023-02-10"
    When Send request get attendances
    Then Should return status code 401
    And Response body message "invalid or expired jwt"
