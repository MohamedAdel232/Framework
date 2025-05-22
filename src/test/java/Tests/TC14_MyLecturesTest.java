package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC14_MyLecturesTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils lecturesTestData;

    @Test
    public void myLecturesTC() throws InterruptedException {
        String title = lecturesTestData.getJsonData("addNewLecture.title") + "-" + TimestampUtils.getTimestamp();
        String filePath = lecturesTestData.getJsonData("addNewLecture.filePath");
        String notes = lecturesTestData.getJsonData("addNewLecture.notes");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.username"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidCredentials();

        new P02_LibraryPage(driver)
                .clickOnLibraryButton()
                .clickOnLecturesButton()
                .clickOnMyLecturesButton()
                .clickOnNewButton()
                .enterTitle(title)
                .selectAnatomy()
                .selectSubspecialty()
                .uploadFile(filePath)
                .enterNotes(notes)
                .clickOnSaveButton()
                .assertVisibilityOfLectureAddedAlert();

        new P02_LibraryPage(driver)
                .clickOnPublicLecturesButton()
                .searchForPublicLecture(title)
                .assertVisibilityOfNoDataFoundMessage();

        new P02_LibraryPage(driver)
                .clickOnUnapprovedLecturesButton()
                .searchForPublicLecture(title)
                .assertVisibilityOfNoDataFoundMessage();

        new P02_LibraryPage(driver)
                .clickOnMyLecturesButton()
                .searchForMyLecture(title)
                .checkLectureCheckbox(title)
                .clickOnEditButton()
                .checkPublicCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfMyLectureEditedAlert();

        new P02_LibraryPage(driver)
                .clickOnPublicLecturesButton()
                .searchForPublicLecture(title)
                .assertVisibilityOfPublicLecture(title);

        new P02_LibraryPage(driver)
                .clickOnUnapprovedLecturesButton()
                .searchForPublicLecture(title)
                .assertVisibilityOfNoDataFoundMessage();

        new P02_LibraryPage(driver)
                .clickOnMyLecturesButton()
                .searchForMyLecture(title)
                .checkLectureCheckbox(title)
                .clickOnDeleteButton()
                .clickOnYesButton()
                .assertVisibilityOfMyLectureDeletedAlert();

        new P02_LibraryPage(driver)
                .clickOnPublicLecturesButton()
                .searchForPublicLecture(title)
                .assertVisibilityOfNoDataFoundMessage();

        new P02_LibraryPage(driver)
                .clickOnUnapprovedLecturesButton()
                .searchForPublicLecture(title)
                .assertVisibilityOfNoDataFoundMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        lecturesTestData = new JsonUtils("LecturesTestData");
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
