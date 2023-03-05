Feature: Announcements Admin Timesync API
  @Timesync @PositiveCase
  Scenario: Admin add announcements to all employees
    Given Post admin create announcements for employee
    When Send request create announcements from employee
    Then Should return status code 201
    And Validate json schema create announce from employee

  @Timesync @PositiveCase
  Scenario Outline: Admin post announcements to employee with nip
    Given Post admin create announcements with specifications nip "<nip>", tittle "<tittle>", description "<description>"
    When Send request create announcements from employee
    Then Should return status code 201
    And Response body message post announcements should be status: "send announcement message to employee success"
    And Validate json schema create announcements with nip
    Examples:
      | nip   | tittle           | description                         |
      | 23001 | Graduate Alterra | Congratulation for you, see on top! |
      | 23002 | Graduate Alterra | Congratulation for you, see on top! |
      | 23003 | Graduate Alterra | Congratulation for you, see on top! |
      | 23004 | Graduate Alterra | Congratulation for you, see on top! |
      | 23005 | Graduate Alterra | Congratulation for you, see on top! |
      | 23006 | Graduate Alterra | Congratulation for you, see on top! |
      | 23007 | Graduate Alterra | Congratulation for you, see on top! |
      | 23008 | Graduate Alterra | Congratulation for you, see on top! |

  @Timesync @NegativeCase
  Scenario: Admin add announcements with invalid param
    Given Post admin create announcements for employee
    When Send request create announcements from employee fail
    Then Should return status code 404
    And Validate json schema create announce fail to employee
    And Response body message fail should be status: "Not Found"
