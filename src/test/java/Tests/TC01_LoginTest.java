package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Utilities.JsonUtils;
import Utilities.LogsUtils;
import Utilities.PropertiesUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC01_LoginTest {
    DriverFactory driver;
    JsonUtils loginTestData;

    @Test
    public void loginWithValidAdminCredentialsTC() {
        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.username"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .assertLoginWithValidAdminCredentials();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
    }

    @Parameters({"browser", "platformName"})
    @BeforeMethod
    public void beforeMethod(@Optional("Chrome") String browser, @Optional("Windows") String platformName) {
        LogsUtils.debug(browser);
        if (PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("RemoteGrid")) {
            driver = new DriverFactory(browser, platformName
                    , PropertiesUtils.getPropertyValue("GridUrl"));
        } else {
            driver = new DriverFactory(browser);
        }
    }

    @AfterMethod
    public void afterMethod() {
        driver.browserUtils().quitBrowser();
        DriverFactory.removeDriver();
    }
}
