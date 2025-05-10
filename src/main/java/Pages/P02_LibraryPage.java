package Pages;

import Factories.DriverFactory;
import org.openqa.selenium.By;

public class P02_LibraryPage {
    private final By libraryButtonLocator = By.cssSelector("[data-bs-target=\"#collapse640231ea-3055-4e2d-82d6-421bb42e6d1c\"]");
    private final By iCodeAdministrationButtonLocator = By.cssSelector("[data-bs-target=\"#collapseSection534ba805-f1c3-48eb-8354-b71d7bf3a750\"]");
    private final By sitesButtonLocator = By.cssSelector("[href=\"/iCodeTFS/admin/sites\"]");
    private final By usersManagementButtonLocator = By.cssSelector("[data-bs-target=\"#collapse2db827f2-689f-4c11-8397-312dba100945\"]");
    private final By userGroupsButtonLocator = By.cssSelector("[href=\"/iCodeTFS/admin/usergroups\"]");


    private final DriverFactory driver;

    public P02_LibraryPage(DriverFactory driver) {
        this.driver = driver;
    }

    public P02_LibraryPage clickOnLibraryButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.elementUtils().clickOnElement(libraryButtonLocator);
        return this;
    }

    public P02_LibraryPage clickOnICodeAdministrationButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.elementUtils().clickOnElement(iCodeAdministrationButtonLocator);
        return this;
    }

    public P03_SitesAdminPage clickOnSitesButton() {
        driver.elementUtils().clickOnElement(sitesButtonLocator);
        return new P03_SitesAdminPage(driver);
    }

    public P02_LibraryPage clickOnUsersManagementButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.elementUtils().clickOnElement(usersManagementButtonLocator);
        return this;
    }

    public P04_UserGroupsAdminPage clickOnUserGroupsButton() {
        driver.elementUtils().clickOnElement(userGroupsButtonLocator);
        return new P04_UserGroupsAdminPage(driver);
    }
}
