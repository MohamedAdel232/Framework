package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Utilities.JsonUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
                .navigateToLoginPage("LoginPageUrl")
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.username"))
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
}
