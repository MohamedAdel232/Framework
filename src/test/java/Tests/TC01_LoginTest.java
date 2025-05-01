package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.ScreenRecorderUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC01_LoginTest {
    DriverFactory driver;
    JsonUtils jsonData;

    @Test
    public void loginWithValidCredentialsTC() {
        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(jsonData.getJsonData("loginCredentials.username"))
                .enterPassword(jsonData.getJsonData("loginCredentials.password"))
                .clickLoginButton()
                .assertLoginWithValidCredentials();
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        jsonData = new JsonUtils("TestData");
    }

    @BeforeMethod
    public void setup() {
        driver = new DriverFactory(PropertiesUtils.getPropertyValue("browser"));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.browserUtils().quitBrowser();
        DriverFactory.removeDriver();
        ScreenRecorderUtils.stopRecording();
    }
}
