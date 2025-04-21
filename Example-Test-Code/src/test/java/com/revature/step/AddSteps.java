package com.revature.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddSteps {
    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
    }

    @When("the user provides {string} in the name field")
    public void theUserProvidesInTheNameField(String arg0) {
    }

    @And("the user provides {string} into the file selection")
    public void theUserProvidesIntoTheFileSelection(String arg0) {
    }

    @Then("a planet should appear in the list")
    public void aPlanetShouldAppearInTheList() {
    }

    @When("the user chooses {string} between moon and planet")
    public void theUserChoosesBetweenMoonAndPlanet(String arg0) {
    }

    @And("the user provides {string} if the body is a moon")
    public void theUserProvidesIfTheBodyIsAMoon(String arg0) {
    }

    @Then("a planet\\/moon will not appear in the list")
    public void aPlanetMoonWillNotAppearInTheList() {
    }
}
