Feature: Register Employee Timesync API

  @Timesync @PositiveCase
  Scenario: Post admin register employees success
    Given Admin create employee with valid json
    When Send request post create employee
    Then Should return status code 201
    And Response body message success should be email: "success create account"
    And Validate json schema create new employee

 @Timesync @PositiveCase
 Scenario: Post admin can register employees by csv
   Given Admin create employees with file csv
   When Send request create employee by csv
   Then Should return status code 201
   And Response body message put should be status: "success create account from csv"

 @Timesync @NegativeCase
 Scenario: Post admin can't register with invalid extension files
   Given Admin create employees with file other than csv
   When Send request create employee by csv
   Then Should return status code 400
   And Response body message should be status: "validate: file type error, only csv can be upload"


  @Timesync @NegativeCase
  Scenario: Post admin register employees failed
    Given Admin create employee with valid json
    When Send request post create employee
    Then Should return status code 400
    And Response body message should be email: "email already registered"
    And Validate json schema create new employee