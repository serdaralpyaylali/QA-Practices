package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        PageFactory.initElements(webDriver, this);
    }
    //Annotations
    @FindBy(css = "#username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "radius")
    private WebElement loginButton;


    // Methods
    public boolean isTitleCorrect (String expectedTitle) {
        return webDriver.getTitle().equals(expectedTitle);
    }

    public void login (String username, String password){
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }





}
