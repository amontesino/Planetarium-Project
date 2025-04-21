Feature: Delete Planets/Moons

  # any starting steps shared between ALL scenarios/scenario outlines can be declared in a Background
  Background:
    Given  the user is logged in

  # Happy Path Scenario
  Scenario: Existing planet/moon names should be deleted and removed from the UI when requested
    When   the user provides "Earth" in the deletion field
    And    the user clicks the delete button
    Then   the existing planet/moon should be deleted from the planetarium

  # Sad Path Scenario
  Scenario: Non-existing planet/moon names should prompt the user when deletion is requested
    When   the user provides "Saturn" in the deletion field
    And    the user clicks the delete button
    Then   an alert should appear saying "Celestial body does not exist!"