package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P04_LocationsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC04_LocationsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils locationsTestData;

    @Test
    public void validLocationsTC() {
        String name = locationsTestData.getJsonData("addNewLocation.name") + "-" + TimestampUtils.getTimestamp();
        String hl7LocationName = locationsTestData.getJsonData("addNewLocation.hl7LocationName");
        String accessionNoPrefix = locationsTestData.getJsonData("addNewLocation.accessionNoPrefix");
        String anonymizedAccessionNoPrefix = locationsTestData.getJsonData("addNewLocation.anonymizedAccessionNoPrefix");
        String anonymizedPatientNamePrefix = locationsTestData.getJsonData("addNewLocation.anonymizedPatientNamePrefix");
        String anonymizedPatientIdPrefix = locationsTestData.getJsonData("addNewLocation.anonymizedPatientIdPrefix");
        String studyAutoDelete = locationsTestData.getJsonData("addNewLocation.studyAutoDelete");
        String queryInterval = locationsTestData.getJsonData("addNewLocation.queryInterval");
        String queryTimeout = locationsTestData.getJsonData("addNewLocation.queryTimeout");
        String matchImageCount = locationsTestData.getJsonData("addNewLocation.matchImageCount");
        String institution = locationsTestData.getJsonData("addNewLocation.institution");
        String expectedLocationAddedMessage = locationsTestData.getJsonData("messages.expectedLocationAddedMessage");
        String expectedLocationEditedMessage = locationsTestData.getJsonData("messages.expectedLocationEditedMessage");
        String expectedLocationDeletedMessage = locationsTestData.getJsonData("messages.expectedLocationDeletedMessage");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnLocationButton()
                .clickOnAddButton()
                .enterName(name)
                .enterHl7LocationName(hl7LocationName)
                .enterAccessionNoPrefix(accessionNoPrefix)
                .enterAnonymizedAccessionNoPrefix(anonymizedAccessionNoPrefix)
                .enterAnonymizedPatientNamePrefix(anonymizedPatientNamePrefix)
                .enterAnonymizedPatientIdPrefix(anonymizedPatientIdPrefix)
                .enterStudyAutoDelete(studyAutoDelete)
                .enterQueryInterval(queryInterval)
                .enterQueryTimeout(queryTimeout)
                .enterMatchImageCount(matchImageCount)
                .selectInstitution(institution)
                .checkEnableRoutingCheckbox()
                .checkOnActiveCheckbox()
                .clickOnSaveButton()
                .assertLocationAddedMessage(expectedLocationAddedMessage);

        new P04_LocationsAdminPage(driver)
                .clickOnOkButton()
                .searchForLocationByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertLocationEditedMessage(expectedLocationEditedMessage);

        new P04_LocationsAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertLocationDeletedMessage(expectedLocationDeletedMessage);
    }

    @Test
    public void invalidLocationsTC() {
        String name = locationsTestData.getJsonData("addNewLocation.name") + "-" + TimestampUtils.getTimestamp();
        String hl7LocationName = locationsTestData.getJsonData("addNewLocation.hl7LocationName");
        String accessionNoPrefix = locationsTestData.getJsonData("addNewLocation.accessionNoPrefix");
        String anonymizedAccessionNoPrefix = locationsTestData.getJsonData("addNewLocation.anonymizedAccessionNoPrefix");
        String anonymizedPatientNamePrefix = locationsTestData.getJsonData("addNewLocation.anonymizedPatientNamePrefix");
        String anonymizedPatientIdPrefix = locationsTestData.getJsonData("addNewLocation.anonymizedPatientIdPrefix");
        String studyAutoDelete = locationsTestData.getJsonData("addNewLocation.studyAutoDelete");
        String queryInterval = locationsTestData.getJsonData("addNewLocation.queryInterval");
        String invalidQueryInterval = locationsTestData.getJsonData("addNewLocation.invalidQueryInterval");
        String queryTimeout = locationsTestData.getJsonData("addNewLocation.queryTimeout");
        String invalidQueryTimeout = locationsTestData.getJsonData("addNewLocation.invalidQueryTimeout");
        String matchImageCount = locationsTestData.getJsonData("addNewLocation.matchImageCount");
        String invalidMatchImageCount = locationsTestData.getJsonData("addNewLocation.invalidMatchImageCount");
        String institution = locationsTestData.getJsonData("addNewLocation.institution");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnLocationButton()
                .clickOnAddButton()
                .enterName("")
                .enterHl7LocationName(hl7LocationName)
                .enterAccessionNoPrefix(accessionNoPrefix)
                .enterAnonymizedAccessionNoPrefix(anonymizedAccessionNoPrefix)
                .enterAnonymizedPatientNamePrefix(anonymizedPatientNamePrefix)
                .enterAnonymizedPatientIdPrefix(anonymizedPatientIdPrefix)
                .enterStudyAutoDelete(studyAutoDelete)
                .enterQueryInterval(queryInterval)
                .enterQueryTimeout(queryTimeout)
                .enterMatchImageCount(matchImageCount)
                .selectInstitution(institution)
                .checkEnableRoutingCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameIsRequiredMessage();

        new P04_LocationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(" ")
                .enterHl7LocationName(hl7LocationName)
                .enterAccessionNoPrefix(accessionNoPrefix)
                .enterAnonymizedAccessionNoPrefix(anonymizedAccessionNoPrefix)
                .enterAnonymizedPatientNamePrefix(anonymizedPatientNamePrefix)
                .enterAnonymizedPatientIdPrefix(anonymizedPatientIdPrefix)
                .enterStudyAutoDelete(studyAutoDelete)
                .enterQueryInterval(queryInterval)
                .enterQueryTimeout(queryTimeout)
                .enterMatchImageCount(matchImageCount)
                .selectInstitution(institution)
                .checkEnableRoutingCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameCannotContainWhiteSpacesMessage();

        new P04_LocationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterHl7LocationName(hl7LocationName)
                .enterAccessionNoPrefix(accessionNoPrefix)
                .enterAnonymizedAccessionNoPrefix(anonymizedAccessionNoPrefix)
                .enterAnonymizedPatientNamePrefix(anonymizedPatientNamePrefix)
                .enterAnonymizedPatientIdPrefix(anonymizedPatientIdPrefix)
                .enterStudyAutoDelete(studyAutoDelete)
                .enterQueryInterval("")
                .enterQueryTimeout(queryTimeout)
                .enterMatchImageCount(matchImageCount)
                .selectInstitution(institution)
                .checkEnableRoutingCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfQueryIntervalIsRequiredMessage();

        new P04_LocationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterHl7LocationName(hl7LocationName)
                .enterAccessionNoPrefix(accessionNoPrefix)
                .enterAnonymizedAccessionNoPrefix(anonymizedAccessionNoPrefix)
                .enterAnonymizedPatientNamePrefix(anonymizedPatientNamePrefix)
                .enterAnonymizedPatientIdPrefix(anonymizedPatientIdPrefix)
                .enterStudyAutoDelete(studyAutoDelete)
                .enterQueryInterval(invalidQueryInterval)
                .enterQueryTimeout(queryTimeout)
                .enterMatchImageCount(matchImageCount)
                .selectInstitution(institution)
                .checkEnableRoutingCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfQueryIntervalMustBeBetween1And20Message();

        new P04_LocationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterHl7LocationName(hl7LocationName)
                .enterAccessionNoPrefix(accessionNoPrefix)
                .enterAnonymizedAccessionNoPrefix(anonymizedAccessionNoPrefix)
                .enterAnonymizedPatientNamePrefix(anonymizedPatientNamePrefix)
                .enterAnonymizedPatientIdPrefix(anonymizedPatientIdPrefix)
                .enterStudyAutoDelete(studyAutoDelete)
                .enterQueryInterval(queryInterval)
                .enterQueryTimeout("")
                .enterMatchImageCount(matchImageCount)
                .selectInstitution(institution)
                .checkEnableRoutingCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfQueryTimeoutIsRequiredMessage();

        new P04_LocationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterHl7LocationName(hl7LocationName)
                .enterAccessionNoPrefix(accessionNoPrefix)
                .enterAnonymizedAccessionNoPrefix(anonymizedAccessionNoPrefix)
                .enterAnonymizedPatientNamePrefix(anonymizedPatientNamePrefix)
                .enterAnonymizedPatientIdPrefix(anonymizedPatientIdPrefix)
                .enterStudyAutoDelete(studyAutoDelete)
                .enterQueryInterval(queryInterval)
                .enterQueryTimeout(invalidQueryTimeout)
                .enterMatchImageCount(matchImageCount)
                .selectInstitution(institution)
                .checkEnableRoutingCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfQueryTimeoutMustBeGreaterThan1Message();

        new P04_LocationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterHl7LocationName(hl7LocationName)
                .enterAccessionNoPrefix(accessionNoPrefix)
                .enterAnonymizedAccessionNoPrefix(anonymizedAccessionNoPrefix)
                .enterAnonymizedPatientNamePrefix(anonymizedPatientNamePrefix)
                .enterAnonymizedPatientIdPrefix(anonymizedPatientIdPrefix)
                .enterStudyAutoDelete(studyAutoDelete)
                .enterQueryInterval(queryInterval)
                .enterQueryTimeout(queryTimeout)
                .enterMatchImageCount("")
                .selectInstitution(institution)
                .checkEnableRoutingCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfMatchImageCountIsRequiredMessage();

        new P04_LocationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterHl7LocationName(hl7LocationName)
                .enterAccessionNoPrefix(accessionNoPrefix)
                .enterAnonymizedAccessionNoPrefix(anonymizedAccessionNoPrefix)
                .enterAnonymizedPatientNamePrefix(anonymizedPatientNamePrefix)
                .enterAnonymizedPatientIdPrefix(anonymizedPatientIdPrefix)
                .enterStudyAutoDelete(studyAutoDelete)
                .enterQueryInterval(queryInterval)
                .enterQueryTimeout(queryTimeout)
                .enterMatchImageCount(invalidMatchImageCount)
                .selectInstitution(institution)
                .checkEnableRoutingCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfMatchImageCountMustBeBetween2And5Message();

        new P04_LocationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .clickOnInstitutionDropdown()
                .enterName(name)
                .enterHl7LocationName(hl7LocationName)
                .enterAccessionNoPrefix(accessionNoPrefix)
                .enterAnonymizedAccessionNoPrefix(anonymizedAccessionNoPrefix)
                .enterAnonymizedPatientNamePrefix(anonymizedPatientNamePrefix)
                .enterAnonymizedPatientIdPrefix(anonymizedPatientIdPrefix)
                .enterStudyAutoDelete(studyAutoDelete)
                .enterQueryInterval(queryInterval)
                .enterQueryTimeout(queryTimeout)
                .enterMatchImageCount(matchImageCount)
                .checkEnableRoutingCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfInstitutionIsRequiredMessage();

    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        locationsTestData = new JsonUtils("LocationsTestData");
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
