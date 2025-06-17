package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P13_EmailServersAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC13_EmailServersAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils emailServersTestData;

    @Test
    public void validEmailServersTC() {
        String name = emailServersTestData.getJsonData("addNewEmailServer.name") + "-" + TimestampUtils.getTimestamp();
        String relayType = emailServersTestData.getJsonData("addNewEmailServer.relayType");
        String smtpType = emailServersTestData.getJsonData("addNewEmailServer.smtpType");
        String emailServer = emailServersTestData.getJsonData("addNewEmailServer.emailServer");
        String senderEmail = emailServersTestData.getJsonData("addNewEmailServer.senderEmail");
        String senderName = emailServersTestData.getJsonData("addNewEmailServer.senderName");
        String smtpServer = emailServersTestData.getJsonData("addNewEmailServer.smtpServer");
        String smtpPortNo = emailServersTestData.getJsonData("addNewEmailServer.smtpPortNo");
        String smtpUsername = emailServersTestData.getJsonData("addNewEmailServer.smtpUsername");
        String smtpPassword = emailServersTestData.getJsonData("addNewEmailServer.smtpPassword");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnEmailSettingsButton()
                .clickOnEmailServersButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(relayType)
                .enterEmailServer(emailServer)
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .clickOnSaveButton()
                .assertVisibilityOfEmailServerAddedAlert();

        new P13_EmailServersAdminPage(driver)
                .clickOnOkButton()
                .searchEmailServersByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertVisibilityOfEmailServerEditedAlert();

        new P13_EmailServersAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfEmailServerDeletedAlert();

        new P13_EmailServersAdminPage(driver)
                .clickOnOkButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(smtpType)
                .enterSMTPServer(smtpServer)
                .enterSMTPPortNo(smtpPortNo)
                .enterSMTPUsername(smtpUsername)
                .enterSMTPPassword(smtpPassword)
                .clickOnEnableSSLCheckbox()
                .clickOnEnableLDAPAuthCheckbox()
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .clickOnSaveButton()
                .assertVisibilityOfEmailServerAddedAlert();

        new P13_EmailServersAdminPage(driver)
                .clickOnOkButton()
                .searchEmailServersByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertVisibilityOfEmailServerEditedAlert();

        new P13_EmailServersAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfEmailServerDeletedAlert();
    }

    @Test
    public void invalidEmailServersTC() {
        String name = emailServersTestData.getJsonData("addNewEmailServer.name") + "-" + TimestampUtils.getTimestamp();
        String relayType = emailServersTestData.getJsonData("addNewEmailServer.relayType");
        String smtpType = emailServersTestData.getJsonData("addNewEmailServer.smtpType");
        String emailServer = emailServersTestData.getJsonData("addNewEmailServer.emailServer");
        String senderEmail = emailServersTestData.getJsonData("addNewEmailServer.senderEmail");
        String invalidSenderEmail = emailServersTestData.getJsonData("addNewEmailServer.invalidSenderEmail");
        String senderName = emailServersTestData.getJsonData("addNewEmailServer.senderName");
        String smtpServer = emailServersTestData.getJsonData("addNewEmailServer.smtpServer");
        String smtpPortNo = emailServersTestData.getJsonData("addNewEmailServer.smtpPortNo");
        String lessThanZeroSMTPPortNo = emailServersTestData.getJsonData("addNewEmailServer.lessThanZeroSMTPPortNo");
        String smtpUsername = emailServersTestData.getJsonData("addNewEmailServer.smtpUsername");
        String smtpPassword = emailServersTestData.getJsonData("addNewEmailServer.smtpPassword");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnEmailSettingsButton()
                .clickOnEmailServersButton()
                .clickOnAddNewEmailServerButton()
                .enterName("")
                .selectType(relayType)
                .enterEmailServer(emailServer)
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfEmptyNameMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .clickOnTypeDropdown()
                .enterName(name)
                .selectSite()
                .assertVisibilityOfEmptyTypeMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(relayType)
                .enterEmailServer("")
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfEmptyEmailServerMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(relayType)
                .enterEmailServer(emailServer)
                .enterSenderEmail("")
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfEmptySenderEmailMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(relayType)
                .enterEmailServer(emailServer)
                .enterSenderEmail(senderEmail)
                .enterSenderName("")
                .selectSite()
                .assertVisibilityOfEmptySenderNameMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .clickOnSiteDropdown()
                .enterName(name)
                .selectType(relayType)
                .enterEmailServer(emailServer)
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .assertVisibilityOfEmptySiteMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(smtpType)
                .enterSMTPServer("")
                .enterSMTPPortNo(smtpPortNo)
                .enterSMTPUsername(smtpUsername)
                .enterSMTPPassword(smtpPassword)
                .clickOnEnableSSLCheckbox()
                .clickOnEnableLDAPAuthCheckbox()
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfEmptySMTPServerMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(smtpType)
                .enterSMTPServer(smtpServer)
                .enterSMTPPortNo("")
                .enterSMTPUsername(smtpUsername)
                .enterSMTPPassword(smtpPassword)
                .clickOnEnableSSLCheckbox()
                .clickOnEnableLDAPAuthCheckbox()
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfEmptySMTPPortNoMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(smtpType)
                .enterSMTPServer(smtpServer)
                .enterSMTPPortNo(smtpPortNo)
                .enterSMTPUsername("")
                .enterSMTPPassword(smtpPassword)
                .clickOnEnableSSLCheckbox()
                .clickOnEnableLDAPAuthCheckbox()
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfEmptySMTPUsernameMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(smtpType)
                .enterSMTPServer(smtpServer)
                .enterSMTPPortNo(smtpPortNo)
                .enterSMTPUsername(smtpUsername)
                .enterSMTPPassword("")
                .clickOnEnableSSLCheckbox()
                .clickOnEnableLDAPAuthCheckbox()
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfEmptySMTPPasswordMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(" ")
                .selectType(relayType)
                .enterEmailServer(emailServer)
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfSpacesOnlyNameMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(relayType)
                .enterEmailServer(" ")
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfSpacesOnlyEmailServerMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(relayType)
                .enterEmailServer(emailServer)
                .enterSenderEmail(" ")
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfSpacesOnlySenderEmailMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(relayType)
                .enterEmailServer(emailServer)
                .enterSenderEmail(senderEmail)
                .enterSenderName(" ")
                .selectSite()
                .assertVisibilityOfSpacesOnlySenderNameMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(smtpType)
                .enterSMTPServer(" ")
                .enterSMTPPortNo(smtpPortNo)
                .enterSMTPUsername(smtpUsername)
                .enterSMTPPassword(smtpPassword)
                .clickOnEnableSSLCheckbox()
                .clickOnEnableLDAPAuthCheckbox()
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfSpacesOnlySMTPServerMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(relayType)
                .enterEmailServer(emailServer)
                .enterSenderEmail(invalidSenderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfInvalidSenderEmailMessage();

        new P13_EmailServersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewEmailServerButton()
                .enterName(name)
                .selectType(smtpType)
                .enterSMTPServer(smtpServer)
                .enterSMTPPortNo(lessThanZeroSMTPPortNo)
                .enterSMTPUsername(smtpUsername)
                .enterSMTPPassword(smtpPassword)
                .clickOnEnableSSLCheckbox()
                .clickOnEnableLDAPAuthCheckbox()
                .enterSenderEmail(senderEmail)
                .enterSenderName(senderName)
                .selectSite()
                .assertVisibilityOfLessThanZeroPortNoMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        emailServersTestData = new JsonUtils("EmailServersTestData");
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

