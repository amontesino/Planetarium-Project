Feature: User Login

  #any starting steps shared between ALL scenarios/scenario outlines can be declared in a Background
  Background:
    Given the user is on the login page

  # Happy Path Scenario
  Scenario: Valid credential data should allow for logging into the Planetarium
    When   the user provides username "Batman" while logging in
    And    the user provides password "Iamthenight1939" while logging in
#    And    the username and password match an existing record
    Then   an alert should appear saying "Logged in successfully"
    And    the user should be redirected to the Planetarium page

  # Sad Path Scenario
  Scenario Outline: Invalid credential data should not allow for logging into the Planetarium
    When   the user provides username "<username>" while logging in
    And    the user provides password "<password>" while logging in
    When   the user clicks the login button
    Then   an alert should appear saying "<message>"
    And    the user should remain on the login page

    Examples:
      |username|password|message|
      |Batman  |Bobb1   |Invalid password    |
      |bobb    |Bobb1   |Account not found   |
      |Robin!%?|Bobb1   |Account not found   |
      |3obin   |Bobb1   |Account not found   |
      |Robin   |Bob3    |Account not found   |
      |Robin   |bobby   |Account not found   |
      |Robin   |Bobby   |Account not found   |
      |Robin   |bobb3   |Account not found   |
      |Robin   |BOBB3   |Account not found   |
      |Robin   |Bobb3!? |Account not found   |
      |Robin   |3obbY   |Account not found   |