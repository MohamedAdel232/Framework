package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P06_PatientEligibilityAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC06_PatientEligibilityAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils patientEligibilityTestData;

    @Test
    public void validPatientEligibilityTC() {
        String patientEligibilityName = patientEligibilityTestData.getJsonData("addNewPatientEligibility.patientEligibilityName") + TimestampUtils.getTimestamp();
        String patientEligibilityHL7Value = patientEligibilityTestData.getJsonData("addNewPatientEligibility.patientEligibilityHL7Value");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnGeneralConfigButton()
                .clickOnWorklistMappingButton()
                .clickOnPatientEligibilityAdminButton()
                .clickOnAddPatientEligibilityButton()
                .enterPatientEligibilityName(patientEligibilityName)
                .enterPatientEligibilityHL7Value(patientEligibilityHL7Value)
                .clickOnSaveButton()
                .assertVisibilityOfPatientEligibilityAddedAlert();

        new P06_PatientEligibilityAdminPage(driver)
                .searchForPatientEligibilityByName(patientEligibilityName)
                .clickOnEditButton(patientEligibilityName)
                .clickOnSaveButton()
                .assertVisibilityOfPatientEligibilityEditedAlert();

        new P06_PatientEligibilityAdminPage(driver)
                .searchForPatientEligibilityByName(patientEligibilityName)
                .clickOnDeleteButton(patientEligibilityName)
                .clickOnYesButton()
                .assertVisibilityOfPatientEligibilityDeletedAlert();
    }

    @Test
    public void invalidPatientEligibilityTC() {
        String patientEligibilityName = patientEligibilityTestData.getJsonData("addNewPatientEligibility.patientEligibilityName") + TimestampUtils.getTimestamp();
        String patientEligibilityHL7Value = patientEligibilityTestData.getJsonData("addNewPatientEligibility.patientEligibilityHL7Value");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnGeneralConfigButton()
                .clickOnWorklistMappingButton()
                .clickOnPatientEligibilityAdminButton()
                .clickOnAddPatientEligibilityButton()
                .enterPatientEligibilityHL7Value(patientEligibilityHL7Value)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyNameFieldMessage();

        new P06_PatientEligibilityAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddPatientEligibilityButton()
                .enterPatientEligibilityName(patientEligibilityName)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyHL7ValueFieldMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        patientEligibilityTestData = new JsonUtils("PatientEligibilityTestData");
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