package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P14_EmailTemplateManagerAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC14_EmailTemplateManagerAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils emailTemplateManagerTestData;

    @Test
    public void validEmailTemplateManagerTC() {
        String name = emailTemplateManagerTestData.getJsonData("addNewEmailTemplateManager.name") + "-" + TimestampUtils.getTimestamp();
        String subject = emailTemplateManagerTestData.getJsonData("addNewEmailTemplateManager.subject");
        String body = emailTemplateManagerTestData.getJsonData("addNewEmailTemplateManager.body");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnEmailSettingsButton()
                .clickOnEmailTemplateManagerButton()
                .clickOnAddNewEmailTemplateManagerButton()
                .enterName(name)
                .selectType()
                .selectSite()
                .clickOnActiveCheckbox()
                .enterSubject(subject)
                .enterBody(body)
                .clickOnSaveButton();

        new P14_EmailTemplateManagerAdminPage(driver)
                .searchEmailTemplateManagerByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertVisibilityOfEmailTemplateManagerEditedAlert();

        new P14_EmailTemplateManagerAdminPage(driver)
                .clickOnOkButton()
                .searchEmailTemplateManagerByName(name)
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfEmailTemplateManagerDeletedAlert();
    }

    @Test
    public void invalidEmailTemplateManagerTC() {
        String name = emailTemplateManagerTestData.getJsonData("addNewEmailTemplateManager.name") + "-" + TimestampUtils.getTimestamp();
        String subject = emailTemplateManagerTestData.getJsonData("addNewEmailTemplateManager.subject");
        String body = emailTemplateManagerTestData.getJsonData("addNewEmailTemplateManager.body");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnEmailSettingsButton()
                .clickOnEmailTemplateManagerButton()
                .clickOnAddNewEmailTemplateManagerButton()
                .enterName("")
                .selectType()
                .selectSite()
                .clickOnActiveCheckbox()
                .enterSubject(subject)
                .enterBody(body)
                .assertVisibilityOfEmptyNameMessage();

        new P14_EmailTemplateManagerAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewEmailTemplateManagerButton()
                .clickOnTypeDropdown()
                .enterName(name)
                .selectSite()
                .clickOnActiveCheckbox()
                .enterSubject(subject)
                .enterBody(body)
                .assertVisibilityOfEmptyTypeMessage();

        new P14_EmailTemplateManagerAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewEmailTemplateManagerButton()
                .clickOnTypeDropdown()
                .enterName(name)
                .selectSite()
                .clickOnActiveCheckbox()
                .enterSubject(subject)
                .enterBody(body)
                .assertVisibilityOfEmptyTypeMessage();

        new P14_EmailTemplateManagerAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewEmailTemplateManagerButton()
                .clickOnSiteDropdown()
                .enterName(name)
                .selectType()
                .clickOnActiveCheckbox()
                .enterSubject(subject)
                .enterBody(body)
                .assertVisibilityOfEmptySiteMessage();

        new P14_EmailTemplateManagerAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewEmailTemplateManagerButton()
                .enterName(name)
                .selectType()
                .selectSite()
                .clickOnActiveCheckbox()
                .enterSubject("")
                .enterBody(body)
                .assertVisibilityOfEmptySubjectMessage();

        new P14_EmailTemplateManagerAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewEmailTemplateManagerButton()
                .enterName(name)
                .selectType()
                .selectSite()
                .clickOnActiveCheckbox()
                .enterBody("")
                .enterSubject(subject)
                .assertVisibilityOfEmptyBodyMessage();

        new P14_EmailTemplateManagerAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewEmailTemplateManagerButton()
                .enterName(" ")
                .selectType()
                .selectSite()
                .clickOnActiveCheckbox()
                .enterSubject(subject)
                .enterBody(body)
                .assertVisibilityOfSpacesOnlyNameMessage();

        new P14_EmailTemplateManagerAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewEmailTemplateManagerButton()
                .enterName(name)
                .selectType()
                .selectSite()
                .clickOnActiveCheckbox()
                .enterSubject(" ")
                .enterBody(body)
                .assertVisibilityOfSpacesOnlySubjectMessage();

        new P14_EmailTemplateManagerAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewEmailTemplateManagerButton()
                .enterName(name)
                .selectType()
                .selectSite()
                .clickOnActiveCheckbox()
                .enterBody(" ")
                .enterSubject(subject)
                .assertVisibilityOfSpacesOnlyBodyMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        emailTemplateManagerTestData = new JsonUtils("EmailTemplateManagerTestData");
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
