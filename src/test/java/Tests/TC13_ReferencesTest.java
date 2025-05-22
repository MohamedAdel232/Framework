package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P13_ReferencesPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC13_ReferencesTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils referencesTestData;

    @Test
    public void referencesTC() throws InterruptedException {
        String title = referencesTestData.getJsonData("addNewReference.title") + "-" + TimestampUtils.getTimestamp();
        String filePath = referencesTestData.getJsonData("addNewReference.filePath");
        String notes = referencesTestData.getJsonData("addNewReference.notes");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.username"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidCredentials();

        new P02_LibraryPage(driver)
                .clickOnLibraryButton()
                .clickOnReferencesButton()
                .clickOnNewButton()
                .enterTitle(title)
                .selectAnatomy()
                .selectSubspecialty()
                .uploadFile(filePath)
                .enterNotes(notes)
                .clickOnSaveButton()
                .assertVisibilityOfReferenceAddedAlert();

        new P13_ReferencesPage(driver)
                .checkReferenceCheckbox(title)
                .clickOnEditButton()
                .clickOnSaveButton()
                .assertVisibilityOfReferenceEditedAlert();

        new P13_ReferencesPage(driver)
                .clickOnScheduleButton()
                .selectScheduledMeeting()
                .assertVisibilityOfReferenceScheduledAlert();

        new P13_ReferencesPage(driver)
                .clickOnDeleteButton()
                .clickOnYesButton()
                .assertVisibilityOfReferenceDeletedAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        referencesTestData = new JsonUtils("ReferencesTestData");
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
