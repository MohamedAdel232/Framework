package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P05_DICOMNodesAdminPage;
import Pages.P08_DICOMOriginsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC08_DICOMOriginsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils dicomOriginsTestData;

    @Test
    public void validDICOMOriginsTC() {
        String name = dicomOriginsTestData.getJsonData("addNewDICOMOrigin.name") + "-" + TimestampUtils.getTimestamp();
        String aeTitle = dicomOriginsTestData.getJsonData("addNewDICOMOrigin.aeTitle");
        String sendingAETitle = dicomOriginsTestData.getJsonData("addNewDICOMOrigin.sendingAETitle");
        String institution = new P05_DICOMNodesAdminPage(driver).getInstitutionWithLocations();
        String expectedAddedMessage = dicomOriginsTestData.getJsonData("messages.expectedDICOMOriginAddedMessage");
        String expectedEditedMessage = dicomOriginsTestData.getJsonData("messages.expectedDICOMOriginEditedMessage");
        String expectedDeletedMessage = dicomOriginsTestData.getJsonData("messages.expectedDICOMOriginDeletedMessage");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnDICOMButton()
                .clickOnDICOMOriginsButton()
                .clickOnAddButton()
                .enterName(name)
                .enterAETitle(aeTitle)
                .enterSendingAETitle(sendingAETitle)
                .selectInstitution(institution)
                .selectLocation()
                .checkOnActiveCheckbox()
                .uncheckAICheckbox()
                .clickOnSaveButton()
                .assertDICOMOriginAddedMessage(expectedAddedMessage);

        new P08_DICOMOriginsAdminPage(driver)
                .clickOnOkButton()
                .searchForDICOMOriginByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertDICOMOriginEditedMessage(expectedEditedMessage);

        new P08_DICOMOriginsAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertDICOMOriginDeletedMessage(expectedDeletedMessage);
    }

    @Test
    public void invalidDICOMOriginsTC() {
        String name = dicomOriginsTestData.getJsonData("addNewDICOMOrigin.name") + "-" + TimestampUtils.getTimestamp();
        String aeTitle = dicomOriginsTestData.getJsonData("addNewDICOMOrigin.aeTitle");
        String sendingAETitle = dicomOriginsTestData.getJsonData("addNewDICOMOrigin.sendingAETitle");
        String institution = new P05_DICOMNodesAdminPage(driver).getInstitutionWithLocations();
        String location = dicomOriginsTestData.getJsonData("addNewDICOMOrigin.location");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnDICOMButton()
                .clickOnDICOMOriginsButton()
                .clickOnAddButton()
                .enterName("")
                .enterAETitle(aeTitle)
                .enterSendingAETitle(sendingAETitle)
                .selectInstitution(institution)
                .selectLocation()
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameIsRequiredMessage();

        new P08_DICOMOriginsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(" ")
                .enterAETitle(aeTitle)
                .enterSendingAETitle(sendingAETitle)
                .selectInstitution(institution)
                .selectLocation()
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfNameCannotContainWhiteSpacesOnlyMessage();

        new P08_DICOMOriginsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterAETitle("")
                .enterSendingAETitle(sendingAETitle)
                .selectInstitution(institution)
                .selectLocation()
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfAETitleIsRequiredMessage();

        new P08_DICOMOriginsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterAETitle(" ")
                .enterSendingAETitle(sendingAETitle)
                .selectInstitution(institution)
                .selectLocation()
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfAETitleCannotContainWhiteSpacesMessage();

        new P08_DICOMOriginsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterAETitle(aeTitle)
                .enterSendingAETitle("")
                .selectInstitution(institution)
                .selectLocation()
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfSendingAETitleIsRequiredMessage();

        new P08_DICOMOriginsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .enterName(name)
                .enterAETitle(aeTitle)
                .enterSendingAETitle(" ")
                .selectInstitution(institution)
                .selectLocation()
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfSendingAETitleCannotContainWhiteSpacesMessage();

        new P08_DICOMOriginsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .clickOnInstitutionDropdown()
                .enterName(name)
                .enterAETitle(aeTitle)
                .enterSendingAETitle(sendingAETitle)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfInstitutionIsRequiredMessage();

        new P08_DICOMOriginsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddButton()
                .selectInstitution(institution)
                .clickOnLocationDropdown()
                .enterName(name)
                .enterAETitle(aeTitle)
                .enterSendingAETitle(sendingAETitle)
                .checkAICheckbox()
                .checkOnActiveCheckbox()
                .assertVisibilityOfPleaseSelectAtLeastOneLocationMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        dicomOriginsTestData = new JsonUtils("DICOMOriginsTestData");
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