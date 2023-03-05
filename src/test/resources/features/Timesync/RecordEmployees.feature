Feature: Record Employees by Admin Timesync API
  @Timesync @PositiveCase
  Scenario Outline: Admin can see record all employees
    Given GET record employees with id <id>, date from "<df>", and date to "<dt>"
    When Send request get record by admin
    Then Should return status code 200
    And Response body message get record should be: "success show employee attendance record"
    And Validate json schema get record employees
    Examples:
      | id | df         | dt         |
      | 2  | 2023-01-01 | 2023-02-15 |
      | 3  | 2023-01-01 | 2023-02-15 |
      | 4  | 2023-01-01 | 2023-02-15 |
      | 5  | 2023-01-01 | 2023-02-15 |
      | 6  | 2023-01-01 | 2023-02-15 |
      | 7  | 2023-01-01 | 2023-02-15 |
      | 8  | 2023-01-01 | 2023-02-15 |
      | 9  | 2023-01-01 | 2023-02-15 |

  @Timesync @NegativeCase
  Scenario Outline: Admin can't see record invalid param
    Given GET record employees invalid param with id <id>, date from "<df>", and date to "<dt>"
    When Send request get record by admin
    Then Should return status code 520
    Examples:
      | id | df         | dt         |
      | 2  | 2023-01-01 | 2023-02-15 |
      | 3  | 2023-01-01 | 2023-02-15 |
      | 4  | 2023-01-01 | 2023-02-15 |
      | 5  | 2023-01-01 | 2023-02-15 |
      | 6  | 2023-01-01 | 2023-02-15 |
      | 7  | 2023-01-01 | 2023-02-15 |
      | 8  | 2023-01-01 | 2023-02-15 |
      | 9  | 2023-01-01 | 2023-02-15 |
