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
        String username = userTestData.getJsonData("addNewUsers.username") + TimestampUtils.getTimestamp();
        String fullName = userTestData.getJsonData("addNewUsers.fullName");
        String password = userTestData.getJsonData("addNewUsers.password");
        String confirmPassword = userTestData.getJsonData("addNewUsers.confirmPassword");
        String powerAdminUserType = userTestData.getJsonData("addNewUsers.powerAdminUserType");
        String expectedUserAddedMessage = userTestData.getJsonData("messages.expectedUserAddedMessage");
        String expectedUserEditedMessage = userTestData.getJsonData("messages.expectedUserEditedMessage");
        String expectedUserDeletedMessage = userTestData.getJsonData("messages.expectedUserDeletedMessage");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnAddButton()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(powerAdminUserType)
                .checkActiveCheckbox()
                .clickOnSaveButton()
                .assertUserAddedMessage(expectedUserAddedMessage);

        new P02_UsersAdminPage(driver)
                .clickOnOkButton()
                .searchForUserByName(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertUserEditedMessage(expectedUserEditedMessage);

        new P02_UsersAdminPage(driver)
                .clickOnOkButton()
                .searchForUserByName(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertUserDeletedMessage(expectedUserDeletedMessage);
    }

    @Test
    public void addSiteAdminTC() {
        String username = userTestData.getJsonData("addNewUsers.username") + TimestampUtils.getTimestamp();
        String fullName = userTestData.getJsonData("addNewUsers.fullName");
        String password = userTestData.getJsonData("addNewUsers.password");
        String confirmPassword = userTestData.getJsonData("addNewUsers.confirmPassword");
        String siteAdminUserType = userTestData.getJsonData("addNewUsers.siteAdminUserType");
        String email = userTestData.getJsonData("addNewUsers.email");
        String institution = new P02_UsersAdminPage(driver).getInstitutionWithLocations();
        String expectedUserAddedMessage = userTestData.getJsonData("messages.expectedUserAddedMessage");
        String expectedUserEditedMessage = userTestData.getJsonData("messages.expectedUserEditedMessage");
        String expectedUserDeletedMessage = userTestData.getJsonData("messages.expectedUserDeletedMessage");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnAddButton()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .clickOnSaveButton()
                .assertUserAddedMessage(expectedUserAddedMessage);

        new P02_UsersAdminPage(driver)
                .clickOnOkButton()
                .searchForUserByName(username)
                .clickOnEditButton(username)
                .clickOnSaveButton()
                .assertUserEditedMessage(expectedUserEditedMessage);

        new P02_UsersAdminPage(driver)
                .clickOnOkButton()
                .searchForUserByName(username)
                .clickOnDeleteButton(username)
                .clickOnYesButton()
                .assertUserDeletedMessage(expectedUserDeletedMessage);
    }

    @Test
    public void invalidUsersTC() {
        String username = userTestData.getJsonData("addNewUsers.username") + TimestampUtils.getTimestamp();
        String fullName = userTestData.getJsonData("addNewUsers.fullName");
        String password = userTestData.getJsonData("addNewUsers.password");
        String confirmPassword = userTestData.getJsonData("addNewUsers.confirmPassword");
        String siteAdminUserType = userTestData.getJsonData("addNewUsers.siteAdminUserType");
        String email = userTestData.getJsonData("addNewUsers.email");
        String institution = new P02_UsersAdminPage(driver).getInstitutionWithLocations();
        String location = userTestData.getJsonData("addNewUsers.location");
        String usernameMustBeAtLeast3Characters = userTestData.getJsonData("addNewUsers.usernameMustBeAtLeast3Characters");
        String usernameCannotContainSpaces = userTestData.getJsonData("addNewUsers.usernameCannotContainSpaces");
        String usernameMustBeLessThanOrEquals50Characters = userTestData.getJsonData("addNewUsers.usernameMustBeLessThanOrEquals50Characters");
        String usernameCannotContainBackslashForwardSlashOrAmpersand = userTestData.getJsonData("addNewUsers.usernameCannotContainBackslashForwardSlashOrAmpersand");
        String passwordMustBeAtLeast6Characters = userTestData.getJsonData("addNewUsers.passwordMustBeAtLeast6Characters");
        String passwordMustBeLessThanOrEquals32Characters = userTestData.getJsonData("addNewUsers.passwordMustBeLessThanOrEquals32Characters");
        String passwordsMustMatch = userTestData.getJsonData("addNewUsers.passwordsMustMatch");
        String invalidEmail = userTestData.getJsonData("addNewUsers.invalidEmail");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnAddButton()
                .enterUsername("")
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfUsernameIsRequiredMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(usernameMustBeAtLeast3Characters)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfUsernameMustBeAtLeast3CharactersMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(usernameCannotContainSpaces)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfUsernameCannotContainSpacesMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(usernameCannotContainSpaces)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfUsernameCannotContainSpacesMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(usernameMustBeLessThanOrEquals50Characters)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfUsernameMustBeLessThanOrEquals50CharactersMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(usernameCannotContainBackslashForwardSlashOrAmpersand)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfUsernameCannotContainBackslashForwardSlashOrAmpersandMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(username)
                .enterFullName("")
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfFullNameIsRequiredMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(username)
                .enterFullName(" ")
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfFullNameCannotContainWhiteSpacesOnlyMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword("")
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfPasswordIsRequiredMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(passwordMustBeAtLeast6Characters)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfPasswordMustBeAtLeast6CharactersMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(passwordMustBeLessThanOrEquals32Characters)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfPasswordMustBeLessThanOrEquals32CharactersMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword("")
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfConfirmPasswordIsRequiredMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(passwordsMustMatch)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfPasswordsMustMatchMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .clickOnUserTypeDropdown()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .checkActiveCheckbox()
                .assertVisibilityOfUserTypeIsRequiredMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail("")
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfEmailIsRequiredMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(invalidEmail)
                .selectInstitution(institution)
                .selectLocation()
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfInvalidEmailMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .clickOnInstitutionDropdown()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfInstitutionIsRequiredMessage();

        new P02_UsersAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .selectInstitution(institution)
                .clickOnLocationDropdown()
                .enterUsername(username)
                .enterFullName(fullName)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .selectUserType(siteAdminUserType)
                .enterEmail(email)
                .checkActiveCheckbox()
                .checkRegionalAccessCheckbox()
                .assertVisibilityOfLocationIsRequiredMessage();
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
