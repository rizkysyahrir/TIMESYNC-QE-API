Feature: Put Employees Timesync API
  @Timesync @PositiveCase
  Scenario: Put update photo and password
    Given Put update employees image and password "112233"
    When Send request put employees
    Then Should return status code 200
    And Response body message "success update employee profile"

  @Timesync @NegativeCase
  Scenario: Put update employees with empty data
    Given Put update employee with empty data
    When Send request put employees
    Then Should return status code 200
    And Response body message "no data was change"

  @Timesync @NegativeCase
  Scenario: Put employees with invalid token employee
    Given Put employee with invalid token
    When Send request put employees
    Then Should return status code 401
    And Response body message "invalid or expired jwt"

  @Timesync @NegativeCase
  Scenario: Put employees with invalid photo format
    Given Put update employees invalid image
    When Send request put employees
    Then Should return status code 200
    And Response body message "no data was change"

