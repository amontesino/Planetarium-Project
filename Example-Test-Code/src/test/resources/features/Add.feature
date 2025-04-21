Feature: Adding Planets/Moons

  # any starting steps shared between ALL scenarios/scenario outlines can be declared in a Background
  Background:
    Given  the user is logged in

  # Happy Path Scenario
  Scenario: Valid user input data should allow for adding planets/moons to the planetarium
    When   the user provides "A" in the name field
    And    the user provides "Venus.png" into the file selection
    Then   a planet should appear in the list

  # Sad Path Scenario
  Scenario Outline: Invalid user input data should not be added to the planetarium
    When   the user chooses "<type>" between moon and planet
    And    the user provides "<name>" in the name field
    And    the user provides "<moon-id>" if the body is a moon
    And    the user provides "<file>" into the file selection
    Then   a planet/moon will not appear in the list
    And    an alert should appear saying "Invalid data!"

  Examples:
    |type   |name                           |file      |moon-id|
    |planet |                               |Planet.mp3|       |
    |planet |Planetnamewith31characterssssss|Planet.mp3|       |
    |planet |$^&*                           |Planet.mp3|       |
    |moon   |Moonnamewith31characterssssssss|Planet.mp3|1      |
    |moon   |ValidmoonwithinvalidID         |Moon.png  |2      |
