package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P05_ActiveDirectoriesAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC05_ActiveDirectoryAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils activeDirectoryTestData;

    @Test
    public void activeDirectoryTC() throws InterruptedException {
        String activeDirectoryName = activeDirectoryTestData.getJsonData("addNewActiveDirectory.name") + "-" + TimestampUtils.getTimestamp();
        String activeDirectoryUrl = activeDirectoryTestData.getJsonData("addNewActiveDirectory.url");
        String activeDirectoryPort = activeDirectoryTestData.getJsonData("addNewActiveDirectory.port");


        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.username"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidCredentials();

        new P02_LibraryPage(driver)
                .clickOnLibraryButton()
                .clickOnICodeAdministrationButton()
                .clickOnUsersManagementButton()
                .clickOnGeneralConfigButton()
                .clickOnActiveDirectoriesButton()
                .clickOnAddButton()
                .enterName(activeDirectoryName)
                .enterURL(activeDirectoryUrl)
                .selectSite()
                .clickOnActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfActiveDirectoryAddedAlert();

        new P05_ActiveDirectoriesAdminPage(driver)
                .clickOnEditButton(activeDirectoryName)
                .clickOnSaveButton()
                .assertVisibilityOfActiveDirectoryEditedAlert();

        new P05_ActiveDirectoriesAdminPage(driver)
                .clickOnDeleteButton(activeDirectoryName)
                .clickOnYesButton()
                .assertVisibilityOfActiveDirectoryDeletedAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        activeDirectoryTestData = new JsonUtils("ActiveDirectoryTestData");
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
