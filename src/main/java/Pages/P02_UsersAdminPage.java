package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_UsersAdminPage {
    private final By institutionsButtonLocator = By.cssSelector("[routerlink=\"/admin/institutions\"]");
    private final By locationsButtonLocator = By.cssSelector("[routerlink=\"/admin/locations\"]");

    private final DriverFactory driver;

    public P02_UsersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Institution Button")
    public P03_InstitutionsAdminPage clickOnInstitutionButton() {
        LogsUtils.info("Clicking on Institution Button");
        driver.elementUtils().clickOnElement(institutionsButtonLocator);
        return new P03_InstitutionsAdminPage(driver);
    }

    @Step("Click on Location Button")
    public P04_LocationsAdminPage clickOnLocationButton() {
        LogsUtils.info("Clicking on Location Button");
        driver.elementUtils().clickOnElement(locationsButtonLocator);
        return new P04_LocationsAdminPage(driver);
    }


}