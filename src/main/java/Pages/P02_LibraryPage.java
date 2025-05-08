package Pages;

import Factories.DriverFactory;
import org.openqa.selenium.By;

public class P02_LibraryPage {
    private final By libraryButtonLocator = By.xpath("//span [text()=\"Library\"]");
    private final By iCodeAdministrationButtonLocator = By.xpath("//span [text()=\"iCode Administration\"]");
    private final By sitesButtonLocator = By.cssSelector("[href=\"/iCodeTFS/admin/sites\"]");

    private final DriverFactory driver;

    public P02_LibraryPage(DriverFactory driver) {
        this.driver = driver;
    }

    public P02_LibraryPage clickOnLibraryButton() {
        driver.elementUtils().clickOnElement(libraryButtonLocator);
        return this;
    }

    public P02_LibraryPage clickOnICodeAdministrationButton() {
        driver.elementUtils().clickOnElement(iCodeAdministrationButtonLocator);
        return this;
    }

    public P03_SitesAdminPage clickOnSitesButton() {
        driver.elementUtils().clickOnElement(sitesButtonLocator);
        return new P03_SitesAdminPage(driver);
    }
}
