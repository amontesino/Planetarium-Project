package com.revature.step;

import static com.revature.TestRunner.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteSteps {
    @When("the user provides {string} in the deletion field")
    public void theUserProvidesInTheDeletionField(String name) {
        planetariumPage.enterNameDelete(name);
    }

    @And("the user clicks the delete button")
    public void theUserClicksTheDeleteButton() {
        planetariumPage.submitDelete();
    }

    @Then("the existing planet\\/moon should be deleted from the planetarium")
    public void theExistingPlanetMoonShouldBeDeletedFromThePlanetarium() {
    }
}
