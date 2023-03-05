Feature: Get Attendances Location Employees Timesync API
  @Timesync @PositiveCase
  Scenario: Get attendances location employee
    Given Get attendances location employee with valid token
    When Send request get attendances location employee
    Then Should return status code 200
    And Response body message "success get location"
    And Validate JSON schema get attendances location

  @Timesync @NegativeCase
  Scenario: Get attendances location employee with invalid path
    Given Get attendances location employee with valid token
    When Send request get attendances location with invalid path
    Then Should return status code 405
    And Response body message "Method Not Allowed"

  @Timesync @NegativeCase
  Scenario: Get attendances location employee with invalid token
    Given Get attendances location employee with invalid token
    When Send request get attendances location employee
    Then Should return status code 200
    And Response body message "success get location"

