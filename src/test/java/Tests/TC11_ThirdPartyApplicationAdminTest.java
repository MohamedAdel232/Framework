package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P11_ThirdPartyApplicationsAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC11_ThirdPartyApplicationAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils thirdPartApplicationTestData;

    @Test
    public void validThirdPartyApplicationTC() {
        String name = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.name") + "-" + TimestampUtils.getTimestamp();
        String url = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.url");
        String tooltip = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.tooltip");
        String getMethod = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.getMethod");
        String postMethod = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.postMethod");
        String constantValue = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.constantValue");
        String variableValue = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.variableValue");
        String key = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.key");
        String value = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.value");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnThirdPartyApplicationsButton()
                .clickOnAddNewThirdPartyApplicationButon()
                .enterName(name)
                .selectSite()
                .enterURL(url)
                .selectMethod(getMethod)
                .enterTooltip(tooltip)
                .checkActiveCheckbox()
                .clickOnAddNewParameterButton()
                .enterKey(key)
                .selectType(constantValue)
                .enterValue(value)
                .clickOnSaveParameterButton()
                .clickOnAddNewParameterButton()
                .enterKey(key)
                .selectType(variableValue)
                .selectValue()
                .clickOnSaveParameterButton()
                .clickOnSaveButton();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .searchThirdPartyApplicationByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertVisibilityOfThirdPartyApplicationEditedAlert();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .clickOnOkButton()
                .searchThirdPartyApplicationByName(name)
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfThirdPartyApplicationDeletedAlert();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .clickOnOkButton()
                .clickOnAddNewThirdPartyApplicationButon()
                .enterName(name)
                .selectSite()
                .enterURL(url)
                .selectMethod(postMethod)
                .enterTooltip(tooltip)
                .checkActiveCheckbox()
                .clickOnAddNewParameterButton()
                .enterKey(key)
                .selectType(constantValue)
                .enterValue(value)
                .clickOnSaveParameterButton()
                .clickOnAddNewParameterButton()
                .enterKey(key)
                .selectType(variableValue)
                .selectValue()
                .clickOnSaveParameterButton()
                .clickOnSaveButton();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .searchThirdPartyApplicationByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertVisibilityOfThirdPartyApplicationEditedAlert();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .clickOnOkButton()
                .searchThirdPartyApplicationByName(name)
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfThirdPartyApplicationDeletedAlert();
    }

    @Test
    public void invalidHL7NodesTC() {
        String name = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.name") + "-" + TimestampUtils.getTimestamp();
        String url = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.url");
        String invalidUrl = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.invalidUrl");
        String tooltip = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.tooltip");
        String getMethod = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.getMethod");
        String constantValue = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.constantValue");
        String key = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.key");
        String value = thirdPartApplicationTestData.getJsonData("addNewThirdPartyApplication.value");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnThirdPartyApplicationsButton()
                .clickOnAddNewThirdPartyApplicationButon()
                .enterName("")
                .selectSite()
                .enterURL(url)
                .selectMethod(getMethod)
                .enterTooltip(tooltip)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyNameMessage();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewThirdPartyApplicationButon()
                .clickOnSiteDropdown()
                .enterName(name)
                .enterURL(url)
                .selectMethod(getMethod)
                .enterTooltip(tooltip)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptySiteMessage();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewThirdPartyApplicationButon()
                .enterName(name)
                .selectSite()
                .enterURL("")
                .selectMethod(getMethod)
                .enterTooltip(tooltip)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyURLMessage();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewThirdPartyApplicationButon()
                .enterName(name)
                .selectSite()
                .enterURL(url)
                .selectMethod(getMethod)
                .enterTooltip(tooltip)
                .checkActiveCheckbox()
                .clickOnAddNewParameterButton()
                .enterKey("")
                .selectType(constantValue)
                .enterValue(value)
                .assertVisibilityOfEmptyKeyMessage();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewParameterButton()
                .enterValue("")
                .enterKey(key)
                .selectType(constantValue)
                .assertVisibilityOfEmptyValueMessage();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnBackButton()
                .clickOnAddNewThirdPartyApplicationButon()
                .enterName(" ")
                .selectSite()
                .enterURL(url)
                .selectMethod(getMethod)
                .enterTooltip(tooltip)
                .checkActiveCheckbox()
                .assertVisibilityOfSpacesOnlyNameMessage();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewThirdPartyApplicationButon()
                .enterName(name)
                .selectSite()
                .enterURL(" ")
                .selectMethod(getMethod)
                .enterTooltip(tooltip)
                .checkActiveCheckbox()
                .assertVisibilityOfSpacesOnlyURLMessage();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .clickOnBackButton()
                .clickOnAddNewThirdPartyApplicationButon()
                .enterName(name)
                .selectSite()
                .enterURL(url)
                .selectMethod(getMethod)
                .enterTooltip(tooltip)
                .checkActiveCheckbox()
                .clickOnAddNewParameterButton()
                .enterKey(" ")
                .selectType(constantValue)
                .enterValue(value)
                .assertVisibilityOfSpacesOnlyKeyMessage();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewParameterButton()
                .enterValue(" ")
                .enterKey(key)
                .selectType(constantValue)
                .assertVisibilityOfSpacesOnlyValueMessage();

        new P11_ThirdPartyApplicationsAdminPage(driver)
                .clickOnCloseButton()
                .clickOnBackButton()
                .clickOnAddNewThirdPartyApplicationButon()
                .enterName(name)
                .selectSite()
                .enterURL(invalidUrl)
                .selectMethod(getMethod)
                .enterTooltip(tooltip)
                .checkActiveCheckbox()
                .assertVisibilityOfInvalidURLMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        thirdPartApplicationTestData = new JsonUtils("ThirdPartyApplicationTestData");
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
