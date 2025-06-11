package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P08_WebConferencingToolsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC08_WebConferencingToolsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils webConferencingToolsTestData;

    @Test
    public void validWebConferencingToolsTC() {
        String name = webConferencingToolsTestData.getJsonData("addNewWebConferencingTool.webConferencingToolName") + TimestampUtils.getTimestamp();
        String applicationID = webConferencingToolsTestData.getJsonData("addNewWebConferencingTool.applicationID");
        String directoryID = webConferencingToolsTestData.getJsonData("addNewWebConferencingTool.directoryID");
        String clientSecret = webConferencingToolsTestData.getJsonData("addNewWebConferencingTool.clientSecret");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnWebConferencingToolsButton()
                .clickOnAddNewWebConferencingToolButton()
                .selectType()
                .enterWebConferencingToolName(name)
                .enterApplicationId(applicationID)
                .enterDirectoryId(directoryID)
                .enterClientSecret(clientSecret)
                .selectSite()
                .checkActiveCheckbox()
                .clickOnSaveButton()
        // .assertVisibilityOfWebConferencingToolAddedAlert()
        ;

        new P08_WebConferencingToolsAdminPage(driver)
                //.clickOnOkButton()
                .searchWebConferencingToolByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertVisibilityOfWebConferencingToolEditedAlert();

        new P08_WebConferencingToolsAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfWebConferencingToolDeletedAlert();
    }

    @Test
    public void invalidWebConferencingToolsTC() {
        String name = webConferencingToolsTestData.getJsonData("addNewWebConferencingTool.webConferencingToolName") + TimestampUtils.getTimestamp();
        String applicationID = webConferencingToolsTestData.getJsonData("addNewWebConferencingTool.applicationID");
        String directoryID = webConferencingToolsTestData.getJsonData("addNewWebConferencingTool.directoryID");
        String clientSecret = webConferencingToolsTestData.getJsonData("addNewWebConferencingTool.clientSecret");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnWebConferencingToolsButton()
                .clickOnAddNewWebConferencingToolButton()
                .selectType()
                .enterWebConferencingToolName("")
                .enterApplicationId(applicationID)
                .enterDirectoryId(directoryID)
                .enterClientSecret(clientSecret)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyNameMessage();

        new P08_WebConferencingToolsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewWebConferencingToolButton()
                .selectType()
                .enterWebConferencingToolName(name)
                .enterApplicationId("")
                .enterDirectoryId(directoryID)
                .enterClientSecret(clientSecret)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyApplicationIdMessage();

        new P08_WebConferencingToolsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewWebConferencingToolButton()
                .selectType()
                .enterWebConferencingToolName(name)
                .enterApplicationId(applicationID)
                .enterDirectoryId("")
                .enterClientSecret(clientSecret)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyDirectoryIdMessage();

        new P08_WebConferencingToolsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewWebConferencingToolButton()
                .selectType()
                .enterWebConferencingToolName(name)
                .enterApplicationId(applicationID)
                .enterDirectoryId(directoryID)
                .enterClientSecret("")
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyClientSecretMessage();

        new P08_WebConferencingToolsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewWebConferencingToolButton()
                .clickOnSiteDropdown()
                .selectType()
                .enterWebConferencingToolName(name)
                .enterApplicationId(applicationID)
                .enterDirectoryId(directoryID)
                .enterClientSecret(clientSecret)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptySiteMessage();

        new P08_WebConferencingToolsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewWebConferencingToolButton()
                .selectType()
                .enterWebConferencingToolName(" ")
                .enterApplicationId(applicationID)
                .enterDirectoryId(directoryID)
                .enterClientSecret(clientSecret)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfSpacesOnlyNameMessage();

        new P08_WebConferencingToolsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewWebConferencingToolButton()
                .selectType()
                .enterWebConferencingToolName(name)
                .enterApplicationId(" ")
                .enterDirectoryId(directoryID)
                .enterClientSecret(clientSecret)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfSpacesOnlyApplicationIdMessage();

        new P08_WebConferencingToolsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewWebConferencingToolButton()
                .selectType()
                .enterWebConferencingToolName(name)
                .enterApplicationId(applicationID)
                .enterDirectoryId(" ")
                .enterClientSecret(clientSecret)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfSpacesOnlyDirectoryIdMessage();

        new P08_WebConferencingToolsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewWebConferencingToolButton()
                .selectType()
                .enterWebConferencingToolName(name)
                .enterApplicationId(applicationID)
                .enterDirectoryId(directoryID)
                .enterClientSecret(" ")
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfSpacesOnlyClientSecretMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        webConferencingToolsTestData = new JsonUtils("WebConferencingToolsTestData");
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