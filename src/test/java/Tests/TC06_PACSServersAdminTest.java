package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P06_PACSServersAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC06_PACSServersAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils pacsServersTestData;

    @Test
    public void validPacsServersTC() throws InterruptedException {
        String pacsServerName = pacsServersTestData.getJsonData("addNewPACSServer.name") + "-" + TimestampUtils.getTimestamp();
        String ipAddress = pacsServersTestData.getJsonData("addNewPACSServer.idAddress");
        String aeTitle = pacsServersTestData.getJsonData("addNewPACSServer.AETitle");
        String port = pacsServersTestData.getJsonData("addNewPACSServer.port");
        String issuerOfPatientID = pacsServersTestData.getJsonData("addNewPACSServer.issuerOfPatientID");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnPACSServersButton()
                .clickOnAddButton()
                .enterName(pacsServerName)
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientID)
                .selectSite()
                .clickOnActiveCheckbox()
                .clickOnSaveButton()
        //        .assertVisibilityOfPacsServerAddedAlert()
        ;

        new P06_PACSServersAdminPage(driver)
                //.clickOnOkButton()
                .searchForPacsServer(pacsServerName)
                .clickOnEditButton(pacsServerName)
                .clickOnSaveButton()
                .assertVisibilityOfPacsServerEditedAlert();

        new P06_PACSServersAdminPage(driver)
                .clickOnOkButton()
                .searchForPacsServer(pacsServerName)
                .clickOnDeleteButton(pacsServerName)
                .clickOnYesButton()
                .assertVisibilityOfPacsServerDeletedAlert();
    }

    @Test
    public void invalidPacsServersTC() {
        String pacsServerName = pacsServersTestData.getJsonData("addNewPACSServer.name") + "-" + TimestampUtils.getTimestamp();
        String ipAddress = pacsServersTestData.getJsonData("addNewPACSServer.idAddress");
        String invalidIPAddress = pacsServersTestData.getJsonData("addNewPACSServer.invalidIPAddress");
        String aeTitle = pacsServersTestData.getJsonData("addNewPACSServer.AETitle");
        String port = pacsServersTestData.getJsonData("addNewPACSServer.port");
        String issuerOfPatientID = pacsServersTestData.getJsonData("addNewPACSServer.issuerOfPatientID");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnPACSServersButton()
                .clickOnAddButton()
                .enterName("")
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientID)
                .selectSite()
                .clickOnActiveCheckbox()
                .assertVisibilityOfEmptyNameFieldMessage();

        new P06_PACSServersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddButton()
                .enterName(pacsServerName)
                .enterIPAddress("")
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientID)
                .selectSite()
                .clickOnActiveCheckbox()
                .assertVisibilityOfEmptyIPAddressFieldMessage();

        new P06_PACSServersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddButton()
                .enterName(pacsServerName)
                .enterIPAddress(ipAddress)
                .enterAETitle("")
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientID)
                .selectSite()
                .clickOnActiveCheckbox()
                .assertVisibilityOfEmptyAETitleFieldMessage();

        new P06_PACSServersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddButton()
                .enterName(pacsServerName)
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPort("")
                .enterIssuerOfPatientId(issuerOfPatientID)
                .selectSite()
                .clickOnActiveCheckbox()
                .assertVisibilityOfEmptyPortFieldMessage();

        new P06_PACSServersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddButton()
                .clickOnSiteDropdown()
                .enterName(pacsServerName)
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientID)
                .clickOnActiveCheckbox()
                .assertVisibilityOfEmptySiteFieldMessage();

        new P06_PACSServersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddButton()
                .enterName(" ")
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientID)
                .selectSite()
                .clickOnActiveCheckbox()
                .assertVisibilityOfSpacesOnlyNameFieldMessage();

        new P06_PACSServersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddButton()
                .enterName(pacsServerName)
                .enterIPAddress(" ")
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientID)
                .selectSite()
                .clickOnActiveCheckbox()
                .assertVisibilityOfSpacesOnlyIPAddressFieldMessage();

        new P06_PACSServersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddButton()
                .enterName(pacsServerName)
                .enterIPAddress(ipAddress)
                .enterAETitle(" ")
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientID)
                .selectSite()
                .clickOnActiveCheckbox()
                .assertVisibilityOfSpacesOnlyAETitleFieldMessage();

        new P06_PACSServersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddButton()
                .enterName(pacsServerName)
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(" ")
                .selectSite()
                .clickOnActiveCheckbox()
                .assertVisibilityOfSpacesOnlyIssuerOfPatientIDFieldMessage();

        new P06_PACSServersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddButton()
                .enterName(pacsServerName)
                .enterIPAddress(invalidIPAddress)
                .enterAETitle(aeTitle)
                .enterPort(port)
                .enterIssuerOfPatientId(issuerOfPatientID)
                .selectSite()
                .clickOnActiveCheckbox()
                .assertVisibilityOfInvalidIPAddressMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        pacsServersTestData = new JsonUtils("PACSServersTestData");
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

