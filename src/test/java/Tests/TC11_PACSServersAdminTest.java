package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P11_PACSServersAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC11_PACSServersAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils pacsServersTestData;

    @Test
    public void pacsServersTC() throws InterruptedException {
        String pacsServerName = pacsServersTestData.getJsonData("addNewPACSServer.name") + "-" + TimestampUtils.getTimestamp();
        String ipAddress = pacsServersTestData.getJsonData("addNewPACSServer.idAddress");
        String aeTitle = pacsServersTestData.getJsonData("addNewPACSServer.AETitle");
        String hl7NodePort = pacsServersTestData.getJsonData("addNewPACSServer.port");
        String issuerOfPatientID = pacsServersTestData.getJsonData("addNewPACSServer.issuerOfPatientID");

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
                .clickOnDICOMConfigButton()
                .clickOnPACSServersButton()
                .clickOnAddButton()
                .enterName(pacsServerName)
                .enterIPAddress(ipAddress)
                .enterAETitle(aeTitle)
                .enterPort(hl7NodePort)
                .enterIssuerOfPatientId(issuerOfPatientID)
                .selectSite()
                .clickOnActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfPacsServerAddedAlert();

        new P11_PACSServersAdminPage(driver)
                .clickOnEditButton(pacsServerName)
                .clickOnSaveButton()
                .assertVisibilityOfPacsServerEditedAlert();

        new P11_PACSServersAdminPage(driver)
                .clickOnDeleteButton(pacsServerName)
                .clickOnYesButton()
                .assertVisibilityOfPacsServerDeletedAlert();
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

