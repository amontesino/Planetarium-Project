Feature: User Login

  #any starting steps shared between ALL scenarios/scenario outlines can be declared in a Background
  Background:
    Given the user is on the login page

  # Happy Path Scenario
  Scenario: Valid credential data should allow for logging into the Planetarium
    When   the user provides username "Batman" while logging in
    And    the user provides password "Iamthenight1939" while logging in
    When   the user clicks the login button
    Then   the user should be redirected to the Planetarium page

  # Sad Path Scenario
  Scenario Outline: Invalid credential data should not allow for logging into the Planetarium
    When   the user provides username "<username>" while logging in
    And    the user provides password "<password>" while logging in
    When   the user clicks the login button
    Then   an alert should appear saying "<message>"
    And    the user should remain on the login page

    Examples:
      |username|password|message|
      |Batman  |Bobb1   |Invalid credentials    |
      |bobb    |Bobb1   |Invalid credentials    |
      |Robin!%?|Bobb1   |Invalid credentials    |
      |3obin   |Bobb1   |Invalid credentials    |
      |Robin   |Bob3    |Invalid credentials    |
      |Robin   |bobby   |Invalid credentials    |
      |Robin   |Bobby   |Invalid credentials    |
      |Robin   |bobb3   |Invalid credentials    |
      |Robin   |BOBB3   |Invalid credentials    |
      |Robin   |Bobb3!? |Invalid credentials    |
      |Robin   |3obbY   |Invalid credentials    |