package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Utilities.JsonUtils;
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
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();
    }

    @Test
    public void loginWithInvalidAdminCredentialsTC() {
        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("invalidLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("invalidLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithInValidCredentials();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new DriverFactory(PropertiesUtils.getPropertyValue("browser"));
    }

    @AfterMethod
    public void afterMethod() {
        driver.browserUtils().quitBrowser();
        DriverFactory.removeDriver();
    }
}
