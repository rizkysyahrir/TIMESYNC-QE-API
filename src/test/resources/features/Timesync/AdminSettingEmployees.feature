Feature: Setting Employees Admin Timesync API
  @Timesync @PositiveCase
  Scenario: As an admin can see setting employees
    Given GET setting employees by admin
    When Send request get setting employees
    Then Should return status code 200
    And Response body message get should be status: "success show setting"
    And Validate json schema get setting employees

  @Timesync @PositiveCase
  Scenario Outline: As an admin can update setting employees
    Given PUT Admin update setting employees working hour start "<start>", working hour end "<end>", tolerance "<tolerance>", annual leave "<annual_leave>"
    When Send request update setting employees
    Then Should return status code 200
    And Response body message update setting should be status: "success change setting"
    And Validate json schema update setting
    Examples:
      | start | end   | tolerance | annual_leave |
      | 08:00 | 16:00 | 30        | 14           |