package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P05_DICOMNodesAdminPage;
import Pages.P09_HL7NodesAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC09_HL7NodesAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils hl7NodesTestData;

    @Test
    public void validHL7NodesTC() {
        String name = hl7NodesTestData.getJsonData("addNewHL7Node.name") + "-" + TimestampUtils.getTimestamp();
        String ip = hl7NodesTestData.getJsonData("addNewHL7Node.ip");
        String port = hl7NodesTestData.getJsonData("addNewHL7Node.port");
        String institution = new P05_DICOMNodesAdminPage(driver).getInstitutionWithLocations();
        String description = hl7NodesTestData.getJsonData("addNewHL7Node.description");
        String expectedAddedMessage = hl7NodesTestData.getJsonData("messages.expectedHL7NodeAddedMessage");
        String expectedEditedMessage = hl7NodesTestData.getJsonData("messages.expectedHL7NodeEditedMessage");
        String expectedDeletedMessage = hl7NodesTestData.getJsonData("messages.expectedHL7NodeDeletedMessage");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnHL7ConfigurationButton()
                .clickOnHL7NodesButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .enterDescription(description)
                .checkIgnoreORMCheckbox()
                .checkIgnoreORUCheckbox()
                .checkIgnoreADTCheckbox()
                .checkIgnorePreliminaryORUCheckbox()
                .checkOnActiveCheckbox()
                .clickOnSaveButton()
                .assertHL7NodeAddedMessage(expectedAddedMessage);

        new P09_HL7NodesAdminPage(driver)
                .clickOnOkButton()
                .searchForHL7NodeByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertHL7NodeEditedMessage(expectedEditedMessage);

        new P09_HL7NodesAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertHL7NodeDeletedMessage(expectedDeletedMessage);
    }

    @Test
    public void invalidHL7NodesTC() {
        String name = hl7NodesTestData.getJsonData("addNewHL7Node.name") + "-" + TimestampUtils.getTimestamp();
        String ip = hl7NodesTestData.getJsonData("addNewHL7Node.ip");
        String port = hl7NodesTestData.getJsonData("addNewHL7Node.port");
        String institution = new P05_DICOMNodesAdminPage(driver).getInstitutionWithLocations();
        String ipCannotContainWhiteSpaces = hl7NodesTestData.getJsonData("addNewHL7Node.ipCannotContainWhiteSpaces");
        String invalidIP = hl7NodesTestData.getJsonData("addNewHL7Node.invalidIP");
        String portCannotContainWhiteSpaces = hl7NodesTestData.getJsonData("addNewHL7Node.portCannotContainWhiteSpaces");
        String portMustBeBetween1And65535 = hl7NodesTestData.getJsonData("addNewHL7Node.portMustBeBetween1And65535");
        String invalidPort = hl7NodesTestData.getJsonData("addNewHL7Node.invalidPort");
        String description = hl7NodesTestData.getJsonData("addNewHL7Node.description");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnHL7ConfigurationButton()
                .clickOnHL7NodesButton()
                .clickOnAddButton()
                .enterName("")
                .enterIP(ip)
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .enterDescription(description)
                .checkIgnoreORMCheckbox()
                .checkIgnoreORUCheckbox()
                .checkIgnoreADTCheckbox()
                .checkIgnorePreliminaryORUCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameIsRequiredMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(" ")
                .enterIP(ip)
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .enterDescription(description)
                .checkIgnoreORMCheckbox()
                .checkIgnoreORUCheckbox()
                .checkIgnoreADTCheckbox()
                .checkIgnorePreliminaryORUCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameCannotContainWhiteSpacesOnlyMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP("")
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .enterDescription(description)
                .checkIgnoreORMCheckbox()
                .checkIgnoreORUCheckbox()
                .checkIgnoreADTCheckbox()
                .checkIgnorePreliminaryORUCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfIPIsRequiredMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ipCannotContainWhiteSpaces)
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .enterDescription(description)
                .checkIgnoreORMCheckbox()
                .checkIgnoreORUCheckbox()
                .checkIgnoreADTCheckbox()
                .checkIgnorePreliminaryORUCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfIPCannotContainWhiteSpacesMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(invalidIP)
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .enterDescription(description)
                .checkIgnoreORMCheckbox()
                .checkIgnoreORUCheckbox()
                .checkIgnoreADTCheckbox()
                .checkIgnorePreliminaryORUCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfInvalidIPMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterPort("")
                .selectInstitution(institution)
                .selectLocation()
                .enterDescription(description)
                .checkIgnoreORMCheckbox()
                .checkIgnoreORUCheckbox()
                .checkIgnoreADTCheckbox()
                .checkIgnorePreliminaryORUCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortIsRequiredMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterPort(portCannotContainWhiteSpaces)
                .selectInstitution(institution)
                .selectLocation()
                .enterDescription(description)
                .checkIgnoreORMCheckbox()
                .checkIgnoreORUCheckbox()
                .checkIgnoreADTCheckbox()
                .checkIgnorePreliminaryORUCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortCannotContainWhiteSpacesMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterPort(invalidPort)
                .selectInstitution(institution)
                .selectLocation()
                .enterDescription(description)
                .checkIgnoreORMCheckbox()
                .checkIgnoreORUCheckbox()
                .checkIgnoreADTCheckbox()
                .checkIgnorePreliminaryORUCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfInvalidPortMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterPort(portMustBeBetween1And65535)
                .selectInstitution(institution)
                .selectLocation()
                .enterDescription(description)
                .checkIgnoreORMCheckbox()
                .checkIgnoreORUCheckbox()
                .checkIgnoreADTCheckbox()
                .checkIgnorePreliminaryORUCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortMustBeBetween1And65535Message();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterPort(port)
                .clickOnInstitutionDropdown()
                .enterDescription(description)
                .checkIgnoreORMCheckbox()
                .checkIgnoreORUCheckbox()
                .checkIgnoreADTCheckbox()
                .checkIgnorePreliminaryORUCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfInstitutionIsRequiredMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .selectInstitution(institution)
                .clickOnLocationDropdown()
                .enterName(name)
                .enterIP(ip)
                .enterPort(port)
                .enterDescription(description)
                .checkIgnoreORMCheckbox()
                .checkIgnoreORUCheckbox()
                .checkIgnoreADTCheckbox()
                .checkIgnorePreliminaryORUCheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfLocationIsRequiredMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        hl7NodesTestData = new JsonUtils("HL7NodesTestData");
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