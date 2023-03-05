Feature: Get Employee Inbox Timesync API
  @Timesync @PositiveCase
  Scenario: Get Employee Inbox with valid token employee
    Given Get employee Inbox with valid token
    When Send request get employee Inbox
    Then Should return status code 200
    And Response body message "success show employee inbox message"
    And Validate JSON schema get employee Inbox

  @Timesync @NegativeCase
  Scenario: Get Employee Inbox with invalid token employee
    Given Get employee inbox with invalid token
    When Send request get employee Inbox
    Then Should return status code 401
    And Response body message "invalid or expired jwt"

  @Timesync @NegativeCase
  Scenario: Get Employee Inbox with invalid Path
    Given Get employee Inbox with valid token
    When Send request get employee inbox invalid path
    Then Should return status code 404
    And Response body message "Not Found"
