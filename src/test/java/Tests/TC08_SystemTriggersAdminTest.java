package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P08_SystemTriggersAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC08_SystemTriggersAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils systemTriggersTestData;

    @Test
    public void validSystemTriggersTC() {
        String systemTriggerName = systemTriggersTestData.getJsonData("addNewSystemTrigger.systemTriggerName") + TimestampUtils.getTimestamp();
        String orderStatus = systemTriggersTestData.getJsonData("addNewSystemTrigger.orderStatus");
        String orderControl = systemTriggersTestData.getJsonData("addNewSystemTrigger.orderControl");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnSystemSettingsButton()
                .clickOnSystemTriggersButton()
                .clickOnAddSystemTriggersButton()
                .enterSystemTriggerName(systemTriggerName)
                .selectMessageType()
                .enterOrderStatus(orderStatus)
                .enterOrderControl(orderControl)
                .selectSystemAction()
                .selectAvailableActions()
                .clickOnSaveButton()
                .assertVisibilityOfSystemTriggerAddedAlert();

        new P08_SystemTriggersAdminPage(driver)
                .searchForSystemTriggerByName(systemTriggerName)
                .clickOnEditButton(systemTriggerName)
                .clickOnSaveButton()
                .assertVisibilityOfSystemTriggerEditedAlert();

        new P08_SystemTriggersAdminPage(driver)
                .searchForSystemTriggerByName(systemTriggerName)
                .clickOnDeleteButton(systemTriggerName)
                .clickOnYesButton()
                .assertVisibilityOfSystemTriggerDeletedAlert();
    }

    @Test
    public void invalidSystemTriggersTC() {
        String systemTriggerName = systemTriggersTestData.getJsonData("addNewSystemTrigger.systemTriggerName") + TimestampUtils.getTimestamp();
        String orderStatus = systemTriggersTestData.getJsonData("addNewSystemTrigger.orderStatus");
        String orderControl = systemTriggersTestData.getJsonData("addNewSystemTrigger.orderControl");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnSystemSettingsButton()
                .clickOnSystemTriggersButton()
                .clickOnAddSystemTriggersButton()
                .selectMessageType()
                .enterOrderStatus(orderStatus)
                .enterOrderControl(orderControl)
                .selectSystemAction()
                .selectAvailableActions()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyNameFieldMessage();

        new P08_SystemTriggersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddSystemTriggersButton()
                .enterSystemTriggerName(systemTriggerName)
                .enterOrderStatus(orderStatus)
                .enterOrderControl(orderControl)
                .selectSystemAction()
                .selectAvailableActions()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyMessageTypeFieldMessage();

        new P08_SystemTriggersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddSystemTriggersButton()
                .enterSystemTriggerName(systemTriggerName)
                .selectMessageType()
                .enterOrderControl(orderControl)
                .selectSystemAction()
                .selectAvailableActions()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyOrderStatusFieldMessage();

        new P08_SystemTriggersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddSystemTriggersButton()
                .enterSystemTriggerName(systemTriggerName)
                .selectMessageType()
                .enterOrderStatus(orderStatus)
                .selectSystemAction()
                .selectAvailableActions()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyOrderControlFieldMessage();

        new P08_SystemTriggersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddSystemTriggersButton()
                .enterSystemTriggerName(systemTriggerName)
                .selectMessageType()
                .enterOrderStatus(orderStatus)
                .enterOrderControl(orderControl)
                .selectAvailableActions()
                .clickOnSaveButton()
                .assertVisibilityOfEmptySystemActionFieldMessage();

        new P08_SystemTriggersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddSystemTriggersButton()
                .enterSystemTriggerName(systemTriggerName)
                .selectMessageType()
                .enterOrderStatus(orderStatus)
                .enterOrderControl(orderControl)
                .selectSystemAction()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyAvailableActionsFieldMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        systemTriggersTestData = new JsonUtils("SystemTriggersTestData");
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