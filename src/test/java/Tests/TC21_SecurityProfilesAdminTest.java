package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P21_SecurityProfilesAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC21_SecurityProfilesAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils securityProfilesTestData;

    @Test
    public void securityProfilesTC() throws InterruptedException {
        String profileName = securityProfilesTestData.getJsonData("addNewSecurityProfile.name") + "-" + TimestampUtils.getTimestamp();

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
                .clickOnSecurityProfilesButton()
                .clickOnAddButton()
                .enterName(profileName)
                .expandAllPermissionGroups()
                .checkAllPermissions()
                .clickOnSaveButton()
                .assertVisibilityOfSecurityProfileAddedAlert();

        new P21_SecurityProfilesAdminPage(driver)
                .searchForSecurityProfile(profileName)
                .clickOnEditButton(profileName)
                .clickOnSaveButton()
                .assertVisibilityOfSecurityProfileEditedAlert();

        new P21_SecurityProfilesAdminPage(driver)
                .searchForSecurityProfile(profileName)
                .clickOnDeleteButton(profileName)
                .clickOnYesButton()
                .assertVisibilityOfSecurityProfileDeletedAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        securityProfilesTestData = new JsonUtils("SecurityProfilesTestData");
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