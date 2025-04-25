package com.revature.step;

import static com.revature.TestRunner.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewSteps {

    @Then("their planets\\/moons should be displayed in the UI")
    public void theirPlanetsMoonsShouldBeDisplayedInTheUI() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        explicitWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"), 1));
        Assert.assertEquals(true, driver.findElement(By.xpath("//tr[2]")).isDisplayed());
    }

    @And("the creation inputs should be visible")
    public void theCreationInputsShouldBeVisible() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("locationSelect"))));
        Assert.assertEquals(true, driver.findElement(By.id("locationSelect")).isDisplayed());
    }

    @And("the greeting should be visible")
    public void theGreetingShouldBeVisible() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("greeting"))));
        Assert.assertEquals(true, driver.findElement(By.id("greeting")).isDisplayed());
    }
}
