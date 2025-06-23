package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P05_DICOMNodesAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC05_DICOMNodesAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils dicomNodesTestData;

    @Test
    public void validDICOMNodesTC() {
        String name = dicomNodesTestData.getJsonData("addNewDICOMNode.name") + "-" + TimestampUtils.getTimestamp();
        String ip = dicomNodesTestData.getJsonData("addNewDICOMNode.ip");
        String aeTitle = dicomNodesTestData.getJsonData("addNewDICOMNode.aeTitle");
        String port = dicomNodesTestData.getJsonData("addNewDICOMNode.port");
        String institution = new P05_DICOMNodesAdminPage(driver).getInstitutionWithLocations();
        String expectedAddedMessage = dicomNodesTestData.getJsonData("messages.expectedDICOMNodeAddedMessage");
        String expectedEditedMessage = dicomNodesTestData.getJsonData("messages.expectedDICOMNodeEditedMessage");
        String expectedDeletedMessage = dicomNodesTestData.getJsonData("messages.expectedDICOMNodeDeletedMessage");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnDICOMButton()
                .clickOnDICOMNodesButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .clickOnSaveButton()
                .assertDICOMNodeAddedMessage(expectedAddedMessage);

        new P05_DICOMNodesAdminPage(driver)
                .clickOnOkButton()
                .searchForDICOMNodeByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertDICOMNodeEditedMessage(expectedEditedMessage);

        new P05_DICOMNodesAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertDICOMNodeDeletedMessage(expectedDeletedMessage);
    }

    @Test
    public void invalidDICOMNodesTC() {
        String name = dicomNodesTestData.getJsonData("addNewDICOMNode.name") + "-" + TimestampUtils.getTimestamp();
        String ip = dicomNodesTestData.getJsonData("addNewDICOMNode.ip");
        String aeTitle = dicomNodesTestData.getJsonData("addNewDICOMNode.aeTitle");
        String port = dicomNodesTestData.getJsonData("addNewDICOMNode.port");
        String institution = new P05_DICOMNodesAdminPage(driver).getInstitutionWithLocations();
        String ipCannotContainWhiteSpaces = dicomNodesTestData.getJsonData("addNewDICOMNode.ipCannotContainWhiteSpaces");
        String invalidIP = dicomNodesTestData.getJsonData("addNewDICOMNode.invalidIP");
        String portCannotContainWhiteSpaces = dicomNodesTestData.getJsonData("addNewDICOMNode.portCannotContainWhiteSpaces");
        String portMustBeBetween1And65535 = dicomNodesTestData.getJsonData("addNewDICOMNode.portMustBeBetween1And65535");
        String invalidPort = dicomNodesTestData.getJsonData("addNewDICOMNode.invalidPort");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnDICOMButton()
                .clickOnDICOMNodesButton()
                .clickOnAddButton()
                .enterName("")
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameIsRequiredMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(" ")
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameCannotContainWhiteSpacesOnlyMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP("")
                .enterAETitle(aeTitle)
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfIPIsRequiredMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ipCannotContainWhiteSpaces)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfIPCannotContainWhiteSpacesMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(" ")
                .enterAETitle(aeTitle)
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfIPCannotContainWhiteSpacesMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(invalidIP)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfInvalidIPMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle("")
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfAETitleIsRequiredMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(" ")
                .enterPort(port)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfAETitleCannotContainWhiteSpacesMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort("")
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortIsRequiredMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(portCannotContainWhiteSpaces)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortCannotContainWhiteSpacesMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(invalidPort)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfInvalidPortMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(portMustBeBetween1And65535)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortMustBeBetween1And65535Message();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(portMustBeBetween1And65535)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortMustNotBeLessThanOneMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .clickOnInstitutionDropdown()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .checkOnActiveCheckbox()
                .assertVisibilityOfInstitutionIsRequiredMessage();

        new P05_DICOMNodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .selectInstitution(institution)
                .clickOnLocationDropdown()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .checkOnActiveCheckbox()
                .assertVisibilityOfPleaseSelectAtLeastOneLocationMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        dicomNodesTestData = new JsonUtils("DICOMNodesTestData");
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