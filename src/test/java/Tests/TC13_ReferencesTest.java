package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P13_ReferencesPage;
import Pages.P19_SchedulerPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC13_ReferencesTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils referencesTestData;
    JsonUtils meetingTestData;


    @Test
    public void referencesTC() throws InterruptedException {
        String title = referencesTestData.getJsonData("addNewReference.title") + "-" + TimestampUtils.getTimestamp();
        String filePath = referencesTestData.getJsonData("addNewReference.filePath");
        String notes = referencesTestData.getJsonData("addNewReference.notes");
        String meetingName = meetingTestData.getJsonData("addNewMeeting.name") + "-" + TimestampUtils.getTimestamp();
        String meetingLocation = meetingTestData.getJsonData("addNewMeeting.location");
        String meetingACRCode = meetingTestData.getJsonData("addNewMeeting.acrCode");

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

        new P19_SchedulerPage(driver)
                .deleteAllMeetings();

        new P02_LibraryPage(driver)
                .clickOnMeetingsButton()
                .clickOnSchedulerButton()
                .clickOnMyMeetingsButton()
                .clickOnTodayButton()
                .clickOnAddMeetingButtonFromContextMenu()
                .enterMeetingName(meetingName)
                .enterLocation(meetingLocation)
                .selectSubspecialty()
                .clickOnAddStudiesButton()
                .selectACRCode(meetingACRCode)
                .clickOnAddMeetingStudyButton()
                .clickOnSaveMeetingButton()
                .assertVisibilityOfMeetingAddedAlert();

        new P02_LibraryPage(driver)
                .clickOnReferencesButton()
                .checkReferenceCheckbox(title)
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
        meetingTestData = new JsonUtils("MeetingTestData");
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
