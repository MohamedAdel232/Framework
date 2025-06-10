package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P05_SpecialtiesAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC05_SpecialtiesAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils specialtiesTestData;

    @Test
    public void validSpecialtiesTC() {
        String specialtyName = specialtiesTestData.getJsonData("addNewSpecialty.specialtyName") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnSpecialtiesButton()
                .clickOnAddNewSpecialtyButton()
                .enterSpecialtyName(specialtyName)
                .selectSite()
                .clickOnSaveButton()
        //        .assertVisibilityOfSpecialtyAddedAlert()
        ;

        new P05_SpecialtiesAdminPage(driver)
                //      .clickOnOkButton()
                .searchSpecialtyByName(specialtyName)
                .clickOnEditButton(specialtyName)
                .clickOnSaveButton()
                .assertVisibilityOfSpecialtyEditedAlert();

        new P05_SpecialtiesAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(specialtyName)
                .clickOnYesButton()
                .assertVisibilityOfSpecialtyDeletedAlert();
    }

    @Test
    public void invalidSpecialtiesTC() {
        String specialtyName = specialtiesTestData.getJsonData("addNewSpecialty.specialtyName") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnSpecialtiesButton()
                .clickOnAddNewSpecialtyButton()
                .enterSpecialtyName("")
                .selectSite()
                .assertVisibilityOfEmptySpecialtyNameMessage();

        new P05_SpecialtiesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewSpecialtyButton()
                .clickOnSiteDropdown()
                .enterSpecialtyName(specialtyName)
                .assertVisibilityOfEmptySiteMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        specialtiesTestData = new JsonUtils("SpecialtiesTestData");
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