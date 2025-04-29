package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Utilities.BrowserUtils;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import org.testng.annotations.*;

import static Factories.DriverFactory.getDriver;

@Listeners(TestNGListeners.class)
public class TC01_LoginTest {
    JsonUtils jsonData;

    @Test
    public void loginWithValidCredentialsTC() {
        new P01_LoginPage(getDriver())
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(jsonData.getJsonData("loginCredentials.username"))
                .enterPassword(jsonData.getJsonData("loginCredentials.password"))
                .clickLoginButton()
                .assertLoginWithValidCredentials();
    }

    @BeforeClass
    public void beforeClass() {
        jsonData = new JsonUtils("TestData");
    }

    @BeforeMethod
    public void setup() {
        DriverFactory.createDriver(PropertiesUtils.getPropertyValue("browser"));
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.quitBrowser(getDriver());
        DriverFactory.removeDriver();

    }
}
