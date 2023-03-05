Feature: Get Approvals employee Timesync API
  @Timesync @PositiveCase
  Scenario: Get Approvals employee with valid token and valid path
    Given Get approvals with valid token
    When Send request get approvals
    Then Should return status code 200
    And Response body message "success show all employee approval record"
    And Validate JSON schema get approvals

  @Timesync @NegativeCase
  Scenario: Get Approvals employee with invalid token and valid path
    Given Get approvals with invalid token
    When Send request get approvals
    Then Should return status code 401
    And Response body message "invalid or expired jwt"

  @Timesync @NegativeCase
  Scenario: Get Approvals employee without token and valid path
    Given Get approvals without token
    When Send request get approvals
    Then Should return status code 400
    And Response body message "missing or malformed jwt"

  @Timesync @NegativeCase
  Scenario: Get Approvals employee with valid token and invalid path
    Given Get approvals with valid token
    When Send request get approvals with invalid path
    Then Should return status code 404
    And Response body message "Not Found"