package Tests;

import Factories.DriverFactory;
import Listeners.TestNGListeners;
import Pages.P01_LoginPage;
import Pages.P02_UsersAdminPage;
import Pages.P10_PACSViewersAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC10_PACSViewersAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils pacsViewersTestData;

    @Test
    public void validPACSViewersTC() {
        String name = pacsViewersTestData.getJsonData("addNewPACSViewer.name") + TimestampUtils.getTimestamp();
        String urlType = pacsViewersTestData.getJsonData("addNewPACSViewer.urlType");
        String webSocketType = pacsViewersTestData.getJsonData("addNewPACSViewer.webSocketType");
        String viewerURL = pacsViewersTestData.getJsonData("addNewPACSViewer.viewerURL");
        String getMethod = pacsViewersTestData.getJsonData("addNewPACSViewer.getMethod");
        String postMethod = pacsViewersTestData.getJsonData("addNewPACSViewer.postMethod");
        String parameterKey = pacsViewersTestData.getJsonData("addNewPACSViewer.parameterKey");
        String WebSocketFilePath = pacsViewersTestData.getJsonData("addNewPACSViewer.WebSocketFilePath");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnPACSViewersButton()
                .clickOnAddNewPACSViewersButon()
                .enterPACSViewersName(name)
                .selectPACSViewerType(urlType)
                .enterViewerURL(viewerURL)
                .selectMethod(getMethod)
                .checkAnonymisedCheckbox()
                .checkEncodedCheckbox()
                .checkEncryptedCheckbox()
                .enterParameterKey(parameterKey)
                .selectSite()
                .selectPACSServer()
                .clickOnSaveButton();

        new P10_PACSViewersAdminPage(driver)
                .searchPACSViewersByName(name)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertVisibilityOfPACSViewersEditedAlert();

        new P10_PACSViewersAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfPACSViewersDeletedAlert();

        new P10_PACSViewersAdminPage(driver)
                .clickOnOkButton()
                .clickOnAddNewPACSViewersButon()
                .enterPACSViewersName(name)
                .selectPACSViewerType(urlType)
                .enterViewerURL(viewerURL)
                .selectMethod(postMethod)
                .checkAnonymisedCheckbox()
                .checkEncodedCheckbox()
                .checkEncryptedCheckbox()
                .enterParameterKey(parameterKey)
                .selectSite()
                .selectPACSServer()
                .clickOnSaveButton();

        new P10_PACSViewersAdminPage(driver)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertVisibilityOfPACSViewersEditedAlert();

        new P10_PACSViewersAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfPACSViewersDeletedAlert();

        new P10_PACSViewersAdminPage(driver)
                .clickOnOkButton()
                .clickOnAddNewPACSViewersButon()
                .enterPACSViewersName(name)
                .selectPACSViewerType(webSocketType)
                .uploadWebsocketFile(WebSocketFilePath)
                .checkAnonymisedCheckbox()
                .selectSite()
                .selectPACSServer()
                .clickOnSaveButton();

        new P10_PACSViewersAdminPage(driver)
                .clickOnEditButton(name)
                .clickOnSaveButton()
                .assertVisibilityOfPACSViewersEditedAlert();

        new P10_PACSViewersAdminPage(driver)
                .clickOnOkButton()
                .clickOnDeleteButton(name)
                .clickOnYesButton()
                .assertVisibilityOfPACSViewersDeletedAlert();
    }

    @Test
    public void invalidPACSViewersTC() {
        String name = pacsViewersTestData.getJsonData("addNewPACSViewer.name") + TimestampUtils.getTimestamp();
        String urlType = pacsViewersTestData.getJsonData("addNewPACSViewer.urlType");
        String webSocketType = pacsViewersTestData.getJsonData("addNewPACSViewer.webSocketType");
        String viewerURL = pacsViewersTestData.getJsonData("addNewPACSViewer.viewerURL");
        String invalidViewURL = pacsViewersTestData.getJsonData("addNewPACSViewer.invalidViewURL");
        String getMethod = pacsViewersTestData.getJsonData("addNewPACSViewer.getMethod");
        String parameterKey = pacsViewersTestData.getJsonData("addNewPACSViewer.parameterKey");
        String invalidWebSocketFilePath = pacsViewersTestData.getJsonData("addNewPACSViewer.invalidWebSocketFilePath");

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnConfigurationsButton()
                .clickOnPACSViewersButton()
                .clickOnAddNewPACSViewersButon()
                .enterPACSViewersName("")
                .selectPACSViewerType(urlType)
                .enterViewerURL(viewerURL)
                .selectMethod(getMethod)
                .checkAnonymisedCheckbox()
                .checkEncodedCheckbox()
                .checkEncryptedCheckbox()
                .enterParameterKey(parameterKey)
                .selectSite()
                .selectPACSServer()
                .assertVisibilityOfEmptyNameMessage();

        new P10_PACSViewersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewPACSViewersButon()
                .enterPACSViewersName(name)
                .selectPACSViewerType(urlType)
                .enterViewerURL("")
                .selectMethod(getMethod)
                .checkAnonymisedCheckbox()
                .checkEncodedCheckbox()
                .checkEncryptedCheckbox()
                .enterParameterKey(parameterKey)
                .selectSite()
                .selectPACSServer()
                .assertVisibilityOfEmptyViewerURLMessage();

        new P10_PACSViewersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewPACSViewersButon()
                .enterPACSViewersName(name)
                .selectPACSViewerType(urlType)
                .enterViewerURL(viewerURL)
                .selectMethod(getMethod)
                .checkAnonymisedCheckbox()
                .checkEncodedCheckbox()
                .checkEncryptedCheckbox()
                .enterParameterKey("")
                .selectSite()
                .selectPACSServer()
                .assertVisibilityOfEmptyParameterKeyMessage();

        new P10_PACSViewersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewPACSViewersButon()
                .clickOnSiteDropdown()
                .enterPACSViewersName(name)
                .selectPACSViewerType(urlType)
                .enterViewerURL(viewerURL)
                .selectMethod(getMethod)
                .checkAnonymisedCheckbox()
                .checkEncodedCheckbox()
                .checkEncryptedCheckbox()
                .enterParameterKey(parameterKey)
                .assertVisibilityOfEmptySiteMessage();

        new P10_PACSViewersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewPACSViewersButon()
                .clickOnPACSServerDropdown()
                .enterPACSViewersName(name)
                .selectPACSViewerType(urlType)
                .enterViewerURL(viewerURL)
                .selectMethod(getMethod)
                .checkAnonymisedCheckbox()
                .checkEncodedCheckbox()
                .checkEncryptedCheckbox()
                .enterParameterKey(parameterKey)
                .selectSite()
                .assertVisibilityOfEmptyPACSServerMessage();

        // Error here
        new P10_PACSViewersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewPACSViewersButon()
                .clickOnWebSocketTextField()
                .enterPACSViewersName(name)
                .checkAnonymisedCheckbox()
                .selectSite()
                .selectPACSServer()
                .assertVisibilityOfEmptyWebSocketFileMessage();

        new P10_PACSViewersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewPACSViewersButon()
                .enterPACSViewersName(" ")
                .selectPACSViewerType(urlType)
                .enterViewerURL(viewerURL)
                .selectMethod(getMethod)
                .checkAnonymisedCheckbox()
                .checkEncodedCheckbox()
                .checkEncryptedCheckbox()
                .enterParameterKey(parameterKey)
                .selectSite()
                .selectPACSServer()
                .assertVisibilityOfSpacesOnlyNameMessage();

//        new P10_PACSViewersAdminPage(driver)
//                .clickOnCloseButton()
//                .clickOnAddNewPACSViewersButon()
//                .enterPACSViewersName(name)
//                .selectPACSViewerType(urlType)
//                .enterViewerURL(" ")
//                .selectMethod(getMethod)
//                .checkAnonymisedCheckbox()
//                .checkEncodedCheckbox()
//                .checkEncryptedCheckbox()
//                .enterParameterKey(parameterKey)
//                .selectSite()
//                .selectPACSServer()
//                .assertVisibilityOfSpacesOnlyViewerURLMessage();

        new P10_PACSViewersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewPACSViewersButon()
                .enterPACSViewersName(name)
                .selectPACSViewerType(urlType)
                .enterViewerURL(viewerURL)
                .selectMethod(getMethod)
                .checkAnonymisedCheckbox()
                .checkEncodedCheckbox()
                .checkEncryptedCheckbox()
                .enterParameterKey(" ")
                .selectSite()
                .selectPACSServer()
                .assertVisibilityOfSpacesOnlyParameterKeyMessage();

//        new P10_PACSViewersAdminPage(driver)
//                .clickOnCloseButton()
//                .clickOnAddNewPACSViewersButon()
//                .enterPACSViewersName(name)
//                .selectPACSViewerType(urlType)
//                .enterViewerURL(invalidViewURL)
//                .selectMethod(getMethod)
//                .checkAnonymisedCheckbox()
//                .checkEncodedCheckbox()
//                .checkEncryptedCheckbox()
//                .enterParameterKey(parameterKey)
//                .selectSite()
//                .selectPACSServer()
//                .assertVisibilityOfInvalidViewerURLMessage();

        new P10_PACSViewersAdminPage(driver)
                .clickOnCloseButton()
                .clickOnAddNewPACSViewersButon()
                .enterPACSViewersName(name)
                .selectPACSViewerType(webSocketType)
                .uploadWebsocketFile(invalidWebSocketFilePath)
                .assertVisibilityOfInvalidWebSocketFileMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        pacsViewersTestData = new JsonUtils("PACSViewersTestData");
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