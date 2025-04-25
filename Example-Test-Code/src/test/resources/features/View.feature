Feature: Viewing Planets/Moons

  # Happy Path Scenario
  Scenario: Planets/moons should be displayed when the user logs in
    Given   the user is on the login page
    When    the user provides username "Batman" while logging in
    And     the user provides password "Iamthenight1939" while logging in
    And     the user clicks the login button
    Then    the user should be redirected to the Planetarium page
    And     their planets/moons should be displayed in the UI
    And     the creation inputs should be visible
    And     the greeting should be visible