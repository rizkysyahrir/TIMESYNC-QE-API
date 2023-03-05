Feature: Post employee approvals Timesync API
  @Timesync @PositiveCase
  Scenario: Post employee approvals with valid JSON
    Given Post employee with valid token and json
    When Send request post employee approvals
    Then Should return status code 201
    And Response body message "send an approval success"
    And Validate JSON schema post approvals

  @Timesync @NegativeCase
  Scenario: Post employee approval invalid token
    Given Post employee with invalid token and json
    When Send request post employee approvals
    Then Should return status code 401
    And Response body message "invalid or expired jwt"

  @Timesync @NegativeCase
  Scenario: Post employee approvals with invalid JSON
    Given Post employee with valid token and empty title
    When Send request post employee approvals
    Then Should return status code 400
    And Response body message "validate: Title is required"

  @Timesync @NegativeCase
  Scenario: Post employee approvals with invalid JSON
    Given Post employee with valid token and empty Approvals Start Date
    When Send request post employee approvals
    Then Should return status code 400
    And Response body message "validate: StartDate is required"

  @Timesync @NegativeCase
  Scenario: Post Employee approvals with invalid JSON
    Given Post employee with valid token and empty Approvals End Date
    When Send request post employee approvals
    Then Should return status code 400
    And Response body message "validate: EndDate is required"

  @Timesync @NegativeCase
  Scenario: Post Employee approvals with invalid JSON
    Given Post employee with valid token and empty Approvals Description
    When Send request post employee approvals
    Then Should return status code 400
    And Response body message "validate: Description is required"