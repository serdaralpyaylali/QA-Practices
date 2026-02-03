package tests;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import utilities.Driver;

public class LoginTests {
    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;

    @BeforeTest
    public void setUp() {
        Driver.getWebDriver().get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(Driver.getWebDriver());
        secureAreaPage = new SecureAreaPage(Driver.getWebDriver());
    }

    @Test
    public void checkTitle() {
        boolean checkTitle = loginPage.isTitleCorrect("The Internet");
        Assert.assertTrue(checkTitle, "Title is incorrect");
    }

    @Test
    public void loginSuccesfully(){
        loginPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(secureAreaPage.isLoginSuccesful(),"Login is unsuccesful");
    }

    @AfterTest
    public void teardown(){
        Driver.closeWebDriver();
    }

}
