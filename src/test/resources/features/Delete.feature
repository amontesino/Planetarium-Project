Feature: Delete Planets/Moons

  # any starting steps shared between ALL scenarios/scenario outlines can be declared in a Background
  Background:
    Given  the user is logged in

  # Happy Path Scenario
  Scenario Outline: Existing planet/moon names should be deleted and removed from the UI when requested
    When   the user chooses "<type>" between moon and planet
    And    the user provides "<name>" in the deletion field
    And    the user clicks the delete button
    Then   the existing planet/moon should be deleted from the planetarium

  Examples:
    |type  |name |
    |moon  |Luna |
    |planet|Earth|

  # Sad Path Scenario
  Scenario Outline: Non-existing planet/moon names should prompt the user when deletion is requested
    When   the user chooses "<type>" between moon and planet
    And    the user provides "<name>" in the deletion field
    And    the user clicks the delete button
    Then   an alert should appear saying "<message>"

  Examples:
    |type   |name  |message            |
    |moon   |Titan |Invalid moon name  |
    |planet |Saturn|Invalid planet name|
