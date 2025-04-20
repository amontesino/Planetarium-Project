package com.revature.step;

import static com.revature.TestRunner.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    @When("the user provides username {string} while logging in")
    public void the_user_provides_username_while_logging_in(String username) {
        loginPage.enterUsername(username);
    }

    @And("the user provides password {string} while logging in")
    public void the_user_provides_password_while_logging_in(String password) {
        loginPage.enterPassword(password);
    }

//    @And("the username and password match an existing record")
//    public void the_username_and_password_match_an_existing_record() {
//
//    }

    @And("the user should be redirected to the Planetarium page")
    public void the_user_should_be_redirected_to_the_planetarium_page() {
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
