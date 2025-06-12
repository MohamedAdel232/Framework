package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P09_HL7NodesAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC09_HL7NodesAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils hl7NodesTestData;

    @Test
    public void validHL7NodesTC() {
        String name = hl7NodesTestData.getJsonData("addNewHL7Node.name") + TimestampUtils.getTimestamp();
        String ipAddress = hl7NodesTestData.getJsonData("addNewHL7Node.idAddress");
        String portNo = hl7NodesTestData.getJsonData("addNewHL7Node.port");
        String description = hl7NodesTestData.getJsonData("addNewHL7Node.description");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnHL7ConfigurationsButton()
                .clickOnHL7NodesButton()
                .clickOnAddNewHL7NodeButton()
                .enterHL7NodeName(name)
                .enterIpAddress(ipAddress)
                .enterPortNo(portNo)
                .enterDescription(description)
                .selectSite()
                .checkActiveCheckbox()
                .clickOnSaveButton();

        new P09_HL7NodesAdminPage(driver)
                .searchHL7NodeByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertVisibilityOfHL7NodeEditedAlert();

        new P09_HL7NodesAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfHL7NodeDeletedAlert(name);
    }

    @Test
    public void invalidHL7NodesTC() {
        String name = hl7NodesTestData.getJsonData("addNewHL7Node.name") + TimestampUtils.getTimestamp();
        String ipAddress = hl7NodesTestData.getJsonData("addNewHL7Node.idAddress");
        String invalidIPAddress = hl7NodesTestData.getJsonData("addNewHL7Node.invalidIPAddress");
        String portNo = hl7NodesTestData.getJsonData("addNewHL7Node.port");
        String invalidPortNo = hl7NodesTestData.getJsonData("addNewHL7Node.invalidPort");
        String description = hl7NodesTestData.getJsonData("addNewHL7Node.description");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnHL7ConfigurationsButton()
                .clickOnHL7NodesButton()
                .clickOnAddNewHL7NodeButton()
                .enterHL7NodeName("")
                .enterIpAddress(ipAddress)
                .enterPortNo(portNo)
                .enterDescription(description)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyNameMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewHL7NodeButton()
                .enterHL7NodeName(name)
                .enterIpAddress("")
                .enterPortNo(portNo)
                .enterDescription(description)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyIpAddressMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewHL7NodeButton()
                .enterHL7NodeName(name)
                .enterIpAddress(ipAddress)
                .enterPortNo("")
                .enterDescription(description)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfEmptyPortNoMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewHL7NodeButton()
                .clickOnSiteDropdown()
                .enterHL7NodeName(name)
                .enterIpAddress(ipAddress)
                .enterPortNo(portNo)
                .enterDescription(description)
                .checkActiveCheckbox()
                .assertVisibilityOfEmptySiteMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewHL7NodeButton()
                .enterHL7NodeName(" ")
                .enterIpAddress(ipAddress)
                .enterPortNo(portNo)
                .enterDescription(description)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfSpacesOnlyNameMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewHL7NodeButton()
                .enterHL7NodeName(name)
                .enterIpAddress(" ")
                .enterPortNo(portNo)
                .enterDescription(description)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfSpacesOnlyIpAddressMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewHL7NodeButton()
                .enterHL7NodeName(name)
                .enterIpAddress(invalidIPAddress)
                .enterPortNo(portNo)
                .enterDescription(description)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfInvalidIPAddressMessage();

        new P09_HL7NodesAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewHL7NodeButton()
                .enterHL7NodeName(name)
                .enterIpAddress(ipAddress)
                .enterPortNo(invalidPortNo)
                .enterDescription(description)
                .selectSite()
                .checkActiveCheckbox()
                .assertVisibilityOfInvalidPortNoMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        hl7NodesTestData = new JsonUtils("HL7NodesTestData");
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