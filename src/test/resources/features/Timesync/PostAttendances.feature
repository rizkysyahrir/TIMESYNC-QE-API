Feature: Post Attendances Employees Timesync API
  @Timesync @PositiveCase
  Scenario: Post Attendances employee
    Given Post Attendances with valid token
    When Send request post attendances
    Then Should return status code 201
    And Response body message "clock in success"

  @Timesync @NegativeCase
  Scenario: Post Attendances employee absent twice in one day
    Given Post Attendances with valid token
    When Send request post attendances
    Then Should return status code 400
    And Response body message "clock in fail, you already clock in today"

  @Timesync @NegativeCase
  Scenario: Post Attendance clock in session has ended
    Given Post Attendances with valid token
    When Send request post attendances
    Then Should return status code 400
    And Response body message "clock in session has ended"