package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P09_WebConferencingToolsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC09_WebConferencingToolsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils webConferencingToolsTestData;

    @Test
    public void webConferencingToolsTC() throws InterruptedException {
        String webConferencingToolsType = webConferencingToolsTestData.getJsonData("addNewWebConferencingTools.type");
        String webConferencingToolsName = webConferencingToolsTestData.getJsonData("addNewWebConferencingTools.name") + "-" + TimestampUtils.getTimestamp();
        String webConferencingToolsApplicationId = webConferencingToolsTestData.getJsonData("addNewWebConferencingTools.applicationId");
        String webConferencingToolsDirectoryId = webConferencingToolsTestData.getJsonData("addNewWebConferencingTools.directoryId");
        String webConferencingToolsClientSecret = webConferencingToolsTestData.getJsonData("addNewWebConferencingTools.clientSecret");
        String webConferencingToolsSite = webConferencingToolsTestData.getJsonData("addNewWebConferencingTools.applicationId");

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
                .clickOnGeneralConfigButton()
                .clickOnWebConferencingToolsButton()
                .clickOnAddButton()
                .selectType()
                .enterName(webConferencingToolsName)
                .enterApplicationId(webConferencingToolsApplicationId)
                .enterDirectoryId(webConferencingToolsDirectoryId)
                .enterClientSecret(webConferencingToolsClientSecret)
                .selectSite()
                .clickOnActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfWebConferencingToolsAddedAlert();

        new P09_WebConferencingToolsAdminPage(driver)
                .clickOnEditButton(webConferencingToolsName)
                .clickOnSaveButton()
                .assertVisibilityOfWebConferencingToolsEditedAlert();

        new P09_WebConferencingToolsAdminPage(driver)
                .clickOnDeleteButton(webConferencingToolsName)
                .clickOnYesButton()
                .assertVisibilityOfWebConferencingToolsDeletedAlert();
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


