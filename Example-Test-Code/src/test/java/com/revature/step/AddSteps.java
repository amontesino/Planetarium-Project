package com.revature.step;

import static com.revature.TestRunner.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddSteps {
    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginPage.goToLoginPage();
        loginPage.enterUsername("Batman");
        loginPage.enterPassword("Iamthenight1939");
        loginPage.clickLoginButton();
    }

    @When("the user provides {string} in the name field")
    public void theUserProvidesInTheNameField(String name) {
        String type = planetariumPage.checkType();
        if (type.equals("planet")) {
            planetariumPage.inputPlanetName(name);
        } else if (type.equals("moon")) {
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

    @Then("a planet\\/moon should appear in the list")
    public void aPlanetOrMoonShouldAppearInTheList() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"), 1));
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        Assert.assertTrue(rows.size() > 3);
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
    public void aPlanetOrMoonWillNotAppearInTheList() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertThrows(NoSuchElementException.class, () -> driver.findElement(By.xpath("//tr[4]")).isDisplayed());
    }

    @And("the user clicks the submit button")
    public void theUserClicksTheSubmitButton() {
        planetariumPage.submitPlanetOrMoonRequest();
    }
}
