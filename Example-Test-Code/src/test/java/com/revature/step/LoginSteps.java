package com.revature.step;

import static com.revature.TestRunner.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.time.Duration;

public class LoginSteps {

    @When("the user provides username {string} while logging in")
    public void the_user_provides_username_while_logging_in(String username) {
        loginPage.enterUsername(username);
    }

    @And("the user provides password {string} while logging in")
    public void the_user_provides_password_while_logging_in(String password) {
        loginPage.enterPassword(password);
    }

    @Then("the user should be redirected to the Planetarium page")
    public void the_user_should_be_redirected_to_the_planetarium_page() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertEquals("Home", driver.getTitle());
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @And("the user should remain on the login page")
    public void the_user_should_remain_on_the_login_page() {
        loginPage.goToLoginPage();
    }
}
