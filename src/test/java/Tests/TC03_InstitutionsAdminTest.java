package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P03_InstitutionsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC03_InstitutionsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils institutionsTestData;

    @Test
    public void validInstitutionsTC() {
        String name = institutionsTestData.getJsonData("addNewInstitution.name") + "-" + TimestampUtils.getTimestamp();
        String expectedInstitutionAddedMessage = institutionsTestData.getJsonData("messages.institutionAddedMessage");
        String expectedInstitutionEditedMessage = institutionsTestData.getJsonData("messages.institutionEditedMessage");
        String expectedInstitutionDeletedMessage = institutionsTestData.getJsonData("messages.institutionDeletedMessage");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnInstitutionButton()
                .clickOnAddButton()
                .enterName(name)
                .checkActiveCheckbox()
                .clickOnSaveButton()
                .assertInstitutionAddedMessage(expectedInstitutionAddedMessage);

        new P03_InstitutionsAdminPage(driver)
                .clickOnOkButton()
                .searchForInstitutionByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertInstitutionEditedMessage(expectedInstitutionEditedMessage);

        new P03_InstitutionsAdminPage(driver)
                .clickOnOkButton()
                .deleteInstitutionRecordsInModalitiesTableInTheDB(name)
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertInstitutionDeletedMessage(expectedInstitutionDeletedMessage);
    }

    @Test
    public void invalidInstitutionsTC() {
        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnInstitutionButton()
                .clickOnAddButton()
                .enterName("")
                .checkActiveCheckbox()
                .assertVisibilityOfNameIsRequiredMessage();

        new P03_InstitutionsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(" ")
                .checkActiveCheckbox()
                .assertVisibilityOfNameCannotContainWhiteSpacesMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        institutionsTestData = new JsonUtils("InstitutionsTestData");
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

