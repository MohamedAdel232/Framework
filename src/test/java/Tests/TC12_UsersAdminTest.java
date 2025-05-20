package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P12_UsersAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC12_UsersAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils usersTestData;

    @Test
    public void usersTC() throws InterruptedException {
        String username = usersTestData.getJsonData("addNewUser.name") + "-" + TimestampUtils.getTimestamp();
        String fullName = usersTestData.getJsonData("addNewUser.fulName");
        String password = usersTestData.getJsonData("addNewUser.password");
        String confirmPassword = usersTestData.getJsonData("addNewUser.confirmPassword");
        String email = usersTestData.getJsonData("addNewUser.email");
        String pacsUsername = usersTestData.getJsonData("addNewUser.pacsUsername");
        String userGroup = usersTestData.getJsonData("addNewUser.userGroup");
        String site = usersTestData.getJsonData("addNewUser.site");
        String msTeamsID = usersTestData.getJsonData("addNewUser.msTeamsID");

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
                .clickOnUsersButton()
                .clickOnAddButton()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .enterPACSUsername(pacsUsername)
                .selectUserGroup(userGroup)
                .selectSite(site)
                .enterMSTeamsID(msTeamsID)
                .clickOnSaveButton()
                .assertVisibilityOfUserAddedAlert();

        new P12_UsersAdminPage(driver)
                .searchForUser(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertVisibilityOfUserEditedAlert();

        new P12_UsersAdminPage(driver)
                .searchForUser(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertVisibilityOfUserDeletedAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        usersTestData = new JsonUtils("UsersTestData");
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

