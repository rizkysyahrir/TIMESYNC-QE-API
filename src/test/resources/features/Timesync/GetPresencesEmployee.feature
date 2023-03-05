Feature: Get Presences Employees Timesync API
  @Timesync @PositiveCase
  Scenario: Get presences employee
    Given Get presences employee with valid token
    When Send request get presences employee
    Then Should return status code 200
    And Response body message "success show presence data today"
    And Validate JSON schema get presences

  @Timesync @NegativeCase
  Scenario: Get presences employee with invalid token
    Given Get presences employee with invalid token employee
    When Send request get presences employee
    Then Should return status code 401
    And Response body message "invalid or expired jwt"

  @Timesync @NegativeCase
  Scenario: Get presences employee without token
    Given Get presences employee without token employee
    When Send request get presences employee
    Then Should return status code 400
    And Response body message "missing or malformed jwt"

  @Timesync @NegativeCase
  Scenario: Get presences employee invalid path
    Given Get presences employee with valid token
    When Send request get presences employee with invalid path
    Then Should return status code 404
    And Response body message "Not Found"