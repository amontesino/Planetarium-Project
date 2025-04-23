package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlanetariumPage extends ParentPOM {

    private WebDriverWait alertwait;

    // User choice between planet/moon
    @FindBy(id = "locationSelect")
    private WebElement typeSelect;

    // Delete functions
    @FindBy(id = "deleteInput")
    private WebElement deleteInput;
    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    // Planet input
    @FindBy(id = "planetNameInput")
    private WebElement planetInput;
    @FindBy(id = "planetImageInput")
    private WebElement planetImage;

    // Moon input
    @FindBy(id = "moonNameInput")
    private WebElement moonInput;
    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanet;
    @FindBy(id = "moonImageInput")
    private WebElement moonImage;

    // Submit button
    @FindBy(className = "submit-button")
    private WebElement submitButton;

    public PlanetariumPage(WebDriver driver, String title) {
        super(driver, title);
        alertwait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

     public void selectType(String type) {
        Select select = new Select(typeSelect);
        select.selectByValue(type);
     }

     public String checkType() {
        return typeSelect.getText();
     }

     public void enterNameDelete(String input) {
        deleteInput.sendKeys(input);
     }

     public void submitDelete() {
        deleteButton.click();
     }

     public void inputPlanetName(String input) {
        planetInput.sendKeys(input);
     }

     public void inputPlanetImage(String image) {
        planetImage.sendKeys(
            "C:\\Users\\midas\\Documents\\Planetarium Project\\Example-Test-Code\\src\\test\\resources\\files\\"
                + image
        );
     }

     public void inputMoonName(String input) {
        moonInput.sendKeys(input);
     }

     public void inputOrbitedPlanet(String input) {
        orbitedPlanet.sendKeys(input);
     }

    public void inputMoonImage(String image) {
        moonImage.sendKeys(
                "C:\\Users\\midas\\Documents\\Planetarium Project\\Example-Test-Code\\src\\test\\resources\\files\\"
                        + image
        );
    }

    public void submitPlanetOrMoonRequest() {
        submitButton.click();
    }
}
