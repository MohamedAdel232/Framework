package Pages;

import Factories.DriverFactory;
import org.openqa.selenium.By;

public class P02_LibraryPage {
    private final By libraryButtonLocator = By.cssSelector("[data-bs-target=\"#collapse640231ea-3055-4e2d-82d6-421bb42e6d1c\"]");
    private final By iCodeAdministrationButtonLocator = By.cssSelector("[data-bs-target=\"#collapseSection534ba805-f1c3-48eb-8354-b71d7bf3a750\"]");
    private final By sitesButtonLocator = By.cssSelector("[href=\"/iCodeTFS/admin/sites\"]");

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
}
