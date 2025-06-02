package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P06_PatientEligibilityAdminPage;
import Pages.P07_HL7TriggersAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC07_HL7TriggersAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils hl7TriggersTestData;

    @Test
    public void validHL7TriggersTC() {
        String hl7TriggerName = hl7TriggersTestData.getJsonData("addNewHL7Trigger.hl7TriggerName") + TimestampUtils.getTimestamp();
        String hl7TriggerEvent = hl7TriggersTestData.getJsonData("addNewHL7Trigger.hl7TriggerEvent");
        String hl7TriggerDestination = hl7TriggersTestData.getJsonData("addNewHL7Trigger.hl7TriggerDestination");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnHL7ConfigurationButton()
                .clickOnHL7TriggersButton()
                .clickOnAddHL7TriggersButton()
                .enterHL7TriggerName(hl7TriggerName)
                .selectHL7TriggerEvent(hl7TriggerEvent)
                .selectHL7TriggerDestination(hl7TriggerDestination)
                .clickOnSaveButton()
                .assertVisibilityOfHL7TriggerAddedAlert();

        new P07_HL7TriggersAdminPage(driver)
                .searchForHL7TriggerByName(hl7TriggerName)
                .clickOnEditButton(hl7TriggerName)
                .clickOnSaveButton()
                .assertVisibilityOfHL7TriggerEditedAlert();

        new P07_HL7TriggersAdminPage(driver)
                .searchForHL7TriggerByName(hl7TriggerName)
                .clickOnDeleteButton(hl7TriggerName)
                .clickOnYesButton()
                .assertVisibilityOfHL7TriggerDeletedAlert();
    }

    @Test
    public void invalidHL7TriggersTC() {
        String hl7TriggerName = hl7TriggersTestData.getJsonData("addNewHL7Trigger.hl7TriggerName") + TimestampUtils.getTimestamp();
        String hl7TriggerEvent = hl7TriggersTestData.getJsonData("addNewHL7Trigger.hl7TriggerEvent");
        String hl7TriggerDestination = hl7TriggersTestData.getJsonData("addNewHL7Trigger.hl7TriggerDestination");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnHL7ConfigurationButton()
                .clickOnHL7TriggersButton()
                .clickOnAddHL7TriggersButton()
                .selectHL7TriggerEvent(hl7TriggerEvent)
                .selectHL7TriggerDestination(hl7TriggerDestination)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyNameFieldMessage();

        new P07_HL7TriggersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddHL7TriggersButton()
                .enterHL7TriggerName(hl7TriggerName)
                .selectHL7TriggerDestination(hl7TriggerDestination)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyEventFieldMessage();

        new P07_HL7TriggersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddHL7TriggersButton()
                .enterHL7TriggerName(hl7TriggerName)
                .selectHL7TriggerEvent(hl7TriggerEvent)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyDestinationFieldMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        hl7TriggersTestData = new JsonUtils("HL7TriggersTestData");
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