package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Pages.P17_HangingProtocolsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC17_HangingProtocolsAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils hangingProtocolTestData;

    @Test
    public void hangingProtocolsTC() throws InterruptedException {
        String name = hangingProtocolTestData.getJsonData("addNewHangingProtocol.name") + "-" + TimestampUtils.getTimestamp();
        String modality = hangingProtocolTestData.getJsonData("addNewHangingProtocol.modality");
        String rows = hangingProtocolTestData.getJsonData("addNewHangingProtocol.rows");
        String columns = hangingProtocolTestData.getJsonData("addNewHangingProtocol.columns");


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
                .clickOnGeneralConfigButton()
                .clickOnHangingProtocolsButton()
                .clickOnAddButton()
                .enterName(name)
                .enterModality(modality)
                .checkAutoDisplayPriorsCheckbox()
                .selectSiteFromDropdown()
                .enterRows(rows)
                .enterColumns(columns)
                .clickOnSaveButton()
                .clickOnSaveButton()
                .assertVisibilityOfHangingProtocolAddedAlert();

        new P17_HangingProtocolsAdminPage(driver)
                .searchForHangingProtocol(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .clickOnSaveButton()
                .assertVisibilityOfHangingProtocolEditedAlert();

        new P17_HangingProtocolsAdminPage(driver)
                .searchForHangingProtocol(name)
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfHangingProtocolDeletedAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        hangingProtocolTestData = new JsonUtils("HangingProtocolsTestData");
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

