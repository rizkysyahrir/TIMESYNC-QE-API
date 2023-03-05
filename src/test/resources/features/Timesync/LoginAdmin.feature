Feature: Login Admin Timesync API
  @Timesync @PositiveCase
  Scenario: Post login as an admin
    Given Login admin with valid json
    When Send request post login admin
    Then Should return status code 200
    And Response body message should be status: "success login"
    And Validate json schema login as an admin

  @Timesync @NegativeCase
  Scenario: Post login as an admin invalid json
    Given Login admin with invalid json
    When Send request post login admin
    Then Should return status code 400
    And Response body message should be status: "password not match"
    And Validate json schema login as an admin invalid json