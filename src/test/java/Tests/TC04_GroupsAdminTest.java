package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P04_GroupsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC04_GroupsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils groupsTestData;

    @Test
    public void validGroupsTC() {
        String groupName = groupsTestData.getJsonData("addNewGroup.groupName") + "-" + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnGroupsButton()
                .clickOnAddNewGroupButton()
                .enterGroupName(groupName)
                .selectSite()
                .clickOnSaveButton();

        new P04_GroupsAdminPage(driver)
                .searchGroupByName(groupName)
                .clickOnEditButton(groupName)
                .clickOnSaveButton()
                .assertVisibilityOfGroupEditedAlert();

        new P04_GroupsAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(groupName)
                .clickOnYesButton()
                .assertVisibilityOfGroupDeletedAlert();
    }

    @Test
    public void invalidGroupsTC() {
        String groupName = groupsTestData.getJsonData("addNewGroup.groupName") + "-" + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnGroupsButton()
                .clickOnAddNewGroupButton()
                .enterGroupName("")
                .selectSite()
                .assertVisibilityOfEmptyGroupNameMessage();

        new P04_GroupsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewGroupButton()
                .clickOnSiteDropdown()
                .enterGroupName(groupName)
                .assertVisibilityOfEmptySiteMessage();

        new P04_GroupsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewGroupButton()
                .enterGroupName(" ")
                .clickOnSiteDropdown()
                .assertVisibilityOfSpacesOnlyGroupNameMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        groupsTestData = new JsonUtils("GroupsTestData");
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