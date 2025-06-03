package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P09_ModalityMappingAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC09_ModalityMappingAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils modalityMappingTestData;

    @Test
    public void validModalityMappingTC() {
        String procedureCode = modalityMappingTestData.getJsonData("addNewModalityMapping.procedureCode") + TimestampUtils.getTimestamp();
        String procedureDescription = modalityMappingTestData.getJsonData("addNewModalityMapping.procedureDescription");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnGeneralConfigButton()
                .clickOnModalityMappingButton()
                .clickOnAddModalityMappingButton()
                .enterProcedureCode(procedureCode)
                .enterProcedureDescription(procedureDescription)
                .selectModality()
                .clickOnSaveButton()
                .assertVisibilityOfModalityMappingAddedAlert();

        new P09_ModalityMappingAdminPage(driver)
                .searchForModalityMappingByProcedureCode(procedureCode)
                .clickOnEditButton(procedureCode)
                .clickOnSaveButton()
                .assertVisibilityOfModalityMappingEditedAlert();

        new P09_ModalityMappingAdminPage(driver)
                .searchForModalityMappingByProcedureCode(procedureCode)
                .clickOnDeleteButton(procedureCode)
                .clickOnYesButton()
                .assertVisibilityOfModalityMappingDeletedAlert();
    }

    @Test
    public void invalidModalityMappingTC() {
        String procedureCode = modalityMappingTestData.getJsonData("addNewModalityMapping.procedureCode") + TimestampUtils.getTimestamp();
        String procedureDescription = modalityMappingTestData.getJsonData("addNewModalityMapping.procedureDescription");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnGeneralConfigButton()
                .clickOnModalityMappingButton()
                .clickOnAddModalityMappingButton()
                .enterProcedureDescription(procedureDescription)
                .selectModality()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyProcedureCodeFieldMessage();

        new P09_ModalityMappingAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddModalityMappingButton()
                .enterProcedureCode(procedureCode)
                .selectModality()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyProcedureDescriptionFieldMessage();

        new P09_ModalityMappingAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddModalityMappingButton()
                .enterProcedureCode(procedureCode)
                .enterProcedureDescription(procedureDescription)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyModalityFieldMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        modalityMappingTestData = new JsonUtils("ModalityMappingTestData");
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