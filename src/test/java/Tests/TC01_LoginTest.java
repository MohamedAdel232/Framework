package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Utilities.*;
import org.testng.annotations.*;

import java.io.File;

import static Factories.DriverFactory.getDriver;

public class TC01_LoginTest {
    File allureResultsDirectory = new File("TestOutputs/allure-results");
    JsonUtils jsonData;

    @BeforeSuite
    public void beforeSuite() {
        PropertiesUtils.loadProperties();
        FilesUtils.deleteFiles(allureResultsDirectory);
        jsonData = new JsonUtils("TestData");
    }

    @BeforeMethod
    public void setup() {
        DriverFactory.createDriver(PropertiesUtils.getPropertyValue("browser"));
    }

    @Test
    public void loginWithValidCredentialsTC() {
        new P01_LoginPage(getDriver())
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(jsonData.getJsonData("loginCredentials.username"))
                .enterPassword(jsonData.getJsonData("loginCredentials.password"))
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
