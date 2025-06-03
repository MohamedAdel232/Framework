package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P15_SubspecialtyAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC15_SubspecialtyAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils subspecialtyTestData;

    @Test
    public void validSubspecialtyTC() throws InterruptedException {
        String subspecialtyName = subspecialtyTestData.getJsonData("addNewSubspecialty.name") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnSubspecialtyButton()
                .clickOnAddSubspecialtyButton()
                .enterSubspecialtyName(subspecialtyName)
                .selectFilterRowSettings()
                .selectOperator()
                .selectCode()
                .clickOnSaveButton()
                .assertVisibilityOfSubspecialtyAddedAlert();

        new P15_SubspecialtyAdminPage(driver)
                .searchForSubspecialty(subspecialtyName)
                .clickOnEditButton(subspecialtyName)
                .clickOnSaveButton()
                .assertVisibilityOfSubspecialtyEditedAlert();

        new P15_SubspecialtyAdminPage(driver)
                .searchForSubspecialty(subspecialtyName)
                .clickOnDeleteButton(subspecialtyName)
                .clickOnYesButton()
                .assertVisibilityOfSubspecialtyDeletedAlert();
    }

    @Test
    public void invalidSubspecialtyTC() {
        String subspecialtyName = subspecialtyTestData.getJsonData("addNewSubspecialty.name") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnSubspecialtyButton()
                .clickOnAddSubspecialtyButton()
                .selectFilterRowSettings()
                .selectOperator()
                .selectCode()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyNameFieldMessage();

        new P15_SubspecialtyAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddSubspecialtyButton()
                .enterSubspecialtyName(subspecialtyName)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyParameterMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        subspecialtyTestData = new JsonUtils("SubspecialtyTestData");
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