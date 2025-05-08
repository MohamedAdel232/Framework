package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_LibraryPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;


@Listeners(TestNGListeners.class)
public class TC03_SitesAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils sitesTestData;

    @Test
    public void sitesTC() {
        String name = sitesTestData.getJsonData("addNewSites.name") + "-" + TimestampUtils.getTimestamp();
        String hL7SiteName = sitesTestData.getJsonData("addNewSites.hl7SiteName") + "-" + TimestampUtils.getTimestamp();
        String prefix = sitesTestData.getJsonData("addNewSites.prefix") + "-" + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.username"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .assertLoginWithValidCredentials();

        new P02_LibraryPage(driver)
                .clickOnLibraryButton()
                .clickOnICodeAdministrationButton()
                .clickOnSitesButton()
                .clickOnAddButton()
                .enterName(name)
                .enterHL7SiteName(hL7SiteName)
                .enterPrefix(prefix)
                .clickOnActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfSiteAddedAlert();
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        loginTestData = new JsonUtils("LoginTestData");
        sitesTestData = new JsonUtils("SitesTestData");
    }

    @BeforeMethod
    public void setup() {
        driver = new DriverFactory(PropertiesUtils.getPropertyValue("browser"));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.browserUtils().quitBrowser();
        DriverFactory.removeDriver();
    }
}
