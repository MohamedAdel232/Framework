package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P18_ImagePresetsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC18_ImagePresetsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils imagePresetsTestData;

    @Test
    public void imagePresetsTC() throws InterruptedException {
        String presetMenuName = imagePresetsTestData.getJsonData("addNewImagePreset.presetMenuName") + "-" + TimestampUtils.getTimestamp();
        String presetName = imagePresetsTestData.getJsonData("addNewImagePreset.presetName");
        String wl = imagePresetsTestData.getJsonData("addNewImagePreset.wl");
        String ww = imagePresetsTestData.getJsonData("addNewImagePreset.ww");

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
                .clickOnImagePresetsButton()
                .clickOnAddButton()
                .enterPresetMenuName(presetMenuName)
                .selectModality()
                .selectSite()
                .enterPresetName(presetName)
                .enterWL(wl)
                .enterWW(ww)
                .selectShortcut()
                .clickOnAddPresetsButton()
                .clickOnSaveButton()
                .assertVisibilityOfImagePresetAddedAlert();

        new P18_ImagePresetsAdminPage(driver)
                .searchForImagePreset(presetName)
                .clickOnEditButton(presetName)
                .clickOnSaveButton()
                .assertVisibilityOfImagePresetEditedAlert();

        new P18_ImagePresetsAdminPage(driver)
                .searchForImagePreset(presetName)
                .clickOnDeleteButton(presetName)
                .clickOnYesButton()
                .assertVisibilityOfImagePresetDeletedAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        imagePresetsTestData = new JsonUtils("ImagePresetsTestData");
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