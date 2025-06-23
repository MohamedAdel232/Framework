package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P05_DICOMNodesAdminPage;
import Pages.P06_PACSServerAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC06_PACSServerAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils pacsServerTestData;

    @Test
    public void validPACSServerTC() {
        String name = pacsServerTestData.getJsonData("addNewPACSServer.name") + "-" + TimestampUtils.getTimestamp();
        String ip = pacsServerTestData.getJsonData("addNewPACSServer.ip");
        String aeTitle = pacsServerTestData.getJsonData("addNewPACSServer.aeTitle");
        String port = pacsServerTestData.getJsonData("addNewPACSServer.port");
        String issuerOfPatientId = pacsServerTestData.getJsonData("addNewPACSServer.issuerOfPatientId");
        String institution = new P05_DICOMNodesAdminPage(driver).getInstitutionWithLocations();
        String expectedAddedMessage = pacsServerTestData.getJsonData("messages.expectedPACSServerAddedMessage");
        String expectedEditedMessage = pacsServerTestData.getJsonData("messages.expectedPACSServerEditedMessage");
        String expectedDeletedMessage = pacsServerTestData.getJsonData("messages.expectedPACSServerDeletedMessage");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnDICOMButton()
                .clickOnPACSServerButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .clickOnSaveButton()
                .assertPACSServerAddedMessage(expectedAddedMessage);

        new P06_PACSServerAdminPage(driver)
                .clickOnOkButton()
                .searchForPACSServerByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertPACSServerEditedMessage(expectedEditedMessage);

        new P06_PACSServerAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertPACSServerDeletedMessage(expectedDeletedMessage);
    }

    @Test
    public void invalidPACSServerTC() {
        String name = pacsServerTestData.getJsonData("addNewPACSServer.name") + "-" + TimestampUtils.getTimestamp();
        String ip = pacsServerTestData.getJsonData("addNewPACSServer.ip");
        String aeTitle = pacsServerTestData.getJsonData("addNewPACSServer.aeTitle");
        String port = pacsServerTestData.getJsonData("addNewPACSServer.port");
        String issuerOfPatientId = pacsServerTestData.getJsonData("addNewPACSServer.issuerOfPatientId");
        String institution = new P05_DICOMNodesAdminPage(driver).getInstitutionWithLocations();
        String ipCannotContainWhiteSpaces = pacsServerTestData.getJsonData("addNewPACSServer.ipCannotContainWhiteSpaces");
        String invalidIP = pacsServerTestData.getJsonData("addNewPACSServer.invalidIP");
        String portCannotContainWhiteSpaces = pacsServerTestData.getJsonData("addNewPACSServer.portCannotContainWhiteSpaces");
        String portMustBeBetween1And65535 = pacsServerTestData.getJsonData("addNewPACSServer.portMustBeBetween1And65535");
        String invalidPort = pacsServerTestData.getJsonData("addNewPACSServer.invalidPort");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnDICOMButton()
                .clickOnPACSServerButton()
                .clickOnAddButton()
                .enterName("")
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameIsRequiredMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(" ")
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameCannotContainWhiteSpacesOnlyMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP("")
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfIPIsRequiredMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ipCannotContainWhiteSpaces)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfIPCannotContainWhiteSpacesMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(" ")
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfIPCannotContainWhiteSpacesMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(invalidIP)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfInvalidIPMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle("")
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfAETitleIsRequiredMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(" ")
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfAETitleCannotContainWhiteSpacesMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort("")
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortIsRequiredMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(portCannotContainWhiteSpaces)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortCannotContainWhiteSpacesMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(invalidPort)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfInvalidPortMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(portMustBeBetween1And65535)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortMustBeBetween1And65535Message();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(portMustBeBetween1And65535)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortMustNotBeLessThanOneMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .clickOnInstitutionDropdown()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .checkOnActiveCheckbox()
                .assertVisibilityOfInstitutionIsRequiredMessage();

        new P06_PACSServerAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .selectInstitution(institution)
                .clickOnLocationDropdown()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientId)
                .checkOnActiveCheckbox()
                .assertVisibilityOfPleaseSelectAtLeastOneLocationMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        pacsServerTestData = new JsonUtils("PACSServerTestData");
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