package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P03_InstitutionsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC03_InstitutionsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils institutionsTestData;

    @Test
    public void validInstitutionsTC() {
        String institutionName = institutionsTestData.getJsonData("addNewInstitutions.institutionName") + TimestampUtils.getTimestamp();
        String studyExpiration = institutionsTestData.getJsonData("addNewInstitutions.studyExpiration");
        String expiration = institutionsTestData.getJsonData("addNewInstitutions.expiration");
        String attempts = institutionsTestData.getJsonData("addNewInstitutions.attempts");
        String resendLimit = institutionsTestData.getJsonData("addNewInstitutions.resendLimit");
        String otpMessage = institutionsTestData.getJsonData("addNewInstitutions.otpMessage");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnInstitutionsButton()
                .clickOnAddInstitutionButton()
                .enterInstitutionName(institutionName)
                .enterStudyExpiration(studyExpiration)
                .clickOnActiveCheckbox()
                .enterExpiration(expiration)
                .enterAttempts(attempts)
                .enterResendLimit(resendLimit)
                .enterOtpMessage(otpMessage)
                .clickOnSaveButton()
                .assertVisibilityOfInstitutionAddedAlert();

        new P03_InstitutionsAdminPage(driver)
                .clickOnOkButton()
                .searchForInstitutionByName(institutionName)
                .clickOnEditButton(institutionName)
                .clickOnSaveButton()
                .assertVisibilityOfInstitutionEditedAlert();

        new P03_InstitutionsAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(institutionName)
                .clickOnYesButton()
                .assertVisibilityOfInstitutionDeletedAlert();
    }

    @Test
    public void invalidInstitutionsTC() {
        String institutionName = institutionsTestData.getJsonData("addNewInstitutions.institutionName") + TimestampUtils.getTimestamp();
        String studyExpiration = institutionsTestData.getJsonData("addNewInstitutions.studyExpiration");
        String expiration = institutionsTestData.getJsonData("addNewInstitutions.expiration");
        String attempts = institutionsTestData.getJsonData("addNewInstitutions.attempts");
        String resendLimit = institutionsTestData.getJsonData("addNewInstitutions.resendLimit");
        String otpMessage = institutionsTestData.getJsonData("addNewInstitutions.otpMessage");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnInstitutionsButton()
                .clickOnAddInstitutionButton()
                .enterStudyExpiration(studyExpiration)
                .clickOnActiveCheckbox()
                .enterExpiration(expiration)
                .enterAttempts(attempts)
                .enterResendLimit(resendLimit)
                .enterOtpMessage(otpMessage)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyInstitutionNameMessage();

        new P03_InstitutionsAdminPage(driver)
                .clickOnOkButton()
                .clickOnCloseButton()
                .clickOnAddInstitutionButton()
                .enterInstitutionName(institutionName)
                .enterStudyExpiration(" ")
                .clickOnActiveCheckbox()
                .enterExpiration(expiration)
                .enterAttempts(attempts)
                .enterResendLimit(resendLimit)
                .enterOtpMessage(otpMessage)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyStudyExpirationMessage();

        new P03_InstitutionsAdminPage(driver)
                .clickOnOkButton()
                .clickOnCloseButton()
                .clickOnAddInstitutionButton()
                .enterInstitutionName(institutionName)
                .enterStudyExpiration(studyExpiration)
                .clickOnActiveCheckbox()
                .enterAttempts(attempts)
                .enterResendLimit(resendLimit)
                .enterOtpMessage(otpMessage)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyExpirationMessage();

        new P03_InstitutionsAdminPage(driver)
                .clickOnOkButton()
                .clickOnCloseButton()
                .clickOnAddInstitutionButton()
                .enterInstitutionName(institutionName)
                .enterStudyExpiration(studyExpiration)
                .clickOnActiveCheckbox()
                .enterExpiration(expiration)
                .enterResendLimit(resendLimit)
                .enterOtpMessage(otpMessage)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyAttemptsMessage();

        new P03_InstitutionsAdminPage(driver)
                .clickOnOkButton()
                .clickOnCloseButton()
                .clickOnAddInstitutionButton()
                .enterInstitutionName(institutionName)
                .enterStudyExpiration(studyExpiration)
                .clickOnActiveCheckbox()
                .enterExpiration(expiration)
                .enterAttempts(attempts)
                .enterOtpMessage(otpMessage)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyResendLimitMessage();

        new P03_InstitutionsAdminPage(driver)
                .clickOnOkButton()
                .clickOnCloseButton()
                .clickOnAddInstitutionButton()
                .enterInstitutionName(institutionName)
                .enterStudyExpiration(studyExpiration)
                .clickOnActiveCheckbox()
                .enterExpiration(expiration)
                .enterAttempts(attempts)
                .enterResendLimit(resendLimit)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyOtpMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        institutionsTestData = new JsonUtils("InstitutionsTestData");
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