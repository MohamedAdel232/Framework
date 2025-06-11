package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_UsersAdminPage {
    private final By sitesButtonLocator = By.cssSelector("[routerlink=\"/admin/sites\"]");
    private final By groupsButtonLocator = By.cssSelector("[routerlink=\"/admin/groups\"]");
    private final By specialtiesButtonLocator = By.cssSelector("[routerlink=\"/admin/specialties\"]");
    private final By configurationsButtonLocator = By.xpath("//span[.=\"Configurations\"] /..");
    private final By pacsServersButtonLocator = By.cssSelector("[routerlink=\"/admin/pacsservers\"]");
    private final By activeDirectoriesButtonLocator = By.cssSelector("[routerlink=\"/admin/activedirectories\"]");
    private final By webConferencingToolsButtonLocator = By.cssSelector("[routerlink=\"/admin/webconferencingtools\"]");

    private final DriverFactory driver;

    public P02_UsersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Sites button")
    public P03_SitesAdminPage clickOnSitesButton() {
        LogsUtils.info("Clicking on Sites button");
        driver.elementUtils().clickOnElement(sitesButtonLocator);
        return new P03_SitesAdminPage(driver);
    }

    @Step("Click on Groups button")
    public P04_GroupsAdminPage clickOnGroupsButton() {
        LogsUtils.info("Clicking on Groups button");
        driver.elementUtils().clickOnElement(groupsButtonLocator);
        return new P04_GroupsAdminPage(driver);
    }

    @Step("Click on Specialties button")
    public P05_SpecialtiesAdminPage clickOnSpecialtiesButton() {
        LogsUtils.info("Clicking on Specialties button");
        driver.elementUtils().clickOnElement(specialtiesButtonLocator);
        return new P05_SpecialtiesAdminPage(driver);
    }

    @Step("Click on Configurations button")
    public P02_UsersAdminPage clickOnConfigurationsButton() {
        LogsUtils.info("Clicking on Configurations button");
        driver.elementUtils().clickOnElement(configurationsButtonLocator);
        return new P02_UsersAdminPage(driver);
    }

    @Step("Click on PACS Servers button")
    public P06_PACSServersAdminPage clickOnPACSServersButton() {
        LogsUtils.info("Clicking on PACS Servers button");
        driver.elementUtils().clickOnElement(pacsServersButtonLocator);
        return new P06_PACSServersAdminPage(driver);
    }

    @Step("Click on Active Directories button")
    public P07_ActiveDirectoriesAdminPage clickOnActiveDirectoriesButton() {
        LogsUtils.info("Clicking on Active Directories button");
        driver.elementUtils().clickOnElement(activeDirectoriesButtonLocator);
        return new P07_ActiveDirectoriesAdminPage(driver);
    }

    @Step("Click on Web Conferencing Tools button")
    public P08_WebConferencingToolsAdminPage clickOnWebConferencingToolsButton() {
        LogsUtils.info("Clicking on Web Conferencing Tools button");
        driver.elementUtils().clickOnElement(webConferencingToolsButtonLocator);
        return new P08_WebConferencingToolsAdminPage(driver);
    }
}