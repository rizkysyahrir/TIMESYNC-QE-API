Feature: List Employees Timesync API
  @Timesync @PositiveCase
  Scenario: Get list employees
    Given GET list all employees by admin
    When Send request get list employees
    Then Should return status code 200
    And Validate json schema all list employees

  @Timesync @PositiveCase
  Scenario: Get single employee
    Given GET employee with valid id 19
    When Send request get single user
    Then Should return status code 200
    And Validate json schema single employee

  @Timesync @NegativeCase
  Scenario: Get single employee invalid param
    Given GET employee with valid id 19
    When Send request get single employee invalid path
    Then Should return status code 404
    And Validate json schema single employee invalid path