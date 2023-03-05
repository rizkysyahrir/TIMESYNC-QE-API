Feature: Get Record Employees Timesync API
  @Timesync @PositiveCase
  Scenario: Get Record Employee valid token and valid params value
    Given Get Record with token employee and parameter value date_from "2023-02-09" and date_to "2023-02-10"
    When Send request get record
    Then Should return status code 200
    And Response body message "success show employee attendance record"
    And Validate JSON schema get record

  @Timesync @NegativeCase
  Scenario: Get Record Employee with invalid token
    Given Get Record with invalid token employee and parameter value date_from "2023-02-09" and date_to "2023-02-10"
    When Send request get record
    Then Should return status code 401
    And Response body message "invalid or expired jwt"

  @Timesync @NegativeCase
  Scenario:Get Record Employee valid token and invalid params value
    Given Get Record with token employee and parameter value date_from "2023-02-10" and date_to "2023-02-09"
    When Send request get record
    Then Should return status code 400
    And Response body message "input format inccorect"

