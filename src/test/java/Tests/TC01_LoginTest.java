package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Utilities.*;
import org.testng.annotations.*;

import java.io.File;

import static Factories.DriverFactory.getDriver;

public class TC01_LoginTest {
    File allureResultsDirectory = new File("TestOutputs/allure-results");

    @BeforeSuite
    public void beforeSuite() {
        FilesUtils.deleteFiles(allureResultsDirectory);
    }

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
        ScreenshotsUtils.takeScreenshot("test");
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.quitBrowser(getDriver());
        DriverFactory.removeDriver();
        SoftAssertUtils.softAssertAll();
    }

    @AfterClass
    public void afterClass() {
        AllureUtils.attacheLogsToAllureReport();
    }
}
