package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P15_ORUProfilesAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC15_ORUProfilesAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils oruProfilesTestData;

    @Test
    public void validORUProfileTC() {
        String oruProfileName = oruProfilesTestData.getJsonData("addNewORUProfiles.name") + "-" + TimestampUtils.getTimestamp();
        String preliminary = oruProfilesTestData.getJsonData("addNewORUProfiles.preliminary");
        String oruFinal = oruProfilesTestData.getJsonData("addNewORUProfiles.oruFinal");
        String addendum = oruProfilesTestData.getJsonData("addNewORUProfiles.addendum");
        String risSendingApp = oruProfilesTestData.getJsonData("addNewORUProfiles.risSendingApp");
        String sendingFacility = oruProfilesTestData.getJsonData("addNewORUProfiles.sendingFacility");
        String assignedPatientLocation = oruProfilesTestData.getJsonData("addNewORUProfiles.assignedPatientLocation");
        String sendingApplication = oruProfilesTestData.getJsonData("addNewORUProfiles.sendingApplication");
        String risPatientID = oruProfilesTestData.getJsonData("addNewORUProfiles.risPatientID");
        String hospitalPatientID = oruProfilesTestData.getJsonData("addNewORUProfiles.hospitalPatientID");
        String nationalPatientID = oruProfilesTestData.getJsonData("addNewORUProfiles.nationalPatientID");
        String patientFirstName = oruProfilesTestData.getJsonData("addNewORUProfiles.patientFirstName");
        String patientLastName = oruProfilesTestData.getJsonData("addNewORUProfiles.patientLastName");
        String birthDate = oruProfilesTestData.getJsonData("addNewORUProfiles.birthDate");
        String gender = oruProfilesTestData.getJsonData("addNewORUProfiles.gender");
        String accessionNumber = oruProfilesTestData.getJsonData("addNewORUProfiles.accessionNumber");
        String reportingPhysicianFirstName = oruProfilesTestData.getJsonData("addNewORUProfiles.reportingPhysicianFirstName");
        String reportingPhysicianLastName = oruProfilesTestData.getJsonData("addNewORUProfiles.reportingPhysicianLastName");
        String reportText = oruProfilesTestData.getJsonData("addNewORUProfiles.reportText");
        String reportValueType = oruProfilesTestData.getJsonData("addNewORUProfiles.reportValueType");
        String fieldNo = oruProfilesTestData.getJsonData("addNewORUProfiles.fieldNo");
        String repeat = oruProfilesTestData.getJsonData("addNewORUProfiles.repeat");
        String component = oruProfilesTestData.getJsonData("addNewORUProfiles.component");
        String subComponent = oruProfilesTestData.getJsonData("addNewORUProfiles.subComponent");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnHL7ConfigurationsButton()
                .clickOnORUProfilesButton()
                .clickOnAddButton()
                .enterORUProfileName(oruProfileName)
                .selectSite()
                .enterPreliminary(preliminary)
                .enterFinal(oruFinal)
                .enterAddendum(addendum)
                .enterRISSendingApp(risSendingApp)
                .clickOnAddNewAttributeButton()
                .addORUAttribute(sendingFacility, assignedPatientLocation, sendingApplication, risPatientID, hospitalPatientID,
                        nationalPatientID, patientFirstName, patientLastName, birthDate, gender, accessionNumber,
                        reportingPhysicianFirstName, reportingPhysicianLastName, reportText, reportValueType,
                        fieldNo, repeat, component, subComponent)
                .clickOnSaveButton();

        new P15_ORUProfilesAdminPage(driver)
                .searchForORUProfile(oruProfileName)
                .clickOnEditButton(oruProfileName)
                .clickOnSaveButton()
                .assertVisibilityOfORUProfileEditedAlert();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnOkButton()
                .searchForORUProfile(oruProfileName)
                .clickOnDeleteButton(oruProfileName)
                .clickOnYesButton()
                .assertVisibilityOfORUProfileDeletedAlert(oruProfileName);
    }

    @Test
    public void invalidORUProfileTC() {
        String oruProfileName = oruProfilesTestData.getJsonData("addNewORUProfiles.name") + "-" + TimestampUtils.getTimestamp();
        String preliminary = oruProfilesTestData.getJsonData("addNewORUProfiles.preliminary");
        String oruFinal = oruProfilesTestData.getJsonData("addNewORUProfiles.oruFinal");
        String addendum = oruProfilesTestData.getJsonData("addNewORUProfiles.addendum");
        String risSendingApp = oruProfilesTestData.getJsonData("addNewORUProfiles.risSendingApp");
        String sendingFacility = oruProfilesTestData.getJsonData("addNewORUProfiles.sendingFacility");
        String fieldNo = oruProfilesTestData.getJsonData("addNewORUProfiles.fieldNo");
        String repeat = oruProfilesTestData.getJsonData("addNewORUProfiles.repeat");
        String component = oruProfilesTestData.getJsonData("addNewORUProfiles.component");
        String subComponent = oruProfilesTestData.getJsonData("addNewORUProfiles.subComponent");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnHL7ConfigurationsButton()
                .clickOnORUProfilesButton()
                .clickOnAddButton()
                .enterORUProfileName("")
                .selectSite()
                .enterPreliminary(preliminary)
                .enterFinal(oruFinal)
                .enterAddendum(addendum)
                .enterRISSendingApp(risSendingApp)
                .assertVisibilityOfEmptyNameFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterORUProfileName(oruProfileName)
                .clickOnSiteDropdown()
                .enterPreliminary(preliminary)
                .enterFinal(oruFinal)
                .enterAddendum(addendum)
                .enterRISSendingApp(risSendingApp)
                .assertVisibilityOfEmptySiteFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterORUProfileName(oruProfileName)
                .selectSite()
                .enterPreliminary("")
                .enterFinal(oruFinal)
                .enterAddendum(addendum)
                .enterRISSendingApp(risSendingApp)
                .assertVisibilityOfEmptyPreliminaryFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterORUProfileName(oruProfileName)
                .selectSite()
                .enterPreliminary(preliminary)
                .enterFinal("")
                .enterAddendum(addendum)
                .enterRISSendingApp(risSendingApp)
                .assertVisibilityOfEmptyFinalFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterORUProfileName(oruProfileName)
                .selectSite()
                .enterPreliminary(preliminary)
                .enterFinal(oruFinal)
                .enterAddendum("")
                .enterRISSendingApp(risSendingApp)
                .assertVisibilityOfEmptyAddendumFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterRISSendingApp("")
                .enterORUProfileName(oruProfileName)
                .selectSite()
                .enterPreliminary(preliminary)
                .enterFinal(oruFinal)
                .enterAddendum(addendum)
                .assertVisibilityOfEmptyRISSendingAppFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddButton()
                .enterORUProfileName(oruProfileName)
                .selectSite()
                .enterPreliminary(preliminary)
                .enterFinal(oruFinal)
                .enterAddendum(addendum)
                .enterRISSendingApp(risSendingApp)
                .clickOnAddNewAttributeButton()
                .clickOnNameAttributeDropdown()
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .assertVisibilityOfEmptyAttributeNameFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddNewAttributeButton()
                .selectNameAttribute(sendingFacility)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .clickOnKeySegmentDropdown()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .assertVisibilityOfEmptySegmentFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddNewAttributeButton()
                .selectNameAttribute(sendingFacility)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo("")
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .assertVisibilityOfEmptyFieldNoFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddNewAttributeButton()
                .selectNameAttribute(sendingFacility)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat("")
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .assertVisibilityOfEmptyKeyRepeatFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddNewAttributeButton()
                .selectNameAttribute(sendingFacility)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent("")
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .assertVisibilityOfEmptyComponentFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddNewAttributeButton()
                .selectNameAttribute(sendingFacility)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent("")
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .assertVisibilityOfEmptySubComponentFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddNewAttributeButton()
                .selectNameAttribute(sendingFacility)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .clickOnSegmentDropdown()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .assertVisibilityOfEmptySegmentFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddNewAttributeButton()
                .selectNameAttribute(sendingFacility)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo("")
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .assertVisibilityOfEmptyFieldNoFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddNewAttributeButton()
                .selectNameAttribute(sendingFacility)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat("")
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .assertVisibilityOfEmptyRepeatFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddNewAttributeButton()
                .selectNameAttribute(sendingFacility)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent("")
                .enterSubComponent(subComponent)
                .assertVisibilityOfEmptyComponentFieldMessage();

        new P15_ORUProfilesAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddNewAttributeButton()
                .selectNameAttribute(sendingFacility)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterSubComponent("")
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .assertVisibilityOfEmptySubComponentFieldMessage();
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

