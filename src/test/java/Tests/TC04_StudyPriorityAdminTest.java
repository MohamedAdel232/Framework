package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P04_StudyPriorityAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC04_StudyPriorityAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils studyPriorityTestData;

    @Test
    public void validStudyPriorityTC() {
        String studyPriorityName = studyPriorityTestData.getJsonData("addNewStudyPriority.studyPriorityName") + TimestampUtils.getTimestamp();
        String studyPriorityHL7Value = studyPriorityTestData.getJsonData("addNewStudyPriority.studyPriorityHL7Value");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnGeneralConfigButton()
                .clickOnWorklistMappingButton()
                .clickOnStudyPriorityAdminButton()
                .clickOnAddStudyPriorityButton()
                .enterStudyPriorityName(studyPriorityName)
                .enterStudyPriorityHL7Value(studyPriorityHL7Value)
                .clickOnSaveButton()
                .assertVisibilityOfStudyPriorityAddedAlert();

        new P04_StudyPriorityAdminPage(driver)
                .searchForStudyPriorityByName(studyPriorityName)
                .clickOnEditButton(studyPriorityName)
                .clickOnSaveButton()
                .assertVisibilityOfStudyPriorityEditedAlert();

        new P04_StudyPriorityAdminPage(driver)
                .searchForStudyPriorityByName(studyPriorityName)
                .clickOnDeleteButton(studyPriorityName)
                .clickOnYesButton()
                .assertVisibilityOfStudyPriorityDeletedAlert();
    }

    @Test
    public void invalidStudyPriorityTC() {
        String studyPriorityName = studyPriorityTestData.getJsonData("addNewStudyPriority.studyPriorityName") + TimestampUtils.getTimestamp();
        String studyPriorityHL7Value = studyPriorityTestData.getJsonData("addNewStudyPriority.studyPriorityHL7Value");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnGeneralConfigButton()
                .clickOnWorklistMappingButton()
                .clickOnStudyPriorityAdminButton()
                .clickOnAddStudyPriorityButton()
                .enterStudyPriorityHL7Value(studyPriorityHL7Value)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyNameFieldMessage();

        new P04_StudyPriorityAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddStudyPriorityButton()
                .enterStudyPriorityName(studyPriorityName)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyHL7ValueFieldMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        studyPriorityTestData = new JsonUtils("StudyPriorityTestData");
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