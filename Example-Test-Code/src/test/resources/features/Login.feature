Feature: User Login

    Background:
        Given the user is on the login page

    Scenario: Valid credential data should allow for registering with the Planetarium
        When    the user provides an existing username
        And     the user provides an existing password
        And     the username and password match an existing combination
        Then    an alert should appear saying "Login successul"
        And     the user should be redirected to the Planetarium page

    Scenario Outline: Invalid credential data should not allow for logging into the Planetarium
        When    the user provides username "<username>" while logging in
        And     the user provides password "<password>" while logging in
        Then an alert should appear saying "<message>"
        And the user should remain on the login page

    Examples:
        |username|password|message          |
        |Batman  |Bobb1   |Invalid password |
        |Robin   |Bobb1   |Account not found|