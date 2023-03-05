Feature: Get Employee Approvals Timesync API
  @Timesync @PositiveCase
  Scenario: Get Employee Approvals with valid token and valid path
    Given Get Employee Approvals with valid token
    When Send request get Employee Approvals
    Then Should return status code 200
    And Response body message "success show employee approval record"
    And Validate JSON schema get Employee Approvals

  @Timesync @NegativeCase
  Scenario: Get Employee Approvals with invalid token and valid path
    Given Get Employee Approvals with invalid token
    When Send request get Employee Approvals
    Then Should return status code 401
    And Response body message "invalid or expired jwt"

  @Timesync @NegativeCase
  Scenario: Get Employee Approvals without token and valid path
    Given Get Employee Approvals without token
    When Send request get Employee Approvals
    Then Should return status code 400
    And Response body message "missing or malformed jwt"

  @Timesync @NegativeCase
  Scenario: Get Employee Approvals with valid token and invalid path
    Given Get Employee Approvals with valid token
    When Send request get Employee Approvals with invalid path
    Then Should return status code 404
    And Response body message "Not Found"