package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Utilities.BrowserUtils;
import Utilities.SoftAssertUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Factories.DriverFactory.getDriver;

public class TC01_LoginTest {
    @BeforeMethod
    public void setup() {
        DriverFactory.createDriver("edge");
    }

    @Test
    public void loginWithValidCredentialsTC() {
        new P01_LoginPage(getDriver())
                .navigateToLoginPage("https://www.saucedemo.com/")
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton()
                .assertLoginWithValidCredentials();
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.quitBrowser(getDriver());
        DriverFactory.removeDriver();
        SoftAssertUtils.softAssertAll();
    }
}
