package com.revature.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {

    /*
        ########## Shared Steps ##########
     */
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user clicks the register link")
    public void the_user_clicks_the_register_link() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    /*
        Note the step syntax below does not match 100% with what we have written in the Feature file.
        Cucumber is able to pass data to our glue methods at runtime, which can simplify the steps we
        write and reduce the number of overall associated methods we need to implement
     */
    @Then("an alert should appear saying {string}")
    public void an_alert_should_appear_saying(String expectedMessage) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    /*
        ########## Happy Path Steps ##########
     */

    @When("the user provides a valid username")
    public void the_user_provides_a_valid_username() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("the user provides a valid password")
    public void the_user_provides_a_valid_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @And("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    /*
        ########## Sad Path Steps ##########
     */

    @When("the user provides username {string} while registering")
    public void the_user_provides_username_while_registering(String username) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user provides password {string} while registering")
    public void the_user_provides_password_while_registering(String password) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should remain on the register page")
    public void the_user_should_remain_on_the_register_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
