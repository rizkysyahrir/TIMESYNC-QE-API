Feature: Company Profiles Admin Timesync API
  @Timesync @PositiveCase
  Scenario: Admin can see company profiles
    Given GET Company profile by admin
    When Send request get company profiles
    Then Should return status code 200
    And Response body message get should be status: "success show company profile"
    And Validate json schema get company profiles

  @Timesync @PositiveCase
  Scenario Outline:  Admin can update company profile
    Given Update company profile with image, set company_name "<name>", company_email "<email>",description "<desc>",company_address "<address>", company_phone "<phone>", sosmed "<sosmed>"
    When Send request update company profile
    Then Should return status code 200
    And Response body message put should be status: "success update company profile"
    Examples:
      | name         | email              | desc                                                                               | address | phone           | sosmed |
      |              |                    |                                                                                    | Jakarta | +6221-9923-7090 |        |
      | PT Time Sync | timesync@gmail.com |                                                                                    |         |                 |        |
      |              |                    | We are a company that moves in technology and software industry and software house |         |                 |        |

  @Timesync @PositiveCase
  Scenario: Admin can't see company profiles with unauthorized token
    Given GET Company profile with unauthorized
    When Send request get company profiles unauthorized
    Then Should return status code 401
    And Response body message get should be status: "invalid or expired jwt"
    And Validate json schema get company profiles unauthorized token