package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P03_SitesAdminPage;
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
    public void validSitesTC() {
        String siteName = sitesTestData.getJsonData("addNewSite.siteName") + "-" + TimestampUtils.getTimestamp();
        String hl7SiteName = sitesTestData.getJsonData("addNewSite.hl7SiteName");
        String pacsCallingAETitle = sitesTestData.getJsonData("addNewSite.pacsCallingAETitle");
        String mdtKeywords = sitesTestData.getJsonData("addNewSite.mdtKeywords");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnSitesButton()
                .clickOnAddNewSiteButton()
                .enterSiteName(siteName)
                .enterHL7SiteName(hl7SiteName)
                .enterPacsCallingAETitle(pacsCallingAETitle)
                .enterMdtKeywords(mdtKeywords)
                .checkActiveCheckbox()
                .checkEnableTwoFactorAuthenticationCheckbox()
                .clickOnSaveButton();

        new P03_SitesAdminPage(driver)
                .searchSiteByName(siteName)
                .clickOnEditButton(siteName)
                .clickOnSaveButton()
                .assertVisibilityOfSiteEditedAlert();

        new P03_SitesAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(siteName)
                .clickOnYesButton()
                .assertVisibilityOfSiteDeletedAlert();
    }

    @Test
    public void invalidSitesTC() {
        String siteName = sitesTestData.getJsonData("addNewSite.siteName") + "-" + TimestampUtils.getTimestamp();
        String hl7SiteName = sitesTestData.getJsonData("addNewSite.hl7SiteName");
        String pacsCallingAETitle = sitesTestData.getJsonData("addNewSite.pacsCallingAETitle");
        String mdtKeywords = sitesTestData.getJsonData("addNewSite.mdtKeywords");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnSitesButton()
                .clickOnAddNewSiteButton()
                .enterSiteName("")
                .enterHL7SiteName(hl7SiteName)
                .enterPacsCallingAETitle(pacsCallingAETitle)
                .enterMdtKeywords(mdtKeywords)
                .checkActiveCheckbox()
                .checkEnableTwoFactorAuthenticationCheckbox()
                .assertVisibilityOfEmptySiteNameMessage();

        new P03_SitesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewSiteButton()
                .enterSiteName(siteName)
                .enterHL7SiteName("")
                .enterPacsCallingAETitle(pacsCallingAETitle)
                .enterMdtKeywords(mdtKeywords)
                .checkActiveCheckbox()
                .checkEnableTwoFactorAuthenticationCheckbox()
                .assertVisibilityOfEmptyHL7SiteNameMessage();

        new P03_SitesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewSiteButton()
                .enterSiteName(siteName)
                .enterHL7SiteName(hl7SiteName)
                .enterPacsCallingAETitle("")
                .enterMdtKeywords(mdtKeywords)
                .checkActiveCheckbox()
                .checkEnableTwoFactorAuthenticationCheckbox()
                .assertVisibilityOfEmptyPacsCallingAETitleMessage();

        new P03_SitesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewSiteButton()
                .enterSiteName(" ")
                .enterHL7SiteName(hl7SiteName)
                .enterPacsCallingAETitle(pacsCallingAETitle)
                .enterMdtKeywords(mdtKeywords)
                .checkActiveCheckbox()
                .checkEnableTwoFactorAuthenticationCheckbox()
                .assertVisibilityOfSpacesOnlySiteNameMessage();

        new P03_SitesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewSiteButton()
                .enterSiteName(siteName)
                .enterHL7SiteName(" ")
                .enterPacsCallingAETitle(pacsCallingAETitle)
                .enterMdtKeywords(mdtKeywords)
                .checkActiveCheckbox()
                .checkEnableTwoFactorAuthenticationCheckbox()
                .assertVisibilityOfSpacesOnlyHL7SiteNameMessage();

        new P03_SitesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewSiteButton()
                .enterSiteName(siteName)
                .enterHL7SiteName(hl7SiteName)
                .enterPacsCallingAETitle(" ")
                .enterMdtKeywords(mdtKeywords)
                .checkActiveCheckbox()
                .checkEnableTwoFactorAuthenticationCheckbox()
                .assertVisibilityOfSpacesOnlyPacsCallingAETitleMessage();
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
