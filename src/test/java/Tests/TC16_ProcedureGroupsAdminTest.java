package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P16_ProcedureGroupsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC16_ProcedureGroupsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils procedureGroupTestData;

    @Test
    public void validProcedureGroupTC() throws InterruptedException {
        String procedureGroupName = procedureGroupTestData.getJsonData("addNewProcedureGroup.name") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnProcedureGroupsButton()
                .clickOnAddProcedureGroupButton()
                .enterProcedureGroupName(procedureGroupName)
                .selectProcedureCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfProcedureGroupAddedAlert();

        new P16_ProcedureGroupsAdminPage(driver)
                .searchForProcedureGroup(procedureGroupName)
                .clickOnEditButton(procedureGroupName)
                .clickOnSaveButton()
                .assertVisibilityOfProcedureGroupEditedAlert();

        new P16_ProcedureGroupsAdminPage(driver)
                .searchForProcedureGroup(procedureGroupName)
                .clickOnDeleteButton(procedureGroupName)
                .clickOnYesButton()
                .assertVisibilityOfProcedureGroupDeletedAlert();
    }

    @Test
    public void invalidProcedureGroupTC() {
        String procedureGroupName = procedureGroupTestData.getJsonData("addNewProcedureGroup.name") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnProcedureGroupsButton()
                .clickOnAddProcedureGroupButton()
                .selectProcedureCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyNameFieldMessage();

        new P16_ProcedureGroupsAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddProcedureGroupButton()
                .enterProcedureGroupName(procedureGroupName)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyProcedureMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        procedureGroupTestData = new JsonUtils("ProcedureGroupTestData");
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