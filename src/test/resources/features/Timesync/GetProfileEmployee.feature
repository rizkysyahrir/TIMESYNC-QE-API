Feature: Get Employee Profile Timesync API
  @Timesync @PositiveCase
  Scenario: Get Employee profile with valid token employee
    Given Get employee profile with valid token
    When Send request get profile employee
    Then Should return status code 200
    And Response body message "success show profile"
    And Validate JSON schema get employee profile

  @Timesync @NegativeCase
  Scenario: Get Employee profile without token employee
    Given Get employee profile without token
    When Send request get profile employee
    Then Should return status code 400
    And Response body message "missing or malformed jwt"

  @Timesync @NegativeCase
  Scenario: Get Employee profile invalid token
    Given Get employee profile invalid token
    When Send request get profile employee
    Then Should return status code 401
    And Response body message "invalid or expired jwt"

  @Timesync @NegativeCase
  Scenario: Get Employee profile with invalid path
    Given Get employee profile with valid token
    When Send request get profile employee with invalid path
    Then Should return status code 500
    And Response body message "internal server error"



