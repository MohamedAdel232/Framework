package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Utilities.JsonUtils;
import Listeners.TestNGListeners;
import Utilities.PropertiesUtils;
import Utilities.ScreenRecorderUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC02_UsersAdminTest{
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils userTestData;

    @Test
    public void addPowerAdminTC() throws InterruptedException {
        String userRole = userTestData.getJsonData("addNewUsers.powerAdmin");
        String username = userTestData.getJsonData("addNewUsers.username") + TimestampUtils.getTimestamp();
        String fullName = userTestData.getJsonData("addNewUsers.fullName");
        String password = userTestData.getJsonData("addNewUsers.password");
        String confirmPassword = userTestData.getJsonData("addNewUsers.confirmPassword");
        String email = userTestData.getJsonData("addNewUsers.email");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnAddUserButton()
                .selectUserRole(userRole)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .checkActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfUserAddedAlert();

        new P02_UsersAdminPage(driver)
                .searchUserByUsername(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertVisibilityOfUserEditedAlert();

        new P02_UsersAdminPage(driver)
                .searchUserByUsername(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertVisibilityOfUserDeletedAlert();
    }

    @Test
    public void addAdminTC() throws InterruptedException {
        String userRole = userTestData.getJsonData("addNewUsers.admin");
        String username = userTestData.getJsonData("addNewUsers.username") + TimestampUtils.getTimestamp();
        String fullName = userTestData.getJsonData("addNewUsers.fullName");
        String password = userTestData.getJsonData("addNewUsers.password");
        String confirmPassword = userTestData.getJsonData("addNewUsers.confirmPassword");
        String email = userTestData.getJsonData("addNewUsers.email");
        String pacsUsername = userTestData.getJsonData("addNewUsers.pacsUsername");
        String risUserID = userTestData.getJsonData("addNewUsers.risUserID");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnAddUserButton()
                .selectUserRole(userRole)
                .selectSite()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .enterPacsUsername(pacsUsername)
                .enterRisUserID(risUserID)
                .checkActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfUserAddedAlert();

        new P02_UsersAdminPage(driver)
                .searchUserByUsername(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertVisibilityOfUserEditedAlert();

        new P02_UsersAdminPage(driver)
                .searchUserByUsername(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertVisibilityOfUserDeletedAlert();
    }

    @Test
    public void addRadiologistTC() throws InterruptedException {
        String userRole = userTestData.getJsonData("addNewUsers.radiologist");
        String username = userTestData.getJsonData("addNewUsers.username") + TimestampUtils.getTimestamp();
        String fullName = userTestData.getJsonData("addNewUsers.fullName");
        String password = userTestData.getJsonData("addNewUsers.password");
        String confirmPassword = userTestData.getJsonData("addNewUsers.confirmPassword");
        String email = userTestData.getJsonData("addNewUsers.email");
        String pacsUsername = userTestData.getJsonData("addNewUsers.pacsUsername");
        String risUserID = userTestData.getJsonData("addNewUsers.risUserID");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnAddUserButton()
                .selectUserRole(userRole)
                .selectSite()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .enterPacsUsername(pacsUsername)
                .enterRisUserID(risUserID)
                .selectSubspecialty()
                .checkActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfUserAddedAlert();

        new P02_UsersAdminPage(driver)
                .searchUserByUsername(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertVisibilityOfUserEditedAlert();

        new P02_UsersAdminPage(driver)
                .searchUserByUsername(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertVisibilityOfUserDeletedAlert();
    }

    @Test
    public void addTechnologistTC() throws InterruptedException {
        String userRole = userTestData.getJsonData("addNewUsers.technologist");
        String username = userTestData.getJsonData("addNewUsers.username") + TimestampUtils.getTimestamp();
        String fullName = userTestData.getJsonData("addNewUsers.fullName");
        String password = userTestData.getJsonData("addNewUsers.password");
        String confirmPassword = userTestData.getJsonData("addNewUsers.confirmPassword");
        String email = userTestData.getJsonData("addNewUsers.email");
        String pacsUsername = userTestData.getJsonData("addNewUsers.pacsUsername");
        String risUserID = userTestData.getJsonData("addNewUsers.risUserID");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnAddUserButton()
                .selectUserRole(userRole)
                .selectSite()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .enterPacsUsername(pacsUsername)
                .enterRisUserID(risUserID)
                .selectModality()
                .checkActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfUserAddedAlert();

        new P02_UsersAdminPage(driver)
                .searchUserByUsername(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertVisibilityOfUserEditedAlert();

        new P02_UsersAdminPage(driver)
                .searchUserByUsername(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertVisibilityOfUserDeletedAlert();
    }

    @Test
    public void addUnitAssistantTC() throws InterruptedException {
        String userRole = userTestData.getJsonData("addNewUsers.unitAssistant");
        String username = userTestData.getJsonData("addNewUsers.username") + TimestampUtils.getTimestamp();
        String fullName = userTestData.getJsonData("addNewUsers.fullName");
        String password = userTestData.getJsonData("addNewUsers.password");
        String confirmPassword = userTestData.getJsonData("addNewUsers.confirmPassword");
        String email = userTestData.getJsonData("addNewUsers.email");
        String pacsUsername = userTestData.getJsonData("addNewUsers.pacsUsername");
        String risUserID = userTestData.getJsonData("addNewUsers.risUserID");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnAddUserButton()
                .selectUserRole(userRole)
                .selectSite()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .enterPacsUsername(pacsUsername)
                .enterRisUserID(risUserID)
                .selectModality()
                .checkActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfUserAddedAlert();

        new P02_UsersAdminPage(driver)
                .searchUserByUsername(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertVisibilityOfUserEditedAlert();

        new P02_UsersAdminPage(driver)
                .searchUserByUsername(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertVisibilityOfUserDeletedAlert();
    }

    @Test
    public void addNurseTC() throws InterruptedException {
        String userRole = userTestData.getJsonData("addNewUsers.nurse");
        String username = userTestData.getJsonData("addNewUsers.username") + TimestampUtils.getTimestamp();
        String fullName = userTestData.getJsonData("addNewUsers.fullName");
        String password = userTestData.getJsonData("addNewUsers.password");
        String confirmPassword = userTestData.getJsonData("addNewUsers.confirmPassword");
        String email = userTestData.getJsonData("addNewUsers.email");
        String pacsUsername = userTestData.getJsonData("addNewUsers.pacsUsername");
        String risUserID = userTestData.getJsonData("addNewUsers.risUserID");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnAddUserButton()
                .selectUserRole(userRole)
                .selectSite()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .enterPacsUsername(pacsUsername)
                .enterRisUserID(risUserID)
                .selectModality()
                .checkActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfUserAddedAlert();

        new P02_UsersAdminPage(driver)
                .searchUserByUsername(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertVisibilityOfUserEditedAlert();

        new P02_UsersAdminPage(driver)
                .searchUserByUsername(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertVisibilityOfUserDeletedAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        userTestData = new JsonUtils("UsersTestData");
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
