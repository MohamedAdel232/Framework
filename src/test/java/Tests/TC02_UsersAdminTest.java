package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC02_UsersAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils userTestData;

    @Test
    public void usersTC() {

    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        userTestData = new JsonUtils("UsersTestData");
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
