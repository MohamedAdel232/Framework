package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P08_DICOMDestinationsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC08_DICOMDestinationAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils dicomDestinationTestData;

    @Test
    public void dicomDestinationTC() throws InterruptedException {
        String dicomDestinationName = dicomDestinationTestData.getJsonData("addNewDICOMDestination.name") + "-" + TimestampUtils.getTimestamp();
        String dicomDestinationIPAddress = dicomDestinationTestData.getJsonData("addNewDICOMDestination.idAddress");
        String dicomDestinationAETitle = dicomDestinationTestData.getJsonData("addNewDICOMDestination.AETitle");
        String dicomDestinationPort = dicomDestinationTestData.getJsonData("addNewDICOMDestination.port");


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
                .clickOnDICOMDestinationsButton()
                .clickOnAddButton()
                .enterName(dicomDestinationName)
                .enterIPAddress(dicomDestinationIPAddress)
                .enterAETitle(dicomDestinationAETitle)
                .enterPort(dicomDestinationPort)
                .selectSite()
                .clickOnActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfDICOMDestinationAddedAlert();

        new P08_DICOMDestinationsAdminPage(driver)
                .clickOnEditButton(dicomDestinationName)
                .clickOnSaveButton()
                .assertVisibilityOfDICOMDestinationEditedAlert();

        new P08_DICOMDestinationsAdminPage(driver)
                .clickOnDeleteButton(dicomDestinationName)
                .clickOnYesButton()
                .assertVisibilityOfDICOMDestinationDeletedAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        dicomDestinationTestData = new JsonUtils("DICOMDestinationTestData");
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

