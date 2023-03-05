Feature: Delete Employees Admin Timesync API
  @Timesync @PositiveCase
  Scenario: Admin can delete account employee
    Given DELETE employees by admin with id 90
    When Send request delete employee
    Then Should return status code 200
    And Response body message delete should be: "success deactivate employee profile"