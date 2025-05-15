package Pages;

import Factories.DriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_LibraryPage {
    private final By libraryButtonLocator = By.xpath("//span[text()=\"Library\"] /..");
    private final By iCodeAdministrationButtonLocator = By.xpath("//span[text()=\"iCode Administration\"] /..");
    private final By sitesButtonLocator = By.cssSelector("[href=\"/iCodeTFS/admin/sites\"]");
    private final By usersManagementButtonLocator = By.xpath("//span[text()=\"Users Management\"] /..");
    private final By userGroupsButtonLocator = By.cssSelector("[href=\"/iCodeTFS/admin/usergroups\"]");
    private final By generalConfigButtonLocator = By.xpath("//span[text()=\"General Configuration\"] /..");
    private final By activeDirectoriesButtonLocator = By.cssSelector("[href=\"/iCodeTFS/admin/activedirectories\"]");
    private final By anatomyButtonLocator = By.cssSelector("[href=\"/iCodeTFS/anatomies\"]");
    private final By pathologyButtonLocator = By.cssSelector("[href=\"/iCodeTFS/pathologies\"]");
    private final DriverFactory driver;

    public P02_LibraryPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Library button")
    public P02_LibraryPage clickOnLibraryButton() throws InterruptedException {
        //Thread.sleep(1000);
        driver.elementUtils().clickOnElement(libraryButtonLocator);
        return this;
    }

    @Step("Click on iCode Administration button")
    public P02_LibraryPage clickOnICodeAdministrationButton() throws InterruptedException {
        //Thread.sleep(1000);
        driver.elementUtils().clickOnElement(iCodeAdministrationButtonLocator);
        return this;
    }

    @Step("Click on Sites button")
    public P03_SitesAdminPage clickOnSitesButton() {
        driver.elementUtils().clickOnElement(sitesButtonLocator);
        return new P03_SitesAdminPage(driver);
    }

    @Step("Click on Users Management button")
    public P02_LibraryPage clickOnUsersManagementButton() throws InterruptedException {
//        Thread.sleep(1000);
        driver.elementUtils().clickOnElement(usersManagementButtonLocator);
        return this;
    }

    @Step("Click on User Groups button")
    public P04_UserGroupsAdminPage clickOnUserGroupsButton() {
        driver.elementUtils().clickOnElement(userGroupsButtonLocator);
        return new P04_UserGroupsAdminPage(driver);
    }

    @Step("Click on General Configuration button")
    public P02_LibraryPage clickOnGeneralConfigButton() {
        driver.elementUtils().clickOnElement(generalConfigButtonLocator);
        return new P02_LibraryPage(driver);
    }

    @Step("Click on Active Directories button")
    public P05_ActiveDirectoriesAdminPage clickOnActiveDirectoriesButton() {
        driver.elementUtils().clickOnElement(activeDirectoriesButtonLocator);
        return new P05_ActiveDirectoriesAdminPage(driver);
    }

    @Step("Click on Anatomy button")
    public P06_AnatomyAdminPage clickOnAnatomyButton() {
        driver.elementUtils().clickOnElement(anatomyButtonLocator);
        return new P06_AnatomyAdminPage(driver);
    }

    @Step("Click on Pathology button")
    public P07_PathologyAdminPage clickOnPathologyButton() {
        driver.elementUtils().clickOnElement(pathologyButtonLocator);
        return new P07_PathologyAdminPage(driver);
    }
}
