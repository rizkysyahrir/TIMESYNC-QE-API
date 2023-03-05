Feature: Edit Employee Admin Timesync API
  @Timesync @PositiveCase
  Scenario: As an admin can update employee
    Given PUT update employee with data image, id 19, name "Kozuki Momonosuke", birth_of_date "2002-11-23", email "", gender "Male", position "Shogun Wano", phone "", address "Bandung", password ""
    When Send request PUT update employee
    Then Should return status code 200
    And Response body message put should be status: "update profile success"

  @Timesync @NegativeCase
  Scenario: As an admin can't update employee without token
    Given PUT update employee without token data image, id 19, name "Kozuki Momonosuke", birth_of_date "2002-11-23", email "", gender "Male", position "Shogun Wano", phone "", address "Bandung", password ""
    When Send request PUT update employee
    Then Should return status code 400
    And Response body message put should be status: "missing or malformed jwt"