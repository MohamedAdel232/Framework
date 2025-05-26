package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P20_ORUProfilesAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC20_ORUProfilesAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils oruProfilesTestData;

    @Test
    public void scheduledMeetingTC() throws InterruptedException {
        String oruProfileName = oruProfilesTestData.getJsonData("addNewORUProfiles.name") + "-" + TimestampUtils.getTimestamp();
        String oruProfilePreliminary = oruProfilesTestData.getJsonData("addNewORUProfiles.preliminary");
        String oruProfileFinal = oruProfilesTestData.getJsonData("addNewORUProfiles.final");
        String oruProfileAddendum = oruProfilesTestData.getJsonData("addNewORUProfiles.addendum");
        String risSendingApp = oruProfilesTestData.getJsonData("addNewORUProfiles.risSendingApp");
        String accessionNumber = oruProfilesTestData.getJsonData("addNewORUProfiles.accessionNumber");
        String reportDate = oruProfilesTestData.getJsonData("addNewORUProfiles.reportDate");
        String reportStatus = oruProfilesTestData.getJsonData("addNewORUProfiles.reportStatus");
        String fieldNo = oruProfilesTestData.getJsonData("addNewORUProfiles.fieldNo");
        String repeat = oruProfilesTestData.getJsonData("addNewORUProfiles.repeat");
        String component = oruProfilesTestData.getJsonData("addNewORUProfiles.component");
        String subComponent = oruProfilesTestData.getJsonData("addNewORUProfiles.subComponent");

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
                .clickOnHL7ConfigButton()
                .clickOnORUProfilesButton()
                .clickOnAddButton()
                .enterORUProfileName(oruProfileName)
                .selectSite()
                .enterPreliminary(oruProfilePreliminary)
                .enterFinal(oruProfileFinal)
                .enterAddendum(oruProfileAddendum)
                .checkPatientIDCheckbox()
                .checkPatientNameCheckbox()
                .checkAccessionNumberCheckbox()
                .checkReportingPhysiciansCheckbox()
                .checkRISUserIDCheckbox()
                .checkStudyDateCheckbox()
                .checkReportDateCheckbox()
                .enterRISSendingApp(risSendingApp)
                .clickOnAddNewAttributeButton()
                .addORUAttribute(accessionNumber, reportDate, reportStatus, fieldNo, repeat, component, subComponent)
                .clickOnSaveORUAttributeButton()
                .clickOnSaveButton()
                .assertVisibilityOfORUProfileAddedAlert();

        new P20_ORUProfilesAdminPage(driver)
                .searchForORUProfile(oruProfileName)
                .clickOnEditButton(oruProfileName)
                .clickOnSaveButton()
                .assertVisibilityOfORUProfileEditedAlert();

        new P20_ORUProfilesAdminPage(driver)
                .searchForORUProfile(oruProfileName)
                .clickOnDeleteButton(oruProfileName)
                .clickOnYesButton()
                .assertVisibilityOfORUProfileDeletedAlert(oruProfileName);
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        oruProfilesTestData = new JsonUtils("ORUProfilesTestData");
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

