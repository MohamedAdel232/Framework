package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

import java.awt.*;

@Listeners(TestNGListeners.class)
public class TC02_UsersAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils userTestData;

    @Test
    public void addPowerAdminTC() {
        String powerAdmin = userTestData.getJsonData("addNewUsers.powerAdmin");
        String username = userTestData.getJsonData("addNewUsers.username") + "-" + TimestampUtils.getTimestamp();
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
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .clickOnSaveButton();

        new P02_UsersAdminPage(driver)
                .searchForUserByUsername(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertVisibilityOfUserEditedAlert();

        new P02_UsersAdminPage(driver)
                .clickOnOkButton()
                .searchForUserByUsername(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertVisibilityOfUserDeletedAlert();
    }

    @Test
    public void addPowerUserTC() {
        String powerUser = userTestData.getJsonData("addNewUsers.powerUser");
        String username = userTestData.getJsonData("addNewUsers.username") + "-" + TimestampUtils.getTimestamp();
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
                .clickOnAddButton()
                .selectUserRole(powerUser)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .clickOnSaveButton();

        new P02_UsersAdminPage(driver)
                .searchForUserByUsername(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertVisibilityOfUserEditedAlert();

        new P02_UsersAdminPage(driver)
                .clickOnOkButton()
                .searchForUserByUsername(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertVisibilityOfUserDeletedAlert();
    }

    @Test
    public void addAdminTC() {
        String admin = userTestData.getJsonData("addNewUsers.admin");
        String username = userTestData.getJsonData("addNewUsers.username") + "-" + TimestampUtils.getTimestamp();
        String fullName = userTestData.getJsonData("addNewUsers.fullName");
        String password = userTestData.getJsonData("addNewUsers.password");
        String confirmPassword = userTestData.getJsonData("addNewUsers.confirmPassword");
        String email = userTestData.getJsonData("addNewUsers.email");
        String site = new P02_UsersAdminPage(driver).selectSiteWithGroup();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnAddButton()
                .selectUserRole(admin)
                .selectSite(site)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .clickOnRegionalAccessCheckbox()
                .clickOnSaveButton();

        new P02_UsersAdminPage(driver)
                .searchForUserByUsername(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertVisibilityOfUserEditedAlert();

        new P02_UsersAdminPage(driver)
                .clickOnOkButton()
                .searchForUserByUsername(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertVisibilityOfUserDeletedAlert();
    }

    @Test
    public void addUserTC() {
        String user = userTestData.getJsonData("addNewUsers.user");
        String username = userTestData.getJsonData("addNewUsers.username") + "-" + TimestampUtils.getTimestamp();
        String fullName = userTestData.getJsonData("addNewUsers.fullName");
        String password = userTestData.getJsonData("addNewUsers.password");
        String confirmPassword = userTestData.getJsonData("addNewUsers.confirmPassword");
        String email = userTestData.getJsonData("addNewUsers.email");
        String pacsUsername = userTestData.getJsonData("addNewUsers.pacsUsername");
        String risUserID = userTestData.getJsonData("addNewUsers.risUserID");
        String MSTeamsID = userTestData.getJsonData("addNewUsers.MSTeamsID");
        String site = new P02_UsersAdminPage(driver).selectSiteWithGroup();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnAddButton()
                .selectUserRole(user)
                .selectSite(site)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .enterPACSUsername(pacsUsername)
                .enterRISUserID(risUserID)
                .enterMSTeamsID(MSTeamsID)
                .clickOnMDTCoordinatorCheckbox()
                .selectGroup()
                .clickOnActiveCheckbox()
                .clickOnRegionalAccessCheckbox()
                .clickOnSaveButton();

        new P02_UsersAdminPage(driver)
                .searchForUserByUsername(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertVisibilityOfUserEditedAlert();

        new P02_UsersAdminPage(driver)
                .clickOnOkButton()
                .searchForUserByUsername(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertVisibilityOfUserDeletedAlert();
    }

    @Test
    public void invalidUsersTC() {
        String powerAdmin = userTestData.getJsonData("addNewUsers.powerAdmin");
        String admin = userTestData.getJsonData("addNewUsers.admin");
        String user = userTestData.getJsonData("addNewUsers.user");
        String username = userTestData.getJsonData("addNewUsers.username") + "-" + TimestampUtils.getTimestamp();
        String fullName = userTestData.getJsonData("addNewUsers.fullName");
        String password = userTestData.getJsonData("addNewUsers.password");
        String confirmPassword = userTestData.getJsonData("addNewUsers.confirmPassword");
        String email = userTestData.getJsonData("addNewUsers.email");
        String pacsUsername = userTestData.getJsonData("addNewUsers.pacsUsername");
        String risUserID = userTestData.getJsonData("addNewUsers.risUserID");
        String MSTeamsID = userTestData.getJsonData("addNewUsers.MSTeamsID");
        String lessThanThreeCharacterUsername = userTestData.getJsonData("addNewUsers.lessThanThreeCharacterUsername");
        String noSpacesUsername = userTestData.getJsonData("addNewUsers.noSpacesUsername");
        String invalidPassword = userTestData.getJsonData("addNewUsers.invalidPassword");
        String passwordMismatch = userTestData.getJsonData("addNewUsers.passwordMismatch");
        String noSpacesEmail = userTestData.getJsonData("addNewUsers.noSpacesEmail");
        String invalidEmail = userTestData.getJsonData("addNewUsers.invalidEmail");
        String noSpacesPACSUsername = userTestData.getJsonData("addNewUsers.noSpacesPACSUsername");
        String noSpacesRISUserID = userTestData.getJsonData("addNewUsers.noSpacesRISUserID");
        String site = new P02_UsersAdminPage(driver).selectSiteWithGroup();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnAddButton()
                .clickOnUserRoleDropdown()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .assertVisibilityOfEmptyUserRoleMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername("")
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .assertVisibilityOfEmptyUsernameMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(" ")
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .assertVisibilityOfSpacesOnlyUsernameMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(lessThanThreeCharacterUsername)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .assertVisibilityOfLessThanThreeCharacterUsernameMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(noSpacesUsername)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .assertVisibilityOfNoSpacesUsernameMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(username)
                .enterFullName("")
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .assertVisibilityOfEmptyFullNameMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(username)
                .enterFullName(" ")
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .assertVisibilityOfSpacesOnlyFullNameMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword("")
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .assertVisibilityOfEmptyPasswordMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(invalidPassword)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .assertVisibilityOfInvalidPasswordMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword("")
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .assertVisibilityOfEmptyConfirmPasswordMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(passwordMismatch)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .assertVisibilityOfPasswordMismatchMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail("")
                .clickOnActiveCheckbox()
                .assertVisibilityOfEmptyEmailMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(noSpacesEmail)
                .clickOnActiveCheckbox()
                .assertVisibilityOfNoSpacesEmailMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(powerAdmin)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(invalidEmail)
                .clickOnActiveCheckbox()
                .assertVisibilityOfInvalidEmailMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(admin)
                .clickOnSiteDropdown()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .clickOnActiveCheckbox()
                .assertVisibilityOfEmptySiteMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(user)
                .selectSite(site)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .enterPACSUsername("")
                .enterRISUserID(risUserID)
                .enterMSTeamsID(MSTeamsID)
                .clickOnMDTCoordinatorCheckbox()
                .selectGroup()
                .clickOnActiveCheckbox()
                .clickOnRegionalAccessCheckbox()
                .assertVisibilityOfEmptyPACSUsernameMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(user)
                .selectSite(site)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .enterPACSUsername(noSpacesPACSUsername)
                .enterRISUserID(risUserID)
                .enterMSTeamsID(MSTeamsID)
                .clickOnMDTCoordinatorCheckbox()
                .selectGroup()
                .clickOnActiveCheckbox()
                .clickOnRegionalAccessCheckbox()
                .assertVisibilityOfNoSpacesPACSUsernameMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(user)
                .selectSite(site)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .enterPACSUsername(pacsUsername)
                .enterRISUserID("")
                .enterMSTeamsID(MSTeamsID)
                .clickOnMDTCoordinatorCheckbox()
                .selectGroup()
                .clickOnActiveCheckbox()
                .clickOnRegionalAccessCheckbox()
                .assertVisibilityOfEmptyRISUserIDMessage();

//        new P02_UsersAdminPage(driver)
//                .clickOnBackButton()
//                .clickOnAddButton()
//                .selectUserRole(user)
//                .selectSite(site)
//                .enterUsername(username)
//                .enterFullName(fullName)
//                .enterPassword(password)
//                .enterConfirmPassword(confirmPassword)
//                .enterEmail(email)
//                .enterPACSUsername(pacsUsername)
//                .enterRISUserID(noSpacesRISUserID)
//                .enterMSTeamsID(MSTeamsID)
//                .clickOnMDTCoordinatorCheckbox()
//                .selectGroup()
//                .clickOnActiveCheckbox()
//                .clickOnRegionalAccessCheckbox()
//                .assertVisibilityOfNoSpacesRISUserIDMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectUserRole(user)
                .selectSite(site)
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .enterEmail(email)
                .enterPACSUsername(pacsUsername)
                .enterRISUserID(risUserID)
                .enterMSTeamsID(MSTeamsID)
                .clickOnMDTCoordinatorCheckbox()
                .clickOnGroupDropdown()
                .clickOnActiveCheckbox()
                .clickOnRegionalAccessCheckbox()
                .assertVisibilityOfEmptyGroupMessage();
    }

    @Test
    public void exportingUsersTC() throws InterruptedException, AWTException {
        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        int numberOfFilesBeforeExport = new P02_UsersAdminPage(driver).getNumberOfFilesInDownloadsDirectory();
        new P02_UsersAdminPage(driver).clickOnExportButton();
        int numberOfFilesAfterExport = new P02_UsersAdminPage(driver).getNumberOfFilesInDownloadsDirectory();

        new P02_UsersAdminPage(driver)
                .assertExportingUsers(numberOfFilesBeforeExport, numberOfFilesAfterExport);
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
