package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P07_ActiveDirectoriesAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC07_ActiveDirectoriesAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils activeDirectoriesTestData;

    @Test
    public void validActiveDirectoriesTC() {
        String name = activeDirectoriesTestData.getJsonData("addNewActiveDirectory.name") + TimestampUtils.getTimestamp();
        String url = activeDirectoriesTestData.getJsonData("addNewActiveDirectory.url");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnActiveDirectoriesButton()
                .clickOnAddNewActiveDirectoryButton()
                .enterName(name)
                .enterUrl(url)
                .selectSite()
                .checkActiveCheckbox()
                .clickOnSaveButton()
        //.assertVisibilityOfActiveDirectoryAddedAlert()
        ;

        new P07_ActiveDirectoriesAdminPage(driver)
//                .clickOnOkButton()
                .searchActiveDirectoryByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertVisibilityOfActiveDirectoryEditedAlert();

        new P07_ActiveDirectoriesAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfActiveDirectoryDeletedAlert();
    }

    @Test
    public void invalidActiveDirectoriesTC() {
        String name = activeDirectoriesTestData.getJsonData("addNewActiveDirectory.name") + TimestampUtils.getTimestamp();
        String url = activeDirectoriesTestData.getJsonData("addNewActiveDirectory.url");
        String invalidUrl = activeDirectoriesTestData.getJsonData("addNewActiveDirectory.invalidUrl");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnActiveDirectoriesButton()
                .clickOnAddNewActiveDirectoryButton()
                .enterName("")
                .enterUrl(url)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyNameMessage();

        new P07_ActiveDirectoriesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewActiveDirectoryButton()
                .enterName(name)
                .enterUrl("")
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyUrlMessage();

        new P07_ActiveDirectoriesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewActiveDirectoryButton()
                .enterName(name)
                .enterUrl(invalidUrl)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfInvalidUrlMessage();

        new P07_ActiveDirectoriesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewActiveDirectoryButton()
                .clickOnSiteDropdown()
                .enterName(name)
                .enterUrl(url)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptySiteMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        activeDirectoriesTestData = new JsonUtils("ActiveDirectoriesTestData");
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