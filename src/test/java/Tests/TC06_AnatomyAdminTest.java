package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P06_AnatomyAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC06_AnatomyAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils anatomyTestData;

    @Test
    public void anatomyTC() throws InterruptedException {
        String anatomyName = anatomyTestData.getJsonData("addNewAnatomy.anatomyName") + "-" + TimestampUtils.getTimestamp();
        String acrCode = anatomyTestData.getJsonData("addNewAnatomy.acrCode");

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
                .clickOnAnatomyButton()
                .clickOnAddButton()
                .enterName(anatomyName)
                .enterACRCode(acrCode)
                .clickOnSaveButton()
                .assertVisibilityOfAnatomyAddedAlert();

        new P06_AnatomyAdminPage(driver)
                .searchForAnatomy(anatomyName)
                .clickOnEditButton(anatomyName)
                .clickOnSaveButton()
                .assertVisibilityOfAnatomyEditedAlert();

        new P06_AnatomyAdminPage(driver)
                .searchForAnatomy(anatomyName)
                .clickOnDeleteButton(anatomyName)
                .clickOnYesButton()
                .assertVisibilityOfAnatomyDeletedAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        anatomyTestData = new JsonUtils("AnatomyTestData");
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
