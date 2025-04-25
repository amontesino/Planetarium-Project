package com.revature.step;

import static com.revature.TestRunner.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteSteps {
    @And("the user provides {string} in the deletion field")
    public void theUserProvidesInTheDeletionField(String name) {
        planetariumPage.enterNameDelete(name);
    }

    @And("the user clicks the delete button")
    public void theUserClicksTheDeleteButton() {
        planetariumPage.submitDelete();
    }

    @Then("the existing planet\\/moon should be deleted from the planetarium")
    public void theExistingPlanetMoonShouldBeDeletedFromThePlanetarium() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        if (planetariumPage.checkType().equals("moon")) {
            explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 2));
            Assert.assertThrows(NoSuchElementException.class, () -> driver.findElement(By.xpath(
                    "//tr[3]")));
        } else if (planetariumPage.checkType().equals("planet")) {
            explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), 1));
            Assert.assertThrows(NoSuchElementException.class, () -> driver.findElement(By.xpath(
                    "//tr[2]")));
        }
    }
}
