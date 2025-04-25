Feature: Adding Planets/Moons

  # any starting steps shared between ALL scenarios/scenario outlines can be declared in a Background
  Background:
    Given  the user is logged in

  # Happy Path Scenario
  Scenario Outline: Valid user input data should allow for adding planets/moons to the planetarium
    When   the user chooses "<type>" between moon and planet
    And    the user provides "<name>" in the name field
    And    the user provides "<moon-id>" if the body is a moon
    And    the user provides "<file>" into the file selection
    And    the user clicks the submit button
    Then   a planet/moon should appear in the list

  Examples:

    |type   |name                           |file      |moon-id|
    |moon   |Zoozve                         |Zoozve.png|1      |
    |moon   |B                              |          |1      |
    |moon   |Moonnamewith30charactersssssss |          |1      |
    |planet |Venus                          |Venus.png |       |
    |planet |Planetnamewith30charactersssss |          |       |
    |planet |A                              |          |       |

  # Sad Path Scenario
  Scenario Outline: Invalid user input data should not be added to the planetarium
    When   the user chooses "<type>" between moon and planet
    And    the user provides "<name>" in the name field
    And    the user provides "<moon-id>" if the body is a moon
    And    the user provides "<file>" into the file selection
    And    the user clicks the submit button
    Then   an alert should appear saying "<message>"
    And    a planet/moon will not appear in the list

  Examples:
    |type   |name                           |file      |moon-id|message                    |
    |planet |                               |          |       |Invalid planet name        |
    |planet |Planetnamewith31characterssssss|          |       |Invalid planet name        |
    |planet |$^&*                           |          |       |Invalid planet name        |
    |planet |Saturn                         |Planet.mp3|       |Invalid file type          |
    |moon   |Moonnamewith31characterssssssss|          |1      |Invalid moon name          |
    |moon   |ValidmoonwithinvalidID         |Moon.png  |10     |Invalid planet ID          |
