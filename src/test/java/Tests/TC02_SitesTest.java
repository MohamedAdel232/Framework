package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_SitesPage;
import Pages.P02_UsersAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC02_SitesTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils sitesTestData;

    @Test
    public void addSiteWithValidData() throws InterruptedException{
        String siteName = sitesTestData.getJsonData("addNewSites.name") + "-" + TimestampUtils.getTimestamp();
        String hl7SiteName = sitesTestData.getJsonData("addNewSites.hl7SiteName") + "-" + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession();
        new P02_UsersAdminPage(driver)
                .clickOnSitesButton()
                .clickAddButton()
                .enterSiteName(siteName)
                .enterHl7SiteName(hl7SiteName)
                .clickSaveButton()
                .assertVisibilityOfSiteAddedAlert();
    }

    @Test
    public void addSiteWithInValidData() throws InterruptedException{
        String siteName = sitesTestData.getJsonData("addNewSites.name") + "-" + TimestampUtils.getTimestamp();
        String hl7SiteName = sitesTestData.getJsonData("addNewSites.hl7SiteName") + "-" + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession();
        // empty site name
        new P02_UsersAdminPage(driver)
                .clickOnSitesButton()
                .clickAddButton()
               // .enterSiteName(siteName)
                .enterHl7SiteName(hl7SiteName)
                .clickSaveButton()
                .assertVisibilityOfEmptySiteNameAlert();
        // spaces only site name
        new P02_SitesPage(driver)
                .clickCancelButton()
                .clickAddButton()
                .enterSiteName("   ")
                .enterHl7SiteName(hl7SiteName)
                .clickSaveButton()
                .assertVisibilityOfEmptySiteNameAlert();
        // empty hl7 site name
        new P02_SitesPage(driver)
                .clickCancelButton()
                .clickAddButton()
                .enterSiteName(siteName)
              //  .enterHl7SiteName(hl7SiteName)
                .clickSaveButton()
                .assertVisibilityOfEmptyHl7SiteNameAlert();

        // spaces only hl7 site name
        new P02_SitesPage(driver)
                .clickCancelButton()
                .clickAddButton()
                .enterSiteName(siteName)
                .enterHl7SiteName("   ")
                .clickSaveButton()
                .assertVisibilityOfEmptyHl7SiteNameAlert();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        sitesTestData = new JsonUtils("SitesTestData");
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
