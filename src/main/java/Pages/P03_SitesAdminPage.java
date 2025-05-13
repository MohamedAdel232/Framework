package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P03_SitesAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new Site\"]");
    private final By nameFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By hl7SiteNameFieldLocator = By.cssSelector("[formcontrolname=\"hL7Name\"]");
    private final By prefixFieldLocator = By.cssSelector("[formcontrolname=\"prefix\"]");
    private final By activeCheckboxLocator = By.cssSelector("input[title=\"Active\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By siteAddedMessageLocator = By.cssSelector("[aria-label=\"New site has been added successfully\"]");
    private final By siteEditedMessageLocator = By.cssSelector("[aria-label=\"Selected site has been edited successfully\"]");
    private final By siteDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected site has been deleted successfully\"]");

    private final DriverFactory driver;

    public P03_SitesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P03_SitesAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter site name")
    public P03_SitesAdminPage enterName(String name) {
        driver.elementUtils().sendDataToElement(nameFieldLocator, name);
        return this;
    }

    @Step("Enter HL7 site name")
    public P03_SitesAdminPage enterHL7SiteName(String hl7SiteName) {
        driver.elementUtils().sendDataToElement(hl7SiteNameFieldLocator, hl7SiteName);
        return this;
    }

    @Step("Enter prefix")
    public P03_SitesAdminPage enterPrefix(String prefix) {
        driver.elementUtils().sendDataToElement(prefixFieldLocator, prefix);
        return this;
    }

    @Step("Click on Active checkbox")
    public P03_SitesAdminPage clickOnActiveCheckbox() {
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save button")
    public P03_SitesAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P03_SitesAdminPage clickOnEditButton(String siteName) {
        By editButtonLocator = By.xpath("//td[.='" + siteName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P03_SitesAdminPage clickOnDeleteButton(String siteName) {
        By deleteButtonLocator = By.xpath("//td[.='" + siteName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P03_SitesAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of site added alert")
    public void assertVisibilityOfSiteAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(siteAddedMessageLocator),
                "Site added alert not visible"
        );
    }

    @Step("Assert visibility of site edited alert")
    public void assertVisibilityOfSiteEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(siteEditedMessageLocator),
                "Site edited alert not visible"
        );
    }

    @Step("Assert visibility of site deleted alert")
    public void assertVisibilityOfSiteDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(siteDeletedMessageLocator),
                "Site deleted alert not visible"
        );
    }

}
