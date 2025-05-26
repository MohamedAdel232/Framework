package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P19_SchedulerPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC19_SchedulerTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils meetingTestData;

    @Test
    public void scheduledMeetingTC() throws InterruptedException {
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

        new P19_SchedulerPage(driver)
                .deleteAllMeetings();

        new P02_LibraryPage(driver)
                .clickOnLibraryButton()
                .clickOnMeetingsButton()
                .clickOnSchedulerButton()
                .clickOnMyMeetingsButton()
                .clickOnTodayButton()
                .clickOnAddMeetingButton()
                .enterMeetingName(meetingName)
                .enterLocation(meetingLocation)
                .selectSubspecialty()
                .clickOnAddStudiesButton()
                .selectACRCode(meetingACRCode)
                .clickOnAddMeetingStudyButton()
                .clickOnSaveMeetingButton()
                .assertVisibilityOfMeetingAddedAlert();

        new P19_SchedulerPage(driver)
                .clickOnMyMeetingsButton()
                .clickOnTodayButton()
                .clickOnEditMeetingButton()
                .clickOnSaveMeetingButton()
                .assertVisibilityOfMeetingEditedAlert();

        new P19_SchedulerPage(driver)
                .clickOnMyMeetingsButton()
                .clickOnTodayButton()
                .clickOnDeleteMeetingButton()
                .clickOnYesButton()
                .assertVisibilityOfMeetingDeletedAlert();
    }

    @Test
    public void runMeetingTC() throws InterruptedException {
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

        new P19_SchedulerPage(driver)
                .deleteAllMeetings();

        new P02_LibraryPage(driver)
                .clickOnLibraryButton()
                .clickOnMeetingsButton()
                .clickOnSchedulerButton()
                .clickOnMyMeetingsButton()
                .clickOnTodayButton()
                .clickOnAddMeetingButton()
                .enterMeetingName(meetingName)
                .enterLocation(meetingLocation)
                .selectSubspecialty()
                .clickOnAddStudiesButton()
                .selectACRCode(meetingACRCode)
                .clickOnAddMeetingStudyButton()
                .clickOnSaveMeetingButton()
                .assertVisibilityOfMeetingAddedAlert();

        String meetingWindowHandle = new P19_SchedulerPage(driver).getMeetingPageWindowHandle();

        new P19_SchedulerPage(driver)
                .clickOnMyMeetingsButton()
                .clickOnTodayButton()
                .clickOnRunMeetingButton()
                .assertVisibilityOfMeetingRunAlert();

        new P19_SchedulerPage(driver)
                .switchToMeetingRunPageWindow(meetingWindowHandle)
                .assertMeetingRunPageUrl();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
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
