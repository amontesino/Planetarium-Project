package com.revature.step;

import static com.revature.TestRunner.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddSteps {
    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginPage.enterUsername("Batman");
        loginPage.enterPassword("Iamthenight1939");
        loginPage.clickLoginButton();
    }

    @When("the user provides {string} in the name field")
    public void theUserProvidesInTheNameField(String name) {
        if (planetariumPage.checkType().equals("planet")) {
            planetariumPage.inputPlanetName(name);
        } else if (planetariumPage.checkType().equals("moon")) {
            planetariumPage.inputMoonName(name);
        }
    }

    @And("the user provides {string} into the file selection")
    public void theUserProvidesIntoTheFileSelection(String file) {
        if (planetariumPage.checkType().equals("planet")) {
            planetariumPage.inputPlanetImage(file);
        } else if (planetariumPage.checkType().equals("moon")) {
            planetariumPage.inputMoonImage(file);
        }
    }

    @Then("a planet should appear in the list")
    public void aPlanetShouldAppearInTheList() {

    }

    @When("the user chooses {string} between moon and planet")
    public void theUserChoosesBetweenMoonAndPlanet(String type) {
        planetariumPage.selectType(type);
    }

    @And("the user provides {string} if the body is a moon")
    public void theUserProvidesIfTheBodyIsAMoon(String id) {
        if (planetariumPage.checkType().equals("moon")) {
            planetariumPage.inputOrbitedPlanet(id);
        }
    }

    @Then("a planet\\/moon will not appear in the list")
    public void aPlanetMoonWillNotAppearInTheList() {
    }
}
