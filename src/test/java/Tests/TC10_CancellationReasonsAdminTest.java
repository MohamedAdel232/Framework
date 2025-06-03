package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P10_CancellationReasonsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC10_CancellationReasonsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils cancellationReasonsTestData;

    @Test
    public void validCancellationReasonTC() {
        String reason = cancellationReasonsTestData.getJsonData("addNewCancellationReason.reason") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnCancellationReasonsButton()
                .clickOnAddCancellationReasonButton()
                .enterReason(reason)
                .checkRequiresCommentCheckbox()
                .checkActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfCancellationReasonAddedAlert();

        new P10_CancellationReasonsAdminPage(driver)
                .searchForCancellationReason(reason)
                .clickOnEditButton(reason)
                .clickOnSaveButton()
                .assertVisibilityOfCancellationReasonEditedAlert();

        new P10_CancellationReasonsAdminPage(driver)
                .searchForCancellationReason(reason)
                .clickOnDeleteButton(reason)
                .clickOnYesButton()
                .assertVisibilityOfCancellationReasonDeletedAlert();
    }

    @Test
    public void invalidCancellationReasonTC() {
        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnCancellationReasonsButton()
                .clickOnAddCancellationReasonButton()
                .checkRequiresCommentCheckbox()
                .checkActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyReasonFieldMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        cancellationReasonsTestData = new JsonUtils("CancellationReasonsTestData");
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