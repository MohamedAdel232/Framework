package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P11_SchedulingSuggestionsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC11_SchedulingSuggestionsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils schedulingSuggestionsTestData;

    @Test
    public void validSchedulingSuggestionTC() {
        String suggestion = schedulingSuggestionsTestData.getJsonData("addNewSchedulingSuggestion.suggestion") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnSchedulingSuggestionsButton()
                .clickOnAddSchedulingSuggestionButton()
                .enterSchedulingSuggestion(suggestion)
                .checkManualDateCheckbox()
                .checkActiveCheckbox()
                .checkDefaultCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfSchedulingSuggestionAddedAlert();

        new P11_SchedulingSuggestionsAdminPage(driver)
                .searchForSchedulingSuggestion(suggestion)
                .clickOnEditButton(suggestion)
                .clickOnSaveButton()
                .assertVisibilityOfSchedulingSuggestionEditedAlert();

        new P11_SchedulingSuggestionsAdminPage(driver)
                .searchForSchedulingSuggestion(suggestion)
                .clickOnDeleteButton(suggestion)
                .clickOnYesButton()
                .assertVisibilityOfSchedulingSuggestionDeletedAlert();
    }

    @Test
    public void invalidSchedulingSuggestionTC() {
        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnSchedulingSuggestionsButton()
                .clickOnAddSchedulingSuggestionButton()
                .clickOnSaveButton()
                .assertVisibilityOfEmptySchedulingSuggestionFieldMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        schedulingSuggestionsTestData = new JsonUtils("SchedulingSuggestionsTestData");
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