package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P12_DestinationsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC12_DestinationsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils destinationTestData;

    @Test
    public void validDestinationsTC() {
        String name = destinationTestData.getJsonData("addNewDestination.name") + TimestampUtils.getTimestamp();
        String pacsType = destinationTestData.getJsonData("addNewDestination.pacsType");
        String dicomMode = destinationTestData.getJsonData("addNewDestination.dicomMode");
        String ipAddress = destinationTestData.getJsonData("addNewDestination.ipAddress");
        String aeTitle = destinationTestData.getJsonData("addNewDestination.aeTitle");
        String portNo = destinationTestData.getJsonData("addNewDestination.portNo");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnDestinationsButton()
                .clickOnAddNewDestinationButon()
                .enterName(name)
                .selectType(pacsType)
                .selectMode(dicomMode)
                .selectSite()
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPortNo(portNo)
                .checkActiveCheckbox()
                .clickOnSaveButton();

        new P12_DestinationsAdminPage(driver)
                .searchDestinationByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertVisibilityOfDestinationEditedAlert();

        new P12_DestinationsAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfDestinationDeletedAlert();
    }

    @Test
    public void invalidDestinationsTC() {
        String name = destinationTestData.getJsonData("addNewDestination.name") + TimestampUtils.getTimestamp();
        String pacsType = destinationTestData.getJsonData("addNewDestination.pacsType");
        String dicomMode = destinationTestData.getJsonData("addNewDestination.dicomMode");
        String hl7Mode = destinationTestData.getJsonData("addNewDestination.hl7Mode");
        String ipAddress = destinationTestData.getJsonData("addNewDestination.ipAddress");
        String invalidIPAddress = destinationTestData.getJsonData("addNewDestination.invalidIPAddress");
        String aeTitle = destinationTestData.getJsonData("addNewDestination.aeTitle");
        String portNo = destinationTestData.getJsonData("addNewDestination.portNo");
        String invalidPortNo = destinationTestData.getJsonData("addNewDestination.invalidPortNo");
        String lessThanZeroPortNo = destinationTestData.getJsonData("addNewDestination.lessThanZeroPortNo");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnDestinationsButton()
                .clickOnAddNewDestinationButon()
                .enterName("")
                .selectType(pacsType)
                .selectMode(dicomMode)
                .selectSite()
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPortNo(portNo)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyNameMessage();

        new P12_DestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewDestinationButon()
                .clickOnTypeDropdown()
                .enterName(name)
                .selectMode(dicomMode)
                .selectSite()
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPortNo(portNo)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyTypeMessage();

        new P12_DestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewDestinationButon()
                .selectType(pacsType)
                .clickOnModeDropdown()
                .enterName(name)
                .selectSite()
                .enterIPAddress(ipAddress)
                .enterPortNo(portNo)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyModeMessage();

        new P12_DestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewDestinationButon()
                .clickOnSiteDropdown()
                .enterName(name)
                .selectType(pacsType)
                .selectMode(dicomMode)
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPortNo(portNo)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptySiteMessage();

        new P12_DestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewDestinationButon()
                .enterName(name)
                .selectType(pacsType)
                .selectMode(dicomMode)
                .selectSite()
                .enterIPAddress("")
                .enterAETitle(aeTitle)
                .enterPortNo(portNo)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyIPAddressMessage();

        new P12_DestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewDestinationButon()
                .enterName(name)
                .selectType(pacsType)
                .selectMode(dicomMode)
                .selectSite()
                .enterIPAddress(ipAddress)
                .enterAETitle("")
                .enterPortNo(portNo)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyAETitleMessage();

        new P12_DestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewDestinationButon()
                .enterName(name)
                .selectType(pacsType)
                .selectMode(dicomMode)
                .selectSite()
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPortNo("")
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyPortNoMessage();

        new P12_DestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewDestinationButon()
                .enterName(name)
                .selectType(pacsType)
                .selectMode(hl7Mode)
                .selectSite()
                .clickOnHL7OutboundProfileDropdown()
                .enterIPAddress(ipAddress)
                .enterPortNo(portNo)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyHL7OutboundProfileMessage();

        new P12_DestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewDestinationButon()
                .enterName(" ")
                .selectType(pacsType)
                .selectMode(dicomMode)
                .selectSite()
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPortNo(portNo)
                .checkActiveCheckbox()
                .assertVisibilityOfSpacesOnlyNameMessage();

        new P12_DestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewDestinationButon()
                .enterName(name)
                .selectType(pacsType)
                .selectMode(dicomMode)
                .selectSite()
                .enterIPAddress(ipAddress)
                .enterAETitle("  ")
                .enterPortNo(portNo)
                .checkActiveCheckbox()
                .assertVisibilityOfSpacesOnlyAETitleMessage();

        new P12_DestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewDestinationButon()
                .enterName(name)
                .selectType(pacsType)
                .selectMode(dicomMode)
                .selectSite()
                .enterIPAddress(invalidIPAddress)
                .enterAETitle(aeTitle)
                .enterPortNo(portNo)
                .checkActiveCheckbox()
                .assertVisibilityOfInvalidIPAddressMessage();

        new P12_DestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewDestinationButon()
                .enterName(name)
                .selectType(pacsType)
                .selectMode(dicomMode)
                .selectSite()
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPortNo(invalidPortNo)
                .checkActiveCheckbox()
                .assertVisibilityOfInvalidPortNoMessage();

        new P12_DestinationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewDestinationButon()
                .enterName(name)
                .selectType(pacsType)
                .selectMode(dicomMode)
                .selectSite()
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPortNo(lessThanZeroPortNo)
                .checkActiveCheckbox()
                .assertVisibilityOfLessThanZeroPortNoMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        destinationTestData = new JsonUtils("DestinationsTestData");
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

