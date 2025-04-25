package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlanetariumPage extends ParentPOM {

    private WebDriverWait alertWait;

    // User choice between planet/moon
    @FindBy(id = "locationSelect")
    private WebElement typeSelect;

    public PlanetariumPage(WebDriver driver, String title) {
        super(driver, title);
        alertWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

     public void selectType(String type) {
        Select select = new Select(typeSelect);
        select.selectByValue(type);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        if (type.equals("moon")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("moonNameInput")));
        } else if (type.equals("planet")) {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("planetNameInput")));
        }
     }

     public String checkType() {
        Select select = new Select(typeSelect);
        return select.getFirstSelectedOption().getDomAttribute("value");
     }

     public void enterNameDelete(String input) {
        WebElement deleteInput = driver.findElement(By.id("deleteInput"));
        deleteInput.sendKeys(input);
     }

     public void submitDelete() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteButton")));
         deleteButton.click();
     }

     public void inputPlanetName(String input) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement planetNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("planetNameInput")));
         planetNameInput.sendKeys(input);
     }

     public void inputPlanetImage(String image) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement planetImageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("planetImageInput")));
         if (!image.isBlank()) {
             planetImageInput.sendKeys(
                     "C:\\Users\\midas\\Documents\\Planetarium Project\\Example-Test-Code\\src\\test\\resources\\files\\"
                             + image
             );
         }
     }

     public void inputMoonName(String input) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement moonNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moonNameInput")));
         moonNameInput.sendKeys(input);
     }

     public void inputOrbitedPlanet(String input) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement orbitedPlanetInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orbitedPlanetInput")));
         orbitedPlanetInput.sendKeys(input);
     }

    public void inputMoonImage(String image) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement moonImageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moonImageInput")));
        moonImageInput.sendKeys(
                "C:\\Users\\midas\\Documents\\Planetarium Project\\Example-Test-Code\\src\\test\\resources\\files\\"
                        + image
        );
    }

    public void submitPlanetOrMoonRequest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputContainer")));
        WebElement submitButton = inputContainer.findElement(By.className("submit-button"));
        submitButton.click();
    }

    public void waitForAlert() {
        alertWait.until(ExpectedConditions.alertIsPresent());
    }
}
