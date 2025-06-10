package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_UsersAdminPage {
    private final By sitesButtonLocator = By.cssSelector("[routerlink=\"/admin/sites\"]");
    private final By groupsButtonLocator = By.cssSelector("[routerlink=\"/admin/groups\"]");

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
}