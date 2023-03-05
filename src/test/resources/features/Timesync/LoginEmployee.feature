Feature: Login Employee Timesync API
  @Timesync @PositiveCase
  Scenario: Login with valid nip and password
    Given Login with valid JSON
    When Send request post to login
    Then Should return status code 200
    And Response body message "success login"
    And Validate json schema success login

  @Timesync @NegativeCase
  Scenario: Login with valid nip and empty password
    Given Login empty password with invalid JSON
    When Send request post to login
    Then Should return status code 400
    And Response body message "password not allowed empty"

  @Timesync @NegativeCase
  Scenario: Login with empty nip and valid password
    Given Login empty nip with invalid JSON
    When Send request post to login
    Then Should return status code 400
    And Response body message "nip not allowed empty"

  @Timesync @NegativeCase
  Scenario: Login with invalid nip and valid password
    Given Login employee invalid nip and valid password
    When Send request post to login
    Then Should return status code 404
    And Response body message "account not registered"

  @Timesync @NegativeCase
  Scenario: Login with invalid password and valid nip
    Given Login employee invalid password and valid nip
    When Send request post to login
    Then Should return status code 400
    And Response body message "password not match"

  @Timesync @NegativeCase
  Scenario: Login Employee without fill nip and password
    Given Login employee without fill nip and password
    When Send request post to login
    Then Should return status code 400
    And Response body message "nip not allowed empty"