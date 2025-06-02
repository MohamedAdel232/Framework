package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P03_PatientTypeAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC03_PatientTypeAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils patientTypeTestData;

    @Test
    public void validPatientTypeTC() {
        String patientTypeName = patientTypeTestData.getJsonData("addNewPatientType.patientTypeName") + TimestampUtils.getTimestamp();
        String patientTypeHL7Value = patientTypeTestData.getJsonData("addNewPatientType.patientTypeHL7Value");

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
                .clickOnPatientTypeAdminButton()
                .clickOnAddPatientTypeButton()
                .enterPatientTypeName(patientTypeName)
                .enterPatientTypeHL7Value(patientTypeHL7Value)
                .clickOnSaveButton()
                .assertVisibilityOfPatientTypeAddedAlert();

        new P03_PatientTypeAdminPage(driver)
                .searchForPatientTypeByName(patientTypeName)
                .clickOnEditButton(patientTypeName)
                .clickOnSaveButton()
                .assertVisibilityOfPatientTypeEditedAlert();

        new P03_PatientTypeAdminPage(driver)
                .searchForPatientTypeByName(patientTypeName)
                .clickOnDeleteButton(patientTypeName)
                .clickOnYesButton()
                .assertVisibilityOfPatientTypeDeletedAlert();
    }

    @Test
    public void invalidPatientTypeTC() {
        String patientTypeName = patientTypeTestData.getJsonData("addNewPatientType.patientTypeName") + TimestampUtils.getTimestamp();
        String patientTypeHL7Value = patientTypeTestData.getJsonData("addNewPatientType.patientTypeHL7Value");

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
                .clickOnPatientTypeAdminButton()
                .clickOnAddPatientTypeButton()
                .enterPatientTypeHL7Value(patientTypeHL7Value)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyNameFieldMessage();

        new P03_PatientTypeAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddPatientTypeButton()
                .enterPatientTypeName(patientTypeName)
                .clickOnSaveButton()
                .assertVisibilityOfEmptyHL7ValueFieldMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        patientTypeTestData = new JsonUtils("PatientTypeTestData");
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
