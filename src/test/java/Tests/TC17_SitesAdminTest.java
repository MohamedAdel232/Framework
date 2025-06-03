package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P17_SitesAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC17_SitesAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils siteTestData;

    @Test
    public void validSiteTC()  {
        String siteName = siteTestData.getJsonData("addNewSite.name") + TimestampUtils.getTimestamp();
        String hl7SiteName = siteTestData.getJsonData("addNewSite.hl7SiteName");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnSitesButton()
                .clickOnAddSiteButton()
                .enterSiteName(siteName)
                .enterHL7SiteName(hl7SiteName)
                .clickActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfSiteAddedAlert();

        new P17_SitesAdminPage(driver)
                .searchForSite(siteName)
                .clickOnEditButton(siteName)
                .clickOnSaveButton()
                .assertVisibilityOfSiteEditedAlert();

        new P17_SitesAdminPage(driver)
                .clickOnDeleteButton(siteName)
                .clickOnYesButton()
                .assertVisibilityOfSiteDeletedAlert();
    }

    @Test
    public void invalidSiteTC() {
        String siteName = siteTestData.getJsonData("addNewSite.name") + TimestampUtils.getTimestamp();
        String hl7SiteName = siteTestData.getJsonData("addNewSite.hl7SiteName") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnSitesButton()
                .clickOnAddSiteButton()
                .enterHL7SiteName(hl7SiteName)
                .clickActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyNameFieldMessage();

        new P17_SitesAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddSiteButton()
                .enterSiteName(siteName)
                .clickActiveCheckbox()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyHL7SiteNameFieldMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        siteTestData = new JsonUtils("SiteTestData");
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
