Feature: Delete Announcements Employees Admin Timesync API
  @Timesync @PositiveCase
  Scenario: Admin can delete announcements employee
    Given DELETE announcements by admin with id 139
    When Send request delete announcements
    Then Should return status code 200
    And Response body message delete should be: "success delete announcement"