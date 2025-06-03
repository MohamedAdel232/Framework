package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P12_ProtocolsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC12_ProtocolsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils protocolsTestData;

    @Test
    public void validProtocolTC() throws InterruptedException {
        String protocolName = protocolsTestData.getJsonData("addNewProtocol.name") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnProtocolsButton()
                .clickOnAddProtocolButton()
                .enterProtocolName(protocolName)
                .selectProtocolGroup()
                .checkRequiresCommentCheckbox()
                .checkActiveCheckbox()
                .selectFilterRowSettings()
                .selectOperator()
                .selectCode()
                .clickOnSaveButton()
                .assertVisibilityOfProtocolAddedAlert();

        new P12_ProtocolsAdminPage(driver)
                .searchForProtocol(protocolName)
                .clickOnEditButton(protocolName)
                .clickOnSaveButton()
                .assertVisibilityOfProtocolEditedAlert();

        new P12_ProtocolsAdminPage(driver)
                .searchForProtocol(protocolName)
                .clickOnDeleteButton(protocolName)
                .clickOnYesButton()
                .assertVisibilityOfProtocolDeletedAlert();
    }

    @Test
    public void invalidProtocolTC() {
        String protocolName = protocolsTestData.getJsonData("addNewProtocol.name") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnProtocolsButton()
                .clickOnAddProtocolButton()
                .selectProtocolGroup()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyNameFieldMessage();

        new P12_ProtocolsAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddProtocolButton()
                .enterProtocolName(protocolName)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyProtocolGroupMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        protocolsTestData = new JsonUtils("ProtocolsTestData");
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