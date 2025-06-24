package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P05_DICOMNodesAdminPage;
import Pages.P10_ActiveDirectoriesAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC10_ActiveDirectoriesAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils activeDirectoriesTestData;

    @Test
    public void validActiveDirectoriesTC() {
        String name = activeDirectoriesTestData.getJsonData("addNewActiveDirectory.name") + "-" + TimestampUtils.getTimestamp();
        String url = activeDirectoriesTestData.getJsonData("addNewActiveDirectory.url");
        String institution = new P05_DICOMNodesAdminPage(driver).getInstitutionWithLocations();
        String expectedAddedMessage = activeDirectoriesTestData.getJsonData("messages.expectedActiveDirectoryAddedMessage");
        String expectedEditedMessage = activeDirectoriesTestData.getJsonData("messages.expectedActiveDirectoryEditedMessage");
        String expectedDeletedMessage = activeDirectoriesTestData.getJsonData("messages.expectedActiveDirectoryDeletedMessage");

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
                .clickOnAddButton()
                .enterName(name)
                .enterURL(url)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .clickOnSaveButton()
                .assertActiveDirectoryAddedMessage(expectedAddedMessage);

        new P10_ActiveDirectoriesAdminPage(driver)
                .clickOnOkButton()
                .searchForActiveDirectoryByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertActiveDirectoryEditedMessage(expectedEditedMessage);

        new P10_ActiveDirectoriesAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertActiveDirectoryDeletedMessage(expectedDeletedMessage);
    }

    @Test
    public void invalidActiveDirectoriesTC() {
        String name = activeDirectoriesTestData.getJsonData("addNewActiveDirectory.name") + "-" + TimestampUtils.getTimestamp();
        String url = activeDirectoriesTestData.getJsonData("addNewActiveDirectory.url");
        String institution = new P05_DICOMNodesAdminPage(driver).getInstitutionWithLocations();
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
                .clickOnAddButton()
                .enterName("")
                .enterURL(url)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameIsRequiredMessage();

        new P10_ActiveDirectoriesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterURL(" ")
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameCannotContainWhiteSpacesOnlyMessage();

        new P10_ActiveDirectoriesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterURL("")
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfURLIsRequiredMessage();

        new P10_ActiveDirectoriesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterURL(invalidUrl)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfInvalidURLMessage();

        new P10_ActiveDirectoriesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterURL(" ")
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfURLCannotContainWhiteSpacesOnlyMessage();

        new P10_ActiveDirectoriesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .clickOnInstitutionDropdown()
                .enterName(name)
                .enterURL(url)
                .checkOnActiveCheckbox()
                .assertVisibilityOfInstitutionIsRequiredMessage();

        new P10_ActiveDirectoriesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .selectInstitution(institution)
                .clickOnLocationDropdown()
                .enterName(name)
                .enterURL(url)
                .checkOnActiveCheckbox()
                .assertVisibilityOfLocationIsRequiredMessage();
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