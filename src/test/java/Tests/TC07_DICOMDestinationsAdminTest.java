package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P07_DICOMDestinationsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC07_DICOMDestinationsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils dicomDestinationsTestData;

    @Test
    public void validDICOMDestinationsTC() {
        String name = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.name") + "-" + TimestampUtils.getTimestamp();
        String ip = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.ip");
        String aeTitle = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.aeTitle");
        String port = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.port");
        String expectedAddedMessage = dicomDestinationsTestData.getJsonData("messages.expectedDICOMDestinationAddedMessage");
        String expectedEditedMessage = dicomDestinationsTestData.getJsonData("messages.expectedDICOMDestinationEditedMessage");
        String expectedDeletedMessage = dicomDestinationsTestData.getJsonData("messages.expectedDICOMDestinationDeletedMessage");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnDICOMButton()
                .clickOnDICOMDestinationsButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .clickOnSaveButton()
                .assertDICOMDestinationAddedMessage(expectedAddedMessage);

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnOkButton()
                .searchForDICOMDestinationByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertDICOMDestinationEditedMessage(expectedEditedMessage);

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertDICOMDestinationDeletedMessage(expectedDeletedMessage);
    }

    @Test
    public void invalidDICOMDestinationsTC() {
        String name = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.name") + "-" + TimestampUtils.getTimestamp();
        String ip = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.ip");
        String aeTitle = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.aeTitle");
        String port = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.port");
        String ipCannotContainWhiteSpaces = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.ipCannotContainWhiteSpaces");
        String invalidIP = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.invalidIP");
        String portCannotContainWhiteSpaces = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.portCannotContainWhiteSpaces");
        String portMustBeBetween1And65535 = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.portMustBeBetween1And65535");
        String invalidPort = dicomDestinationsTestData.getJsonData("addNewDICOMDestination.invalidPort");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnDICOMButton()
                .clickOnDICOMDestinationsButton()
                .clickOnAddButton()
                .enterName("")
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameIsRequiredMessage();

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(" ")
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameCannotContainWhiteSpacesOnlyMessage();

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP("")
                .enterAETitle(aeTitle)
                .enterPort(port)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfIPIsRequiredMessage();

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ipCannotContainWhiteSpaces)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfIPCannotContainWhiteSpacesMessage();

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(" ")
                .enterAETitle(aeTitle)
                .enterPort(port)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfIPCannotContainWhiteSpacesMessage();

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(invalidIP)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfInvalidIPMessage();

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle("")
                .enterPort(port)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfAETitleIsRequiredMessage();

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(" ")
                .enterPort(port)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfAETitleCannotContainWhiteSpacesMessage();

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort("")
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortIsRequiredMessage();

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(portCannotContainWhiteSpaces)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortCannotContainWhiteSpacesMessage();

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(invalidPort)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfInvalidPortMessage();

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(portMustBeBetween1And65535)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortMustBeBetween1And65535Message();

        new P07_DICOMDestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterIP(ip)
                .enterAETitle(aeTitle)
                .enterPort(portMustBeBetween1And65535)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPortMustNotBeLessThanOneMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        dicomDestinationsTestData = new JsonUtils("DICOMDestinationsTestData");
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