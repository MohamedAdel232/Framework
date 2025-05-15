package Pages;

import Factories.DriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P05_ActiveDirectoriesAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new Site\"]");
    private final By nameFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By urlFieldLocator = By.cssSelector("[formcontrolname=\"url\"]");
    private final By portFieldLocator = By.cssSelector("[formcontrolname=\"port\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");

    private final DriverFactory driver;

    public P05_ActiveDirectoriesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P05_ActiveDirectoriesAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter name")
    public P05_ActiveDirectoriesAdminPage enterName(String name) {
        driver.elementUtils().sendDataToElement(nameFieldLocator, name);
        return this;
    }

    @Step("Enter URL")
    public P05_ActiveDirectoriesAdminPage enterURL(String url) {
        driver.elementUtils().sendDataToElement(urlFieldLocator, url);
        return this;
    }

    @Step("Enter port")
    public P05_ActiveDirectoriesAdminPage enterPort(String port) {
        driver.elementUtils().sendDataToElement(portFieldLocator, port);
        return this;
    }

    @Step("Select site")
    public P05_ActiveDirectoriesAdminPage selectSite() {
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }
}
