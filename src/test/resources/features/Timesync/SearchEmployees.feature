Feature: Search Employees Admin Timesync API
  @Timesync @PositiveCase
  Scenario Outline: Admin can search employees by name
    Given Get search employee with name or nip "<name>"
    When Send request search employee
    Then Should return status code 200
    And Response body message search should be: "searching success"
    And Validate json schema get search employee
    Examples:
      | name    |
      | Alif    |
      | Fauzi   |
      | Yudha   |
      | Zain    |
      | Febrian |
      | Amel    |
      | Dona    |
      | Rico    |

  @Timesync @PositiveCase
  Scenario Outline: Admin can search employees by nip
    Given Get search employee with name or nip "<nip>"
    When Send request search employee
    Then Should return status code 200
    And Response body message search should be: "searching success"
    And Validate json schema get search employee
    Examples:
      | nip   |
      | 23001 |
      | 23002 |
      | 23003 |
      | 23004 |
      | 23005 |
      | 23006 |
      | 23007 |
      | 23008 |

  @Timesync @NegativeCase
  Scenario: Admin can't search employees
    Given Get search employee without query param
    When Send request search employee
    Then Should return status code 400
    And Response body message error "nothing to search"
    And Validate json schema get search without query param

  @Timesync @NegativeCase
  Scenario Outline: Admin can't access search with unauthorized token
    Given Get search employee unauthorized with name or nip "<nip>"
    When Send request search employee
    Then Should return status code 400
    And Response body message unauthorized "access denied"
    And Validate json schema get search unauthorized
    Examples:
      | nip   |
      | 23001 |
      | 23002 |
      | 23003 |
      | 23004 |
      | 23005 |
      | 23006 |
      | 23007 |
      | 23008 |

  @Timesync @NegativeCase
  Scenario Outline: Admin can't search employees by name unregistered
    Given Get search employee with name or nip "<name>"
    When Send request search employee
    Then Should return status code 400
    And Response body message error search: "user not found"
    And Validate json schema get search user not found
    Examples:
      | name    |
      | Panjul  |
      | Pebot   |
      | Ombot   |
      | Lucinta |
      | Dadang  |
      | Ateng   |
      | Shibuya |
      | Deden   |