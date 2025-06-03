package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P13_ProtocolGroupsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC13_ProtocolGroupsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils protocolGroupsTestData;

    @Test
    public void validProtocolGroupTC() throws InterruptedException {
        String protocolGroupName = protocolGroupsTestData.getJsonData("addNewProtocolGroup.name") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnProtocolGroupsButton()
                .clickOnAddProtocolGroupButton()
                .enterProtocolGroupName(protocolGroupName)
                .selectFilterRowSettings()
                .selectOperator()
                .selectCode()
                .clickOnSaveButton()
                .assertVisibilityOfProtocolGroupAddedAlert();

        new P13_ProtocolGroupsAdminPage(driver)
                .searchForProtocolGroup(protocolGroupName)
                .clickOnEditButton(protocolGroupName)
                .clickOnSaveButton()
                .assertVisibilityOfProtocolGroupEditedAlert();

        new P13_ProtocolGroupsAdminPage(driver)
                .searchForProtocolGroup(protocolGroupName)
                .clickOnDeleteButton(protocolGroupName)
                .clickOnYesButton()
                .assertVisibilityOfProtocolGroupDeletedAlert();
    }

    @Test
    public void invalidProtocolGroupTC() {
        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnProtocolGroupsButton()
                .clickOnAddProtocolGroupButton()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyNameFieldMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        protocolGroupsTestData = new JsonUtils("ProtocolGroupsTestData");
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