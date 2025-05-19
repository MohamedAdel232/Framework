package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P10_HL7NodesAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC10_HL7NodesAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils hl7NodeTestData;

    @Test
    public void hl7NodeTC() throws InterruptedException {
        String hl7NodeName = hl7NodeTestData.getJsonData("addNewHL7Node.name") + "-" + TimestampUtils.getTimestamp();
        String hl7NodePort = hl7NodeTestData.getJsonData("addNewHL7Node.port");
        String hl7NodeDescription = hl7NodeTestData.getJsonData("addNewHL7Node.destination");

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
                .clickOnHL7ConfigButton()
                .clickOnHL7NodesButton()
                .clickOnAddButton()
                .enterName(hl7NodeName)
                .enterPort(hl7NodePort)
                .enterDescription(hl7NodeDescription)
                .selectSite()
                .clickOnActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfHL7NodeAddedAlert();

        new P10_HL7NodesAdminPage(driver)
                .clickOnEditButton(hl7NodeName)
                .clickOnSaveButton()
                .assertVisibilityOfHL7NodeEditedAlert();

        new P10_HL7NodesAdminPage(driver)
                .clickOnDeleteButton(hl7NodeName)
                .clickOnYesButton()
                .assertVisibilityOfHL7NodeDeletedAlert(hl7NodeName);
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        hl7NodeTestData = new JsonUtils("HL7NodesTestData");
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
