package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P04_UserGroupsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC04_UserGroupsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils userGroupsTestData;

    @Test
    public void userGroupsTC() throws InterruptedException {
        String groupName = userGroupsTestData.getJsonData("addNewUserGroups.groupName") + "-" + TimestampUtils.getTimestamp();

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
                .clickOnUserGroupsButton()
                .clickOnAddButton()
                .enterGroupName(groupName)
                .selectSecurityProfile()
                .clickOnSaveButton()
                .assertVisibilityOfUserGroupAddedAlert();

        new P04_UserGroupsAdminPage(driver)
                .clickOnEditButton(groupName)
                .clickOnSaveButton()
                .assertVisibilityOfUserGroupEditedAlert();

        new P04_UserGroupsAdminPage(driver)
                .clickOnDeleteButton(groupName)
                .clickOnYesButton()
                .assertVisibilityOfUserGroupDeletedAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        userGroupsTestData = new JsonUtils("UserGroupsTestData");
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
