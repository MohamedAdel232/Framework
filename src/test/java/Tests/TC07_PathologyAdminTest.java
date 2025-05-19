package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P07_PathologyAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC07_PathologyAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils pathologyTestData;

    @Test
    public void pathologyTC() throws InterruptedException {
        String pathologyName = pathologyTestData.getJsonData("addNewPathology.pathologyName") + "-" + TimestampUtils.getTimestamp();
        String acrCode = pathologyTestData.getJsonData("addNewPathology.acrCode");

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
                .clickOnPathologyButton()
                .clickOnAddButton()
                .enterName(pathologyName)
                .enterACRCode(acrCode)
                .selectAnatomy()
                .clickOnSaveButton()
                .assertVisibilityOfPathologyAddedAlert();

        new P07_PathologyAdminPage(driver)
                .searchForPathology(pathologyName)
                .clickOnEditButton(pathologyName)
                .clickOnSaveButton()
                .assertVisibilityOfPathologyEditedAlert();

        new P07_PathologyAdminPage(driver)
                .searchForPathology(pathologyName)
                .clickOnDeleteButton(pathologyName)
                .clickOnYesButton()
                .assertVisibilityOfPathologyDeletedAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        pathologyTestData = new JsonUtils("PathologyTestData");
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
