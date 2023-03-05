Feature: Presences Employees Timesync API
  @Timesync @PositiveCase
  Scenario: Admin can see presences total
    Given Get presences total employees by admin
    When Send request presences total employees
    Then Should return status code 200
    And Response body message get presences total should be: "success show all employe presence data today"
    And Validate json schema get presences total

  @Timesync @PositiveCase
  Scenario Outline: Admin can see presences detail employees
    Given Get presences detail employees by admin with id <id>
    When Send request get presences detail
    Then Should return status code 200
    And Response body message get presences detail should be: "success show presence data detail"
    And Validate json schema get presences detail
    Examples:
      | id  |
      | 226 |
      | 227 |
      | 228 |
      | 229 |
      | 218 |