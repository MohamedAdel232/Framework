package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P14_MyLecturesPage;
import Pages.P15_PublicLecturesPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC15_PublicLecturesTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils myLecturesTestData;

    @Test
    public void deletePublicLectureTC() throws InterruptedException {
        String title = myLecturesTestData.getJsonData("addNewLecture.title") + "-" + TimestampUtils.getTimestamp();
        String filePath = myLecturesTestData.getJsonData("addNewLecture.filePath");
        String notes = myLecturesTestData.getJsonData("addNewLecture.notes");

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
                .checkPublicCheckbox()
                .uploadFile(filePath)
                .enterNotes(notes)
                .clickOnSaveButton()
                .assertVisibilityOfLectureAddedAlert();

        new P02_LibraryPage(driver)
                .clickOnPublicLecturesButton()
                .searchForPublicLecture(title)
                .checkLectureCheckbox(title)
                .clickOnDeleteButton()
                .clickOnYesButton()
                .assertVisibilityOfPublicLectureDeletedAlert();

        new P15_PublicLecturesPage(driver)
                .searchForPublicLecture(title)
                .assertVisibilityOfNoDataFoundMessage();

        new P02_LibraryPage(driver)
                .clickOnMyLecturesButton()
                .searchForMyLecture(title)
                .assertVisibilityOfMyLecture(title);

        new P14_MyLecturesPage(driver)
                .checkLectureCheckbox(title)
                .clickOnDeleteButton()
                .clickOnYesButton()
                .assertVisibilityOfMyLectureDeletedAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        myLecturesTestData = new JsonUtils("MyLecturesTestData");
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