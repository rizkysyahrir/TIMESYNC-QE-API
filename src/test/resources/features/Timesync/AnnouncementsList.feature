Feature: Announcements List for Employees
  @Timesync @PositiveCase
  Scenario: Admin can get list announcements
    Given GET list announcements by admin
    When Send request get list announcements
    Then Should return status code 200
    And Validate json schema all list announcements

  @Timesync @PositiveCase
  Scenario Outline: Admin can get announcements by id
    Given GET Announcements by id <id>
    When Send request get announcements by id
    Then Should return status code 200
    And Response body message get should be status: "success get announcement details"
    And Validate json schema announcements by id
    Examples:
      | id  |
      | 182 |
      | 183 |
      | 184 |
      | 185 |
      | 186 |
      | 187 |

  @Timesync @NegativeCase
  Scenario Outline: Admin can't get announcements unregistered id
    Given GET Announcements by id <id>
    When Send request get announcements by id
    Then Should return status code 404
    And Response body message get should be status: "announcement not found"
    And Validate json schema announcements unregistered id
    Examples:
      | id  |
      | 300 |
      | 301 |
      | 302 |
      | 303 |
      | 304 |
      | 305 |