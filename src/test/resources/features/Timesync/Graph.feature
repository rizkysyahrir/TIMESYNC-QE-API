Feature: Graph Employees Timesync API
  @Timesync @PositiveCase
  Scenario Outline: Admin can see graph mtwh employees
    Given GET graph by admin with type "<type>", year_month "<ym>", and limit "<lim>"
    When Send request get graph
    Then Should return status code 200
    And Response body message get graph should be: "success show graph data"
    And Validate json schema mtwh graph
    Examples:
      | type | ym      | lim |
      | mtwh | 2023-01 | 8   |
      | mtwh | 2023-01 | 10  |

  @Timesync @PositiveCase
  Scenario Outline: Admin can see graph mtel employees
    Given GET graph by admin with type "<type>", year_month "<ym>", and limit "<lim>"
    When Send request get graph
    Then Should return status code 200
    And Response body message get graph should be: "success show graph data"
    And Validate json schema mtel graph
    Examples:
      | type | ym      | lim |
      | mtel | 2023-01 | 8   |
      | mtel | 2023-02 | 8   |

  @Timesync @NegativeCase
  Scenario: Admin can't see graph employees wrong parameter
    Given GET graph by admin with type "mtwh?limit=8?year_month=2023-09", year_month "", and limit ""
    When Send request get graph
    Then Should return status code 400
    And Response body message error get graph should be: "wrong type parameter"