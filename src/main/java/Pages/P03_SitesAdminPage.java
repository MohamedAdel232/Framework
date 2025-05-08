package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import org.openqa.selenium.By;

public class P03_SitesAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new Site\"]");
    private final By nameFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By hl7SiteNameFieldLocator = By.cssSelector("[formcontrolname=\"hL7Name\"]");
    private final By prefixFieldLocator = By.cssSelector("[formcontrolname=\"prefix\"]");
    private final By activeCheckboxLocator = By.cssSelector("input[title=\"Active\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By siteAddedMessageLocator = By.cssSelector("[aria-label=\"Selected site has been added successfully\"]");

    private final DriverFactory driver;

    public P03_SitesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    public P03_SitesAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    public P03_SitesAdminPage enterName(String name) {
        driver.elementUtils().sendDataToElement(nameFieldLocator, name);
        return this;
    }

    public P03_SitesAdminPage enterHL7SiteName(String hl7SiteName) {
        driver.elementUtils().sendDataToElement(hl7SiteNameFieldLocator, hl7SiteName);
        return this;
    }

    public P03_SitesAdminPage enterPrefix(String prefix) {
        driver.elementUtils().sendDataToElement(prefixFieldLocator, prefix);
        return this;
    }

    public P03_SitesAdminPage clickOnActiveCheckbox() {
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    public P03_SitesAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    public void assertVisibilityOfSiteAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(siteAddedMessageLocator),
                "Site added alert not visible"
        );
    }
}
