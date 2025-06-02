package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P05_OrderingLocationsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC05_OrderingLocationsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils orderingLocationsTestData;

    @Test
    public void validOrderingLocationTC() throws InterruptedException {
        String orderingLocationName = orderingLocationsTestData.getJsonData("addNewOrderingLocation.orderingLocationName") + TimestampUtils.getTimestamp();
        String orderingLocationHL7Value = orderingLocationsTestData.getJsonData("addNewOrderingLocation.orderingLocationHL7Value");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnGeneralConfigButton()
                .clickOnWorklistMappingButton()
                .clickOnOrderingLocationsAdminButton()
                .clickOnAddOrderingLocationButton()
                .enterOrderingLocationName(orderingLocationName)
                .enterOrderingLocationHL7Value(orderingLocationHL7Value)
                .clickOnSaveButton()
                .assertVisibilityOfOrderingLocationAddedAlert();

        new P05_OrderingLocationsAdminPage(driver)
                .searchForOrderingLocationByName(orderingLocationName)
                .clickOnEditButton(orderingLocationName)
                .clickOnSaveButton()
                .assertVisibilityOfOrderingLocationEditedAlert();

        new P05_OrderingLocationsAdminPage(driver)
                .searchForOrderingLocationByName(orderingLocationName)
                .clickOnDeleteButton(orderingLocationName)
                .clickOnYesButton()
                .assertVisibilityOfOrderingLocationDeletedAlert();
    }

    @Test
    public void invalidOrderingLocationTC() {
        String orderingLocationName = orderingLocationsTestData.getJsonData("addNewOrderingLocation.orderingLocationName") + TimestampUtils.getTimestamp();
        String orderingLocationHL7Value = orderingLocationsTestData.getJsonData("addNewOrderingLocation.orderingLocationHL7Value");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnGeneralConfigButton()
                .clickOnWorklistMappingButton()
                .clickOnOrderingLocationsAdminButton()
                .clickOnAddOrderingLocationButton()
                .enterOrderingLocationHL7Value(orderingLocationHL7Value)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyNameFieldMessage();

        new P05_OrderingLocationsAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddOrderingLocationButton()
                .enterOrderingLocationName(orderingLocationName)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyHL7ValueFieldMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        orderingLocationsTestData = new JsonUtils("OrderingLocationsTestData");
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