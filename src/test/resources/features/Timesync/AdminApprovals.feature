Feature: Approvals Admin Timesync API

  @Timesync @PositiveCase
  Scenario: Admin can see approvals from employees
    Given GET approvals employees with role admin
    When Send request get approvals employees
    Then Should return status code 200
    And Response body message get approvals should be status: "success show all employee approval record"
    And Validate json schema get approvals

  @Timesync @PositiveCase
  Scenario Outline: Admin can see approvals with id
    Given Get approvals with ID <id>
    When Send request get approvals employees with ID
    Then Should return status code 200
    And Response body message get approvals should be status: "success get approval detail"
    And Validate json schema approvals with id
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
      | 4  |
      | 5  |

  @Timesync @NegativeCase
  Scenario: Admin can't see approvals without token
    Given Get admin approvals without token
    When Send request get approvals employees
    Then Should return status code 400
    And Response body message approvals without token should be status: "missing or malformed jwt"

#PUT
  
  @Timesync @PositiveCase
  Scenario Outline: Admin can update approvals request from employees
    Given PUT update approvals employee ID <id> with approval status "<status>"
    When Send request update approvals employees
    Then Should return status code 200
    And Response body message update approvals should be: "success approve employee permission"
    And Validate json schema update approvals employees
    Examples:
      | id | status   |
      | 80 | Approved |
      | 81 | Rejected |
      | 82 | Approved |
      | 83 | Approved |
      | 84 | Rejected |


  @Timesync @NegativeCase
  Scenario Outline: Admin can't update approvals request from employees unknown ID
    Given PUT update approvals employee ID <id> with approval status "<status>"
    When Send request update approvals employees
    Then Should return status code 500
    And Response body message update approvals another case should be: "unable to process data"
    Examples:
      | id  | status   |
      | 995 | Approved |
      | 996 | Rejected |
      | 997 | Approved |
      | 998 | Approved |
      | 999 | Rejected |