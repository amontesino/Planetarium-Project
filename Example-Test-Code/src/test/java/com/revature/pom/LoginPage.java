package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPOM {

    // note: make this a reference to your login page
    private String url = String.format("http://%s/", System.getenv("PLANETARIUM_URL"));

    @FindBy(tagName = "a")
    private WebElement registrationLink;
    @FindBy(id = "usernameInput")
    private WebElement usernameInput;
    @FindBy(id = "passwordInput")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[3]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver, String title) {
        super(driver, title);
    }

    public void goToLoginPage() {
        driver.get(url);
    }

    public void clickRegistrationLink() {
        registrationLink.click();
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    // can use this to validate we have returned to the login page after a successful registration
    public String getTitle() {
        return title;
    }
}
