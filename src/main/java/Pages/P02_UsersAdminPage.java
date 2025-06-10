package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_UsersAdminPage {
    private final By institutionsButtonLocator = By.cssSelector("[routerlink=\"/admin/institutions\"]");

    private final DriverFactory driver;

    public P02_UsersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Institutions button")
    public P03_InstitutionsAdminPage clickOnInstitutionsButton() {
        LogsUtils.info("Clicking on Institutions button");
        driver.elementUtils().clickOnElement(institutionsButtonLocator);
        return new P03_InstitutionsAdminPage(driver);
    }
}