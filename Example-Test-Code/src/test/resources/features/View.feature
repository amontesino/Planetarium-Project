Feature: Viewing Planets/Moons

  # any starting steps shared between ALL scenarios/scenario outlines can be declared in a Background
  Background:
    Given  the user is logged in
    And    the user has added planets/moons

  # Happy Path Scenario
  Scenario: Planets/moons should be displayed when the user logs in
    When    the user is on the planetarium page
    Then    their planets/moons should be displayed in the UI

  # Sad Path Scenario
  Scenario Outline: Planets/moons will not display when the user logs in
    When    the user is on the planetarium page
    Then    their planets/moons will not display
