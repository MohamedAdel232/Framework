package Tests;

import Factories.DriverFactory;
import Pages.P01_LoginPage;
import Listeners.TestNGListeners;
import Pages.P02_UsersAdminPage;
import Pages.P14_FoldersAdminPage;
import Utilities.JsonUtils;
import Utilities.PropertiesUtils;
import Utilities.TimestampUtils;
import org.testng.annotations.*;

@Listeners(TestNGListeners.class)
public class TC14_FoldersAdminTest {
    DriverFactory driver;
    JsonUtils loginTestData;
    JsonUtils foldersTestData;

    @Test
    public void validFolderTC() throws InterruptedException {
        String folderName = foldersTestData.getJsonData("addNewFolder.name") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnFoldersButton()
                .clickOnAddFolderButton()
                .enterFolderName(folderName)
                .selectSubspecialty()
                .checkSetAsDefaultCheckbox()
                .selectFilterRowSettings()
                .selectOperator()
                .selectCode()
                .clickOnSaveButton()
                .assertVisibilityOfFolderAddedAlert();

        new P14_FoldersAdminPage(driver)
                .searchForFolder(folderName)
                .clickOnEditButton(folderName)
                .clickOnSaveButton()
                .assertVisibilityOfFolderEditedAlert();

        new P14_FoldersAdminPage(driver)
                .searchForFolder(folderName)
                .clickOnDeleteButton(folderName)
                .clickOnYesButton()
                .assertVisibilityOfFolderDeletedAlert();
    }

    @Test
    public void invalidFolderTC() {
        String folderName = foldersTestData.getJsonData("addNewFolder.name") + TimestampUtils.getTimestamp();

        new P01_LoginPage(driver)
                .navigateToLoginPage(PropertiesUtils.getPropertyValue("LoginPageUrl"))
                .enterUsername(loginTestData.getJsonData("validLoginCredentials.powerAdminUsername"))
                .enterPassword(loginTestData.getJsonData("validLoginCredentials.password"))
                .clickLoginButton()
                .terminateSession()
                .assertLoginWithValidAdminCredentials();

        new P02_UsersAdminPage(driver)
                .clickOnFoldersButton()
                .clickOnAddFolderButton()
                .selectSubspecialty()
                .selectFilterRowSettings()
                .selectOperator()
                .selectCode()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyNameFieldMessage();

        new P14_FoldersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddFolderButton()
                .enterFolderName(folderName)
                .selectFilterRowSettings()
                .selectOperator()
                .selectCode()
                .clickOnSaveButton()
                .assertVisibilityOfEmptySubspecialtyMessage();

        new P14_FoldersAdminPage(driver)
                .clickOnCancelButton()
                .clickOnAddFolderButton()
                .enterFolderName(folderName)
                .selectSubspecialty()
                .clickOnSaveButton()
                .assertVisibilityOfEmptyParameterMessage();
    }

    @BeforeClass
    public void beforeClass() {
        loginTestData = new JsonUtils("LoginTestData");
        foldersTestData = new JsonUtils("FoldersTestData");
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